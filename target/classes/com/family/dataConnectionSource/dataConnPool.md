# 数据库连接池

## 总则

1、数据库连接是一种资源，新建、销毁都会浪费资源和时间。  
2、提前建立好一定数量的连接存放在list中，以便应用的时候直接取用，不重新创建。这个list被称为连接池。  
3、数据库连接池负责分配,管理和释放数据库连接,它允许应用程序重复使用一个现有的数据库连接,而不是重新建立一个。  
4、最小连接数:是连接池一直保持的数据库连接,所以如果应用程序对数据库连接的使用量不大,将会有大量的数据库连接资源被浪费。  
5、最大连接数:是连接池能申请的最大连接数,如果数据库连接请求超过次数,后面的数据库连接请求将被加入到等待队列中,这会影响以后的数据库操作。  
6、如果最小连接数与最大连接数相差很大:那么最先连接请求将会获利,之后超过最小连接数量的连接请求等价于建立一个新的数据库连接。  
        不过,这些大于最小连接数的数据库连接在使用完不会马上被释放,他将被放到连接池中等待重复使用或是空间超时后被释放。  
        
## 自己的数据库连接池
编写连接池需实现java.sql.DataSource接口。DataSource接口中定义了两个重载的getConnection方法：

Connection getConnection()
Connection getConnection(String username, String password)
　　实现DataSource接口，并实现连接池功能的步骤：

在DataSource构造函数中批量创建与数据库的连接，并把创建的连接加入LinkedList对象中。
实现getConnection方法，让getConnection方法每次调用时，从LinkedList中取一个Connection返回给用户。
当用户使用完Connection，调用Connection.close()方法时，Collection对象应保证将自己返回到LinkedList中,
而不要把conn还给数据库。Collection保证将自己返回到LinkedList中是此处编程的难点。

    位置 
JdbcPool    //连接池
JdbcUtil    //测试

## 常用的开源数据库连接池
        现在很多WEB服务器(Weblogic, WebSphere, Tomcat)都提供了DataSoruce的实现，即连接池的实现。通常我们把DataSource的实现，
按其英文含义称之为数据源，数据源中都包含了数据库连接池的实现。也有一些开源组织提供了数据源的独立实现：

  DBCP 数据库连接池
  C3P0 数据库连接池
  
在使用了数据库连接池之后，在项目的实际开发中就不需要编写连接数据库的代码了，直接从数据源获得数据库的连接。

### DBCP
　DBCP 是 Apache 软件基金组织下的开源连接池实现，要使用DBCP数据源，需要应用程序应在系统中增加如下两个 jar 文件：

Commons-dbcp.jar：连接池的实现
Commons-pool.jar：连接池实现的依赖库
　　Tomcat 的连接池正是采用该连接池来实现的。该数据库连接池既可以与应用服务器整合使用，也可由应用程序独立使用。

1 dbcpconfig.properties的配置信息  
    /example1200/src/com/family/dataConnectionSource/dbcpconfig.properties

2 代码
    com.family.dataConnectionSource.JdbcUtils_DBCP  数据库连接工具类
    com.family.dataConnectionSource.DataSourceTest  测试类

### C3P0数据源
　　C3P0是一个开源的JDBC连接池，它实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展。目前使用它的开源项目有Hibernate，Spring等。C3P0数据源在项目开发中使用得比较多。

　　c3p0与dbcp区别
1 dbcp没有自动回收空闲连接的功能
2 c3p0有自动回收空闲连接功能

1 在应用程序中加入C3P0连接池
   1.导入相关jar包
    　　　c3p0-0.9.2-pre1.jar、mchange-commons-0.2.jar，如果操作的是Oracle数据库，那么还需要导入c3p0-oracle-thin-extras-0.9.2-pre1.jar
　　2、在类目录下加入C3P0的配置文件：c3p0-config.xml
    /example1200/src/com/family/dataConnectionSource/c3p0-config.xml

2 代码
    JdbcUtils_C3P0

## 配置Tomcat数据源
        在实际开发中，我们有时候还会使用服务器提供给我们的数据库连接池，比如我们希望Tomcat服务器在启动的时候可以帮我们创建一个数据库连接池，  
那么我们在应用程序中就不需要手动去创建数据库连接池，直接使用Tomcat服务器创建好的数据库连接池即可。要想让Tomcat服务器在启动的时候帮我们创建一个数据库连接池，  
那么需要简单配置一下Tomcat服务器。

### JNDI技术简介
    JNDI(Java Naming and Directory Interface)，Java命名和目录接口，它对应于J2SE中的javax.naming包，  
    这 套API的主要作用在于：它可以把Java对象放在一个容器中（JNDI容器），并为容器中的java对象取一个名称，以后程序想获得Java对象，只需 通过名称检索即可。
    其核心API为Context，它代表JNDI容器，其lookup方法为检索容器中对应名称的对象。  
    Tomcat服务器创建的数据源是以JNDI资源的形式发布的，所以说在Tomat服务器中配置一个数据源实际上就是在配置一个JNDI资源，通过查看Tomcat文档，
    我们知道使用如下的方式配置tomcat服务器的数据源：

<Context>
  <Resource name="jdbc/datasource" auth="Container"
            type="javax.sql.DataSource" username="root" password="XDP"
            driverClassName="com.mysql.jdbc.Driver" 
            url="jdbc:mysql://localhost:3306/jdbcstudy"
            maxActive="8" maxIdle="4"/>
</Context>
    服务器创建好数据源之后，我们的应用程序又该怎么样得到这个数据源呢，Tomcat服务器创建好数据源之后是以JNDI的形式绑定到一个JNDI容器中的，
    我们可以把JNDI想象成一个大大的容器，我们可以往这个容器中存放一些对象，一些资源，JNDI容器中存放的对象和资源都会有一个独一无二的名称，应用程序想从JNDI容器中
    获取资源时，只需要告诉JNDI容器要获取的资源的名称，JNDI根据名称去找到对应的资源后返回给应用程序。我们平时做javaEE开发时，服务器会为我们的应用程序创建很多资源，
    比如request对象，response对象，服务器创建的这些资源有两种方式提供给我们的应用程序使用：第一种是通过方法参数的形式传递进来，比如我们在Servlet中写的doPost
    和doGet方法中使用到的request对象和response对象就是服务器以参数的形式传递给我们的。第二种就是JNDI的方式，服务器把创建好的资源绑定到JNDI容器中去，应用程序
    想要使用资源时，就直接从JNDI容器中获取相应的资源即可。

　　对于上面的name="jdbc/datasource"数据源资源，在应用程序中可以用如下的代码去获取
    1 Context initCtx = new InitialContext();
    2 Context envCtx = (Context) initCtx.lookup("java:comp/env");
    3 dataSource = (DataSource)envCtx.lookup("jdbc/datasource");

    此种配置下，数据库的驱动jar文件需放置在tomcat的lib下
    
### 配置Tomcat数据源
　1、在Web项目的WebRoot目录下的META-INF目录创建一个context.xml文件,若是eclipse添加的服务器，就需要这种方式。
  2、在context.xml文件配置tomcat服务器的数据源
  <Context>
   <Resource 
       name="jdbc/datasource" 
       auth="Container"
       type="javax.sql.DataSource" 
       username="root" 
       password="XDP"
       driverClassName="com.mysql.jdbc.Driver" 
       url="jdbc:mysql://localhost:3306/jdbcstudy"
       maxActive="8" 
       maxIdle="4"/>
</Context>

    3、代码位置
    /example1200/src/com/family/dataConnectionSource/JdbcUtils_JNDI.java
    /example1200/src/com/family/dataConnectionSource/JNDITest.java

    4、配置
          <!-- ServletDemo1的Servlet -->
    <servlet>
        <servlet-name>JNDITest</servlet-name>
        <servlet-class>JNDITest</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>JNDITest</servlet-name>
        <url-pattern>/servlet/JNDITest</url-pattern>
    </servlet-mapping>





