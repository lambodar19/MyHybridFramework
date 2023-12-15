package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static Properties loadProperty() {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream(new File("./src/test/resources/config.properties"));
            properties.load(file);
            return properties;
        } catch (Exception e) {
            System.out.println("Exception occurred in loadProperty method: " + e.getMessage());
            return null;
        }
    }
}