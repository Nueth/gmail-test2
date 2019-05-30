package com.gmail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    public static String NAME_DRIVER;
    public static String PATH_DRIVER;

    public static void loadProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("src//main//resources//config.properties");
            prop.load(input);
            NAME_DRIVER = prop.getProperty("name.driver");
            PATH_DRIVER = prop.getProperty("path.driver");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
