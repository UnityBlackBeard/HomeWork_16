package com.example.homework_16;

import jakarta.servlet.annotation.WebServlet;

import java.sql.*;
import java.util.Properties;


public class Util {
    public static Connection makeMagic (){
        String url= "jdbc:postgresql://localhost:5432/test1";
        String user="postgres";
        String pass="********";
        Properties props = new Properties();
        props.setProperty("user",user );
        props.setProperty("password",pass);
        //props.setProperty("ssl", "false");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }


        Connection conn=null;
        try {
            conn = DriverManager.getConnection(url, props);
        }catch (SQLException e){
            System.out.println("все, кабзда");
        }

        return conn;
    }

    public static ResultSet getQuantity() throws SQLException {

        Statement statem=  makeMagic().createStatement();

        try{
            return statem.executeQuery("Select vb.id, vb.quantity from view_books vb");
        }finally {
           // statem.close();
        }

    }
    public static ResultSet getBooks() throws SQLException {

        Statement statem=  makeMagic().createStatement();

        try{
            return statem.executeQuery("Select vb.book, vb.author from view_books vb");
        }finally {
         //   statem.close();
        }

    }
}
