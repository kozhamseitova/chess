package com.company.util;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DB{
    private static Connection connection;

    public DB() {
    }

    public Connection getConnection(){
        if (connection == null){
            Context initalContext = null;
            Connection connection = null;
            try {
                initalContext = new InitialContext();
                Context ctx = (Context) initalContext.lookup("java:comp/env");
                DataSource ds = (DataSource) ctx.lookup("jdbc/chess");
                connection = ds.getConnection();
                DB.connection = connection;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return connection;
    }

}
