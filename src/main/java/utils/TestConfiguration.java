package utils;


import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class TestConfiguration extends Properties {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestConfiguration.class);

    private static Properties properties = new Properties();

    private static String baseUrl;
    private static String token;

    static {
        utils.Logger.init();
        try {
            properties.load(TestConfiguration.class.getClassLoader().getResourceAsStream("dev.properties"));
            init();
            LOGGER.info("Properties were loaded.");
        } catch (IOException e) {
            LOGGER.error("an exception was thrown", e);
        }
    }

    public final Properties getProperties() {
        return properties;
    }

    private static void init() {
        baseUrl = properties.getProperty("baseUrl");
    }

    public static final String getBaseUrl() {
        return baseUrl;
    }

}