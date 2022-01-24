package com.example.demoservlet;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.mysql.cj.xdevapi.JsonArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        try
        {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/students?serverTimezone=Europe/Moscow", "root", "MyNewPass");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students.student");

            JSONArray jArray = new JSONArray();
            while (rs.next()) {
                JSONObject jObj = new JSONObject();
                jObj.put("Number",rs.getString(1));
                jObj.put("Name",rs.getString(2));
                jObj.put("Surname",rs.getString(3));
                jArray.add(jObj);
            }
           
            stmt.close();
            conn.close();
           
            out.print(jArray);
            out.flush();
        }
        catch(SQLException e) {
            out.print(e.getMessage());
        }

    }


}