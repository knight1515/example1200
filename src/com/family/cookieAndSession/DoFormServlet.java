package com.family.cookieAndSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author: gzb
 * @date  : 2019年8月14日 下午3:44:35
 *
 */
public class DoFormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //客户端是以UTF-8编码传输数据到服务器端的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        try {
            //让当前的线程睡眠3秒钟，模拟网络延迟而导致表单重复提交的现象
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("向数据库中插入数据："+userName);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
