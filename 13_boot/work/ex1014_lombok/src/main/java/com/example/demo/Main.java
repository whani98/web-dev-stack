package com.example.demo;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",  "myuser", "mypass");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from member");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){

            var user = new Member();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getInt("age"));

            System.out.println(user);
        }
    }
}
