package com.example.jdbc_connection;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class JdbcConnectionApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JdbcConnectionApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eslam?user=root&password=Eslam_01226596904");
//
//            //Statement is created from the JDBC Connection object
//            Statement stmt = con.createStatement();
//
//            //A sample DDL statement execution
//            stmt.executeUpdate("create table EMPLOYEE (EMP_ID int auto_increment, EMP_NAME varchar(50) not null, constraint EMPLOYEE_pk primary key (EMP_ID));");
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}