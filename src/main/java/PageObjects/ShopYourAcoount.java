package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopYourAcoount extends BasePage {

    public WebDriver driver;

    By heading = By.xpath("//section[@id='main']//h1[1]");
    By logoutBtn = By.cssSelector(".hidden-sm-down.logout");

    public ShopYourAcoount() throws IOException {
        super();
    }

    
    public WebElement getHeading() throws IOException {
        this.driver = getDriver();
        return driver.findElement(heading);
    }


    public WebElement getLogoutBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(logoutBtn);
    }



}
