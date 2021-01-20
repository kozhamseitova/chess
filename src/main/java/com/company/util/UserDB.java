package com.company.util;

import com.company.models.Messages;
import com.company.models.User;
import com.company.util.interfaces.IDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB extends DB implements IDB<User> {
    Connection connection = null;
    private static UserDB instance = null;

    public static UserDB getInstance(){
        if(instance == null){
            instance = new UserDB();
        }
        return instance;
    }
    private UserDB(){
        connection = super.getConnection();
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            String sql = "SELECT * FROM users WHERE email = ? LIMIT 1";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }



}
