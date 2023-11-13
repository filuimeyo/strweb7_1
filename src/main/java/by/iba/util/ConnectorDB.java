package by.iba.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("db",
                Locale.getDefault());
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");

        DriverManager.registerDriver(new org.postgresql.Driver());
        return DriverManager.getConnection(url, user, pass);
    }

}

//Connection cn = ConnectorDB.getConnection();