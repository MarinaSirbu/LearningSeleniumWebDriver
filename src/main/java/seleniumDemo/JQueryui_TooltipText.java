package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JQueryui_TooltipText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/tooltip/");
        driver.manage().window().maximize();

        //switch to frame
        WebElement fr2 = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(fr2);

        //get tooltip text
        String title = driver
                .findElement(By.xpath("//input[@id='age']"))
                .getAttribute("title");
        System.out.println("Tooltip text: " + title);

        //switch to main page
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        driver.quit();
    }
}
