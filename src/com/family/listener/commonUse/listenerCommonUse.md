# 监听器(Listener)在开发中的应用
    监听器在JavaWeb开发中用得比较多，下面说一下监听器(Listener)在开发中的常见应用

## 1、统计当前在线人数
    在JavaWeb应用开发中，有时候我们需要统计当前在线的用户数，此时就可以使用监听器技术来实现这个功能了
    位置：com.family.listener.commonUse.OnLineCountListener
    
## 2、自定义Session扫描器
    当一个Web应用创建的Session很多时，为了避免Session占用太多的内存，我们可以选择手动将这些内存中的session销毁，那么此时也可以借助监听器技术来实现。
    位置：/example1200/src/com/family/listener/commonUse/SessionScanerListener.java