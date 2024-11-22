package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    public static String getPropertyString(String fileName) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            properties.load(fis);
            String host = properties.getProperty("db.host");
            String dbname = properties.getProperty("db.name");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");
            String port = properties.getProperty("db.port");
            return "jdbc:mysql://" + host + ":" + port + "/" + dbname + "?user=" + user + "&password=" + password;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
