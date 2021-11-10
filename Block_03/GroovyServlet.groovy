package com.example.demoservlet

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.sql.Sql

import org.json.simple.JSONObject


    def number = request.getParameter("nm")
    int num
    try {
         num = Integer.parseInt(number)
    }
    catch(NumberFormatException e)
    {
        println(e.getMessage())
    }

    def sql = Sql.newInstance("jdbc:mysql://localhost:3306/students?serverTimezone=Europe/Moscow", "root",
            "MyNewPass", "com.mysql.jdbc.Driver")

    def json = new JSONObject();
    sql.eachRow("{call students.new_procedure(?)}", [num]) {


            row -> json.put("ave_rating",row.ave_rating);

    }
    print(json)




