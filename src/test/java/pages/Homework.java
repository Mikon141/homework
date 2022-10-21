package pages;

import additionalTools.Sleep;
import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mikon\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Sleep sleep = new Sleep();
        driver.manage().window().maximize();

        By searchText = By.xpath("//input[@title='Search Site']");
        By searchButton = By.xpath("//button[@class='ico ico-search']");
        By firstElement = By.xpath("//a[@class='item-title']");
        By moreProducts = By.xpath("//button[@class='qty-box-plus fas fa-plus']");
        By addToCard = By.xpath("//button[@class='btn btn-primary btn-wide']");
        By viewCard = By.xpath("//button[@title='View Cart']");
        By promoCode = By.xpath("//div[@class='add-new-accordion-icon']");
        By promoCodeText = By.xpath("//div[@class='summary-actions display-flex']//input[@class='form-text is-wide']");
        By acceptPromoCode = By.xpath("//div[@class='summary-actions display-flex']//button[@class='btn']");

        //testCase_1 - Check if the correct amount of product is saved in the shopping cart
        driver.get("https://www.newegg.com/");
        System.out.println(driver.getTitle());
        sleep.sleep(1000);
        driver.findElement(searchText).sendKeys("Call Of Duty: Vanguard - PlayStation 4");
        driver.findElement(searchButton).click();
        sleep.sleep(6000);
        driver.findElement(firstElement).click();
        sleep.sleep(4000);
        driver.findElement(moreProducts).click();
        sleep.sleep(2000);
        driver.findElement(addToCard).click();
        sleep.sleep(2000);
        driver.findElement(viewCard).click();
        sleep.sleep(4000);

        WebElement howMany = driver.findElement(By.xpath("//div[@class='item-qty']//input[@class='form-text']"));
        String findValue = howMany.getAttribute("value");
        boolean correctValue = findValue.equals("2");

        Assert.assertTrue(correctValue);

        //testCase_2 - Verify that an invalid promo code cannot be entered
        driver.findElement(promoCode).click();
        sleep.sleep(2000);
        driver.findElement(promoCodeText).sendKeys("AAAAAAAAAAAAA");
        sleep.sleep(2000);
        driver.findElement(acceptPromoCode).click();
        sleep.sleep(2000);

        WebElement komBledu = driver.findElement(By.xpath("//div[@class=\"message message-alert margin-top\"]"));
        boolean errorMessage = komBledu.isDisplayed();

        Assert.assertTrue(errorMessage);
    }
}
//Such long sleeps were needed for me to have time to load everything on my old laptop
