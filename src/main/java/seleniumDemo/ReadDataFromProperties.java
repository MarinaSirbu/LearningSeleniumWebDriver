package seleniumDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProperties {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/demoSources/locators.properties");
        properties.load(fis);

        String property1 = properties.getProperty("bing.search");
        String property2 = properties.getProperty("bing.button");

        System.out.println(property1);
        System.out.println(property2);

        fis.close();
    }
}
