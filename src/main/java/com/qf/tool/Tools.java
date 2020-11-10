package com.qf.tool;

import java.sql.*;

public class Tools {
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql:///maven?character=utf-8", "root", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection conn, PreparedStatement preparedStatement) {

        try {
            if (preparedStatement != null) {

                preparedStatement.close();
                if (conn != null) {
                    conn.close();
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void close(Connection conn, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(conn, preparedStatement);
    }

}
