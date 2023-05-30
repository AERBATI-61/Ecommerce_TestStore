package TestPageObjects;
import Base.ExtentManager;
import Base.Hooks;
import PageObjects.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners(Base.Listeners.class)

public class OrderCompleteTest extends Hooks {

    public OrderCompleteTest() throws IOException {
        super();
    }

    @Test
    public void orderComplete() throws IOException, InterruptedException {
        ExtentManager.log("Starting orderComplete... ");
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
        shopContentPanel.getCheckoutBtn().click();


        ShoppingCart shoppingCart = new ShoppingCart();
        ExtentManager.pass("Reached the ShoppingCart ");
        Thread.sleep(2000);
        shoppingCart.getHavePromo().click();
        shoppingCart.getPromoTextbox().sendKeys("20OFF");
        shoppingCart.getPromoAddBtn().click();
        Thread.sleep(2000);
        shoppingCart.getProceedCheckoutBtn().click();



        OrderFormPersInfo orderFormPersInfo = new OrderFormPersInfo();
        ExtentManager.pass("Reached the OrderFormPersInfo ");
        orderFormPersInfo.getGenderMr().click();
        orderFormPersInfo.getFirstNameField().sendKeys("Jhon");
        orderFormPersInfo.getLastnameField().sendKeys("Smith");
        orderFormPersInfo.getEmailField().sendKeys("jhonsmith@test.com");
        orderFormPersInfo.getTermsConditionsCheckbox().click();
        Thread.sleep(2000);
        orderFormPersInfo.getContinueBtn().click();



        OrderFormDelivery orderFormDelivery = new OrderFormDelivery();
        ExtentManager.pass("Reached the OrderFormDelivery ");
        orderFormDelivery.getAddressField().sendKeys("Turkey");
        orderFormDelivery.getCityField().sendKeys("istanbul");
        Select state = new Select(orderFormDelivery.getStateDropdown());
        state.selectByVisibleText("New York");
        orderFormDelivery.getPostcodeField().sendKeys("77012");
        Thread.sleep(2000);
        orderFormDelivery.getContinueBtn().click();


        OrderFormShippingMethod orderFormShippingMethod = new OrderFormShippingMethod();
        ExtentManager.pass("Reached the OrderFormShippingMethod ");
        orderFormShippingMethod.getDeliveryMsgTextbox().sendKeys("If you would like to add a comment.");
        Thread.sleep(2000);
        orderFormShippingMethod.getContinueBtn().click();


        OrderFormPayment orderFormPayment = new OrderFormPayment();
        ExtentManager.pass("Reached the OrderFormPayment ");
        orderFormPayment.getPayByCheckRadioBtn().click();
        orderFormPayment.getTermsConditionsCheckbox().click();
        Thread.sleep(2000);
        orderFormPayment.getOrderBtn().click();


        Thread.sleep(5000);

    }

}
