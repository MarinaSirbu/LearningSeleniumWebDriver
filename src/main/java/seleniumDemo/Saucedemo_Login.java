package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Saucedemo_Login {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver
                .findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver
                .findElement(By.cssSelector("#password"))
                .sendKeys("secret_sauce");
        driver
                .findElement(By.xpath("//input[@id='login-button']"))
                .click();

        Thread.sleep(2000);
        driver.quit();
    }
}
