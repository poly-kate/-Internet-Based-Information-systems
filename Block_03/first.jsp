<%--
  Created by IntelliJ IDEA.
  User: kate_
  Date: 04.11.2021
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.*" %>
<%@page import="java.sql.*" %>
<%@ page import="com.mysql.cj.xdevapi.JsonArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.JSONArray" %>

<html>
<head>
    <title>First</title>
</head>
<body>
<%
    try {
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
    }catch(SQLException e) {
        out.print("<div>"+e.getMessage() +"</div>");
    }

%>
</table>
</body>
</html>
