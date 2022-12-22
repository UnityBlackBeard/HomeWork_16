package com.example.homework_16;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "getQuantity", value = "/get-quantity")
public class GetQuantity extends HttpServlet {
    private String message;

    public void init() {
        message = "books info";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        ResultSet jason=null;
        try {
             jason=Util.getQuantity();

            while(jason.next()){
                out.println(jason.getString("id")+" "+jason.getString("quantity"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}