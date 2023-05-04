package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Bing_AutoSuggestions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();

        driver
                .findElement(By.name("q"))
                .sendKeys("Marina");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='sa_ul']")));
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@id='sa_ul']//li"));
        for(WebElement e : suggestions) {
            String text = e.getAttribute("outerText");
            String newText = text.replaceAll("\n",": ");
            System.out.println(newText);
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
