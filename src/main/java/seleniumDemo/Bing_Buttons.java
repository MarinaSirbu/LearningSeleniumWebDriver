package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Bing_Buttons {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.bing.com/account");
        driver.manage().window().maximize();

        // radio button
        driver
                .findElement(By.xpath("//input[@id='adlt_set_moderate']"))
                .click();

        // checkbox
        boolean checkbox1Status = driver
                .findElement(By.id("vsread"))
                .isSelected();

        boolean checkbox2Status = driver
                .findElement(By.id("enAS"))
                .isSelected();

        if(checkbox1Status){
            System.out.println("checkbox1Status is already checked");
        } else {
            driver.findElement(By.id("vsread")).click();
            System.out.println("Successfully checked checkbox1Status");
        }

        if(checkbox2Status){
            System.out.println("checkbox2Status is already checked");
        } else {
            driver.findElement(By.id("enAS")).click();
            System.out.println("Successfully checked checkbox2Status");
        }

        //dropdown
        WebElement dropdownElement = driver
                .findElement(By.xpath("//select[@id='rpp']"));

        dropdownElement
                .sendKeys("30");

        Select select1 = new Select(dropdownElement);
        select1.selectByIndex(1);
        select1.selectByValue("-1");
        select1.selectByValue("50");
        select1.selectByVisibleText("Auto");

        List<WebElement> dropdownOptions = select1.getOptions();
        System.out.println("Total elements are "+dropdownOptions.size());

        for (WebElement e : dropdownOptions) {
            System.out.println(e.getText());
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
