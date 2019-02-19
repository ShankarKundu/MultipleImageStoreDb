package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbServlet {
    public static Connection getCon() {
        Connection con = null;
        ResultSet rs= null;
        try {
// Register driver
            Class cls = Class.forName("com.mysql.jdbc.Driver");
// establsih the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return con;
    }// getconnection()

}
