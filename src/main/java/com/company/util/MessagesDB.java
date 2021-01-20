package com.company.util;

import com.company.models.Messages;
import com.company.models.User;
import com.company.util.interfaces.IDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessagesDB extends DB {
    Connection connection = null;
    private static MessagesDB instance = null;
    public static MessagesDB getInstance(){
        if(instance == null){
            instance = new MessagesDB();
        }
        return instance;
    }
    private MessagesDB(){
        connection = super.getConnection();
    }

    public ArrayList<Messages> getMessages() {
        try {
            String sql = "SELECT * FROM messages";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Messages> messages = new ArrayList();
            while (rs.next()) {
                Messages messages1 = new Messages(
                        rs.getString("email"),
                        rs.getString("message")
                );
                messages.add(messages1);
            }
            return messages;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void addMessages(String email, String message) {
        try {
            String sql = "INSERT INTO messages(email, message) " +
                    "VALUES(?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, message);
            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }


}
