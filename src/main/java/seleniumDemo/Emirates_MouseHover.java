package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Emirates_MouseHover {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.emirates.com/english/");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']"))).click();

        driver.findElement(By.cssSelector("a[data-link='MANAGE']")).click();

        //hover mouse
        WebElement element = driver.findElement(By.xpath("//a[@role='tab'][normalize-space()='Before you fly']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

        Thread.sleep(2000);
        driver.quit();
    }
}
