package seleniumDemo;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Emirates_ScreenRecording_ExplicitWait {
    public static void main(String[] args) throws ATUTestRecorderException {

        /**
         * ATUTestRecorder
         * p1: file location
         * p2: file name
         * p3: true - both video and audio
         *     false - only video
         */

        ATUTestRecorder recorder = new ATUTestRecorder("src/main/resources/demoSources/Recordings", "video", false);
        recorder.start();

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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

        recorder.stop();
    }
}
