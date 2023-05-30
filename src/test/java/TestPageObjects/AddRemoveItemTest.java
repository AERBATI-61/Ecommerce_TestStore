package TestPageObjects;
import Base.ExtentManager;
import Base.Hooks;
import PageObjects.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
@Listeners(Base.Listeners.class)

public class AddRemoveItemTest extends Hooks {


    public AddRemoveItemTest() throws IOException {
        super();
    }


    @Test
    public void addRemoveItem() throws InterruptedException, IOException {
        ExtentManager.log("Starting AddRemoveItemTest... ");


        HomePage homePage = new HomePage();
        homePage.getAlertBtn().click();
        homePage.getTestStoreLink().click();


        ShopHomepage shopHomepage = new ShopHomepage();
        ExtentManager.pass("Reached the ShopHomaPage ");
        shopHomepage.getProdOne().click();


        ShopProductPage shopProductPage = new ShopProductPage();
        ExtentManager.pass("Reached the ShopProductPage ");
        Select size = new Select(shopProductPage.getSizeOption());
        size.selectByVisibleText("M");
        ExtentManager.pass("Have Successfully selected product size.");
        shopProductPage.getQuantIncrease().click();
        Thread.sleep(2000);
        shopProductPage.getAddToCartBtn().click();


        ShopContentPanel shopContentPanel = new ShopContentPanel();
        ExtentManager.pass("Reached the ShopContentPanel ");
        Thread.sleep(3000);
        shopContentPanel.getContinueShopBtn().click();
        Thread.sleep(2000);
        shopProductPage.getHomepageLink().click();
        shopHomepage.getProdTwo().click();
        Thread.sleep(1000);
        shopProductPage.getAddToCartBtn().click();
        Thread.sleep(2000);
        shopContentPanel.getCheckoutBtn().click();



        ShoppingCart shoppingCart = new ShoppingCart();
        ExtentManager.pass("Reached the ShoppingCart ");
        Thread.sleep(2000);
        shoppingCart.getDeleteItemOne().click();

        waitForElementInvisible(shoppingCart.getDeleteItemOne(), Duration.ofSeconds(10));
//
//        WebDriverWait wait = new WebDriverWait(WebDriverInstance.getDriver(), Duration.ofSeconds(100));
//        wait.until(ExpectedConditions.invisibilityOf(shoppingCart.getDeleteItemOne()));
        System.out.println(shoppingCart.getTotalAmount().getText());


//        if(Assert.assertEquals(shoppingCart.getTotalAmount().getText(),"$35.70"));
        if(shoppingCart.getTotalAmount().getText().equals("$35.70")){
            ExtentManager.pass("The total amount matches the expected amount.");
        }
        else {
            ExtentManager.fail("Total amount did not match the expected amount. ");
            Assert.assertEquals(shoppingCart.getTotalAmount().getText(), "$32,70");
        }







        Thread.sleep(5000);

    }


}
