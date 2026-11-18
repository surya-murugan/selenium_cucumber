package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {

        try {

            FileInputStream fileInputStream =
                    new FileInputStream(
                            "src/test/resources/config/config.properties"
                    );

            properties = new Properties();

            properties.load(fileInputStream);

            fileInputStream.close();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load config.properties file",
                    e
            );
        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null) {

            throw new RuntimeException(
                    "Property '" + key + "' is not found in config.properties"
            );
        }

        return value.trim();
    }
}