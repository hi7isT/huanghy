package com.huanghy.servlet;

import com.huanghy.utils.MD5Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.security.provider.MD5;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * <pre>
 *     登录Servlet.
 *     用于处理用户登录等操作
 *
 * </pre>
 */

@WebServlet(name = "LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet{

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String md5 = MD5Utils.md5(password);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();
//        out.println("<table border=1>");
//        out.println("<tr><td>Content:</td></tr>");
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");//加载驱动
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "huanghy", "123456");//创建连接
            stmt = conn.createStatement();//创建statement
            rs = stmt.executeQuery("select * from t_user_info where name = '"+userName+"' and password = '"+md5+"'"); //得到结果集
            while(rs.next()){//遍历结果集
//                JSONArray jsonArray = new JSONArray();
//                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("name",rs.getString("name"));
//                jsonArray.add(jsonObject);
//                out.println(jsonArray);
                out.println("你好,"+rs.getString("name")+"先生，恭喜您登录成功!");//取出列值,返回html标签
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                    rs = null;
                }
                if(stmt != null) {
                    stmt.close();
                    stmt= null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String md5 = MD5Utils.md5(password);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<table border=1>");
        out.println("<tr><td>Content:</td></tr>");
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");//加载驱动
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "huanghy", "123456");//创建连接
            stmt = conn.createStatement();//创建statement
            rs = stmt.executeQuery("select * from t_user_info where name = '"+userName+"' and password = '"+md5+"'"); //得到结果集
            while(rs.next()){//遍历结果集
                out.println("<tr>");
                out.println("<td>" + rs.getString("name") + "</td>");//取出列值
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                    rs = null;
                }
                if(stmt != null) {
                    stmt.close();
                    stmt= null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
