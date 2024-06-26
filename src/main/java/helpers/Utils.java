package helpers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils extends CommonHelper{
    private static final Properties config ;

    static {
        String configFilePath = System.getProperty("user.dir") + "/config.properties";
        config = new Properties();
        FileInputStream configFile = null;
        try{
            configFile = new FileInputStream(configFilePath);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
         try {
             config.load(configFile);

         } catch (IOException e) {
             e.printStackTrace();
         }
         if (configFile != null) {
             try{
                 configFile.close();
             }catch (IOException exception) {
                 exception.printStackTrace();
             }
         }

    }

    public Utils(WebDriver pDriver) {
        super(pDriver);
    }

    public static String getProperty(String key) { return getProperty(key, null); }

    public static String getProperty(String key, String defaultKey) {
        String value;
//        value = System.getenv(key);
        value = System.getProperty(key);

        if (StringUtils.trimToNull(value) == null) {
            value = config.getProperty(key, defaultKey);
        }
        return value;
    }


    public static void setProperty(String key, String value) {
        System.setProperty(key, value);
    }

}
