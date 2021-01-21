package com.family.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: gzb
 * @date  : 2019年8月7日 下午2:26:33
 *
 */
public class ServletDemo2 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户输入的内容
        String message = request.getParameter("message");
        response.getWriter().write("您上次的留言是：<br/>" + message);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
