package com.example.demoservlet;

//import com.sun.tools.javac.util.Convert;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SecondServlet", value = "/SecondServlet")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{

            int number = Integer.parseInt(request.getParameter("nm"));

            out.println("<h2> Student "+number+" rating is:</h2>");

            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection conn = DriverManager.getConnection
                   ("jdbc:mysql://localhost:3306/students?serverTimezone=Europe/Moscow", "root", "MyNewPass");

            CallableStatement stmt = conn.prepareCall("{call students.new_procedure(?)}");
            stmt.setInt(1, number);
            ResultSet rs = stmt.executeQuery();

            out.print("<div>");
            while(rs.next())
            {
                String res;
                res = rs.getString(1);
                if (res == null) res = "Invalid student number!";
                out.println(res);
            }
            out.println("</div>");
            stmt.close();
            conn.close();
        }
        catch(SQLException e) {
            out.print("<div>"+e.getMessage() +"</div>");
        }
        catch (NumberFormatException e)
        {
            out.println("<div> Invalid input </div>");
        }

        out.close();

    }

}






