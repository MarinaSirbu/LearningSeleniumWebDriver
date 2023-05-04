package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Bing_Attributes {

    /**
     * Xpath
     * //tag_name[@attribute_type='attribute_value']
     * ex.: //label[@for='sb_form_go']
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();

        //link text
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links){
            String linkText = link.getText();
            if(linkText != null && !linkText.trim().isEmpty() && link.isDisplayed()){
                System.out.println(linkText);
            }
        }
        System.out.println("******************");

        //get attribute (property)
        WebElement element = driver
                .findElement(By.className("sb_form_q"));
        String backgroundColor = element.getCssValue("background-color");

        String textField = element.getAttribute("aria-label");
        Dimension size = element.getSize();
        Point location = element.getLocation();

        System.out.println("Background color: "+backgroundColor);
        System.out.println("Aria-label: "+textField);
        System.out.println("Size: "+size);
        System.out.println(size.getWidth());
        System.out.println(size.getHeight());
        System.out.println("Location: "+location);
        System.out.println(location.getX());
        System.out.println(location.getY());
        System.out.println("******************");


        //search
        driver
                .findElement(By.name("q"))
                .sendKeys("Marina");
        driver
                .findElement(By.cssSelector(".search.icon.tooltip"))
                .click();



        Thread.sleep(2000);
        driver.quit();
    }
}
