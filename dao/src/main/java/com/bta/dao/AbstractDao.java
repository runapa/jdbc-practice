package com.bta.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractDao implements Dao{
    protected static Properties getConnectionProperties(){
        Properties properties = new Properties();
        try (InputStream inputStream = UserAccountDao.class.getClassLoader().getResourceAsStream("config.properties")){
            properties.load(inputStream);
        }catch(IOException e){
            e.printStackTrace();
        }
        return properties;
    }

    protected static Connection getConnection() throws SQLException {
        Properties properties = getConnectionProperties();
        return DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.username"),
                properties.getProperty("db.password")
        );
    }
}
