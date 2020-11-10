package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.tool.Tools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public List<User> findAll() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///maven", "root", "root");
            String sql = "select * from user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User findById(int id) {
        try {
            connection = Tools.getConnection();
            String sql = "select * from user where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Tools.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            connection = Tools.getConnection();
            String sql = "delete from user where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);
            int i = preparedStatement.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Tools.close(connection,preparedStatement);
        }
        return false;
    }

    @Override
    public boolean insert(User user) {
        try {
            connection = Tools.getConnection();
            String sql = "insert into user values(0,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, user.getName());
            preparedStatement.setObject(2, user.getPassword());
            preparedStatement.setObject(3, user.getGender());
            preparedStatement.setObject(4, user.getEmail());
            int i = preparedStatement.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Tools.close(connection,preparedStatement);
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try {
            connection = Tools.getConnection();
            String sql = "update user set name=?,password=?,gender=?,email=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, user.getName());
            preparedStatement.setObject(2, user.getPassword());
            preparedStatement.setObject(3, user.getGender());
            preparedStatement.setObject(4, user.getEmail());
            preparedStatement.setObject(5, user.getId());
            int i = preparedStatement.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Tools.close(connection,preparedStatement);
        }
        return false;
    }
}
