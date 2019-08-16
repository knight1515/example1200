package com.family.dataConnectionSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author: gzb
 * @date  : 2019年8月8日 下午5:54:48
 */
public class JNDITest extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = JdbcUtils_JNDI.getConnection();
            String sql = "insert into test1(name) values(?)";
            st = conn.prepareStatement(sql);
            st.setString(1, "gacl");
            st.executeUpdate();
            //获取数据库自动生成的主键
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            JdbcUtils_JNDI.release(conn, st, rs);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
