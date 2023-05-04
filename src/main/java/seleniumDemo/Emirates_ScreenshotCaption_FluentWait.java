package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Emirates_ScreenshotCaption_FluentWait {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.emirates.com/english/");
        driver.manage().window().maximize();


        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(60))
                        .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);

        WebElement we = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
        we.click();

        driver.findElement(By.cssSelector("a[data-link='MANAGE']")).click();

        //hover mouse
        WebElement element = driver.findElement(By.xpath("//a[@role='tab'][normalize-space()='Before you fly']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

        Thread.sleep(5000);
        //take screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //store screenshot at specified location
        FileUtils.copyFile(scrFile, new File("src/main/resources/demoSources/Screenshots/screenshot.png"));

        Thread.sleep(2000);
        driver.quit();
    }
}
