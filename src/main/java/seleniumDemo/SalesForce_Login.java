package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForce_Login {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://login.salesforce.com/");

        driver.findElement(By.id("username")).sendKeys("surendra9863258@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Batch131QA@123");

        boolean checkboxStatus = driver
                .findElement(By.id("rememberUn"))
                .isSelected();
        if(checkboxStatus){
            System.out.println("\"Remember me\" checkbox is already checked");
        } else {
            driver.findElement(By.id("rememberUn")).click();
        }
        Thread.sleep(2000);

        driver.findElement(By.id("Login")).click();
        Thread.sleep(2000);

        Thread.sleep(2000);
        driver.quit();

    }
}
