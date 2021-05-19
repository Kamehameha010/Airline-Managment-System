package com.cr.tools;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class FileProperties {

    public static void writeFile(String filename, HashMap<String, String> propities, String comments)
            throws IOException {
        var prop = new Properties();
        propities.forEach((key, value) -> prop.setProperty(key, value));
        prop.store(new FileWriter(filename), comments);
    }

    public static Properties readFile(String filename) throws IOException {
        var properties = new Properties();
        properties.load(new FileReader(filename));
        return properties;
    }
}