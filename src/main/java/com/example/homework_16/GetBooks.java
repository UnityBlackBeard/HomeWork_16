package com.example.homework_16;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "getbooks", value = "/get-books")
public class GetBooks extends HttpServlet {
    private String message;

    public void init() {
        message = "books info";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        ResultSet jason=null;
        try {
            jason=Util.getBooks();

            while(jason.next()){
                out.println(jason.getString("book")+" "+jason.getString("author"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}