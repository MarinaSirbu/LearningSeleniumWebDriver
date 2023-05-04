package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JQueryui_Calendar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        //switch from main page to frame
        WebElement fr1 = driver.findElement(By.className("demo-frame"));
        driver
                .switchTo()
                .frame(fr1);

        //detect text field
        driver
                .findElement(By.id("datepicker"))
                .click();

        //detect calendar
        driver
                .findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"))
                .click();

        //select date
        driver
                .findElement(By.linkText("25")).click();

        //clear text field
        driver
                .findElement(By.id("datepicker"))
                .clear();

        //select next month
        int x = 12;
        while (x >= 1) {
            WebElement element = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")));
            element.click();
            String monthText = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            if(monthText.equalsIgnoreCase("october")){
                break;
            }
            x--;
        }
        driver.findElement(By.linkText("25")).click();

        //switch to main page
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        driver.quit();
    }
}
