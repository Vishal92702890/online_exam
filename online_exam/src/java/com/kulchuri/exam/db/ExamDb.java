package com.kulchuri.exam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExamDb {

    private static final String USER = "root";
    private static final String PASSWORD = "kulchuri";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/exam_db";
    private static Connection conn = null;

    private ExamDb() {
    }

    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed:" + e);
        }
    }

    public static Connection getExamDb() {
        return conn;
    }

    public static void main(String[] args) {
        System.out.println(getExamDb());
    }
}
