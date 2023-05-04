package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        //simple alert
        driver
                .findElement(By.xpath("//input[@id='alertexamples']"))
                .click();
        Alert simpleAlert = driver.switchTo().alert();

        String simpleAlertText = simpleAlert.getText();
        System.out.println(simpleAlertText);

        simpleAlert.accept();

        //confirmation alert
        driver
                .findElement(By.xpath("//input[@id='confirmexample']"))
                .click();
        Alert confirmationAlert = driver.switchTo().alert();

        String confirmationAlertText = confirmationAlert.getText();
        System.out.println(confirmationAlertText);

        confirmationAlert.dismiss();

        //prompt alert
        driver
                .findElement(By.xpath("//input[@id='promptexample']"))
                .click();
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
        promptAlert.sendKeys("Marina");

        String promptAlertText = promptAlert.getText();
        System.out.println(promptAlertText);

        promptAlert.accept();

        Thread.sleep(2000);
        driver.quit();
    }
}
