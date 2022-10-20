package pages;

import additionalTools.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mikon\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Sleep sleep = new Sleep();

        driver.manage().window().maximize();
        driver.get("https://www.newegg.com/");
        System.out.println(driver.getTitle());
        sleep.sleep(1000);
    }

}
