package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

// ConfigurationReaderFile >> its help to read /Users/joseph/IdeaProjects/Insider-Case/src/test/resources/config/Configuration.properties
//to get information from the file

//Configuration.properties >> we are adding the test data in this file  ( mostly  temporary test data ) then we are extent this file into confireader file

public final class ConfigurationReaderFile {

    private ConfigurationReaderFile() {
    }

    private static final Properties properties;

    static {
        FileInputStream input=null;
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/config/Configuration.properties";
            input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String keyName) {
        String value = properties.getProperty(keyName);
        if (Objects.isNull(value)) {
            try {
                throw new Exception("Property name " + keyName + "is not found. Please check config.properties");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }

}
