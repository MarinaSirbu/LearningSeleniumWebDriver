package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandles {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.findElement(By.id("newWindowBtn")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> windowsIterator = windows.iterator();
        String firstWindow = windowsIterator.next();
        String secondWindow = windowsIterator.next();

        driver.switchTo().window(secondWindow);
        driver.findElement(By.id("firstName")).sendKeys("Marina");

        driver.switchTo().window(firstWindow);
        driver.findElement(By.id("name")).sendKeys("Marina");

        Thread.sleep(2000);
        driver.quit();
    }
}
