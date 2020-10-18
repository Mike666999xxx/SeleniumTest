package config;

import test.FirstSeleniumTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();

    public static void main(String[] args) {
        readPropertiesFile();
//        writePropertiesFile();
//        readPropertiesFile();
    }

    public static void readPropertiesFile() {

        try {
            InputStream input = new FileInputStream("C:\\repo\\SeleniumTest\\src\\config\\config.properties");
            prop.load(input);
            System.out.println(prop.getProperty("browser"));
            FirstSeleniumTest.browser = prop.getProperty("browser");
            //System.out.println(FirstSeleniumTest.browser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writePropertiesFile() {
        try {
            OutputStream output = new FileOutputStream("C:\\repo\\SeleniumTest\\src\\config\\config.properties");
            prop.setProperty("browser", "Chrome");
            prop.store(output, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
