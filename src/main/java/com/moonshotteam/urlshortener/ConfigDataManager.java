package com.moonshotteam.urlshortener;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Class responsible for loading settings in config.properties file.
 */
public final class ConfigDataManager {

    private static final String CONFIG_FILE_PATH = "/config.properties";
    private static final String SHORTENER_CLASS_PROPERTY_NAME = "shortener.class";

    private static UrlShortener urlShortener;

    public static UrlShortener getUrlShortener() {
       if (urlShortener == null) {
           initUrlShortener();
       }
       return urlShortener;
    }

    private static void initUrlShortener()  {
        try {
            Class<?> clazz = Class.forName(getProperty(SHORTENER_CLASS_PROPERTY_NAME));
            urlShortener = (UrlShortener) clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return getProperties().getProperty(key);
    }

    private static Properties properties;
    private static synchronized Properties getProperties() {
        if (properties == null) {
            try (InputStream is = ConfigDataManager.class.getResourceAsStream(CONFIG_FILE_PATH)) {
                if(is!=null){
                    properties = new Properties();
                    properties.load(is);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return properties;
    }
}
