package com.qa.utils;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class PropertyManager {
    private static Properties props = new Properties();
    TestUtils utils = new TestUtils();

    public Properties getProps() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties";

        if (props.isEmpty()) {
            try {
                System.out.println("loading config properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load config properties. ABORT!!");
                throw e;
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }
        return props;
    }
}

