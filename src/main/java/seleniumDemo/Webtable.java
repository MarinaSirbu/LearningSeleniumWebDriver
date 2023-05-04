package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Webtable {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        System.setProperty("wdm.targetPath", "C:\\Program Files (x86)");
        System.setProperty("wdm.operate.delete", "true");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();

        List<WebElement> companyList = driver.findElements(By.xpath("//table[@id='customers']//tr//td[1]"));
        System.out.println("Companies:");
        for(WebElement e : companyList) {
            System.out.println(e.getText());
        }
        System.out.println("**********************");

        System.out.println("First 3 companies:");
        for(int i=0; i<3; i++){
            System.out.println(companyList.get(i).getText());
        }
        System.out.println("**********************");

        System.out.println("Last 3 companies:");
        for (int i = companyList.size()-1; i>companyList.size()-4; i--) {
            System.out.println(companyList.get(i).getText());
        }
        System.out.println("**********************");

        Thread.sleep(2000);
        driver.quit();
    }
}
