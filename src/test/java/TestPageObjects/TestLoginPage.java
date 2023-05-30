package TestPageObjects;
import Base.Hooks;
import PageObjects.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(Base.Listeners.class)

public class TestLoginPage extends Hooks {
    public TestLoginPage() throws IOException {
        super();
    }

    @Test
    public void login() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.getEmail().sendKeys("test@test.com");
        loginPage.getPassword().sendKeys("test123");
        loginPage.getLoginBtn().click();
    }



}
