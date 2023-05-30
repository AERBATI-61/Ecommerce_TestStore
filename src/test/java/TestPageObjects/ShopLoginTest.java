package TestPageObjects;

import Base.ExtentManager;
import Base.Hooks;
import PageObjects.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

@Listeners(Base.Listeners.class)

public class ShopLoginTest extends Hooks {


    public ShopLoginTest() throws IOException {
        super();
    }


    @Test
    public void loginTest() throws InterruptedException, IOException {
        ExtentManager.log("Starting loginTest... ");


        HomePage homePage = new HomePage();
        homePage.getAlertBtn().click();
        homePage.getTestStoreLink().click();


        ShopHomepage shopHomepage = new ShopHomepage();
        shopHomepage.getLoginBtn().click();

        FileInputStream fileLocation = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Email_Password.xlsx");

        XSSFWorkbook workBook = new XSSFWorkbook(fileLocation);
        XSSFSheet sheet = workBook.getSheetAt(0);

        Row row1 = sheet.getRow(1);
        Cell r1Cell0 = row1.getCell(0);
        Cell r1Cell1 = row1.getCell(1);

        String emailRow1 = r1Cell0.toString();
        String passwordRow1 = r1Cell1.toString();

        System.out.println(emailRow1 + " : " + passwordRow1);

        ShopLoginPage shopLoginPage = new ShopLoginPage();
        shopLoginPage.getEmail().sendKeys(emailRow1);
        shopLoginPage.getPassword().sendKeys(passwordRow1);
        Thread.sleep(3000);
        shopLoginPage.getLoginBtn().click();


        ShopYourAcoount shopYourAcoount = new ShopYourAcoount();
        try {
            shopYourAcoount.getLogoutBtn().click();
            System.out.println(shopYourAcoount.getHeading().getText());
            ExtentManager.pass("User sing in successfully.");
        }catch (Exception e){
            ExtentManager.fail("User couldn't sign in ");
            Assert.fail();
        }



        Row row2 = sheet.getRow(2);
        Cell r2Cell0 = row2.getCell(0);
        Cell r2Cell1 = row2.getCell(1);

        String emailRow2 = r2Cell0.toString();
        String passwordRow2 = r2Cell1.toString();

        System.out.println(emailRow2 + " : " + passwordRow2);

        shopLoginPage.getEmail().sendKeys(emailRow2);
        shopLoginPage.getPassword().sendKeys(passwordRow2);
        Thread.sleep(3000);
        shopLoginPage.getLoginBtn().click();


        try {
            shopYourAcoount.getLogoutBtn().click();
            System.out.println(shopYourAcoount.getHeading().getText());
            ExtentManager.pass("User sing in successfully.");
        }catch (Exception e){
            ExtentManager.fail("User couldn't sign in ");
            Assert.fail();
        }






    }


}
