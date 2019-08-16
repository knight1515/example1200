package com.family.springMvcTest;

/**
 * 
 * @author: gzb
 * @date  : 2019年8月14日 下午4:53:54
 *
 */
@Controller
public class LoginUI {
    //使用RequestMapping注解指明forward1方法的访问路径  
    @RequestMapping("LoginUI/Login2")
    public View forward1(){
        //执行完forward1方法之后返回的视图
        return new View("/springMvcTest/login2.jsp");  
    }
    
    //使用RequestMapping注解指明forward2方法的访问路径  
    @RequestMapping("LoginUI/Login3")
    public View forward2(){
        //执行完forward2方法之后返回的视图
        return new View("/springMvcTest/login3.jsp");  
    } 
}
