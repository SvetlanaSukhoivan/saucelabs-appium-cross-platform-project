package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static Properties properties;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("Unable to load the configuration file: " + e.getMessage());
            throw new RuntimeException("Configuration file not found or cannot be read", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
