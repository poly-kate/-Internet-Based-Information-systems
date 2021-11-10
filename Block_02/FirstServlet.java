package com.example.demoservlet;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();
        out.print("<h1>List of all students:</h1>");
        try
        {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/students?serverTimezone=Europe/Moscow", "root", "MyNewPass");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students.student");

            out.println("<table>");
            out.println("<tr><th>Number</th><th>Name</th><th>Surname</th></tr>");
            while(rs.next())
            {
                out.println("<tr><td>"+rs.getString(1)+"</td><td>"+
                        rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
            }
            out.println("</table>");
            stmt.close();
            conn.close();
        }
        catch(SQLException e) {
            out.print("<div>"+e.getMessage() +"</div>");
        }

    }


}