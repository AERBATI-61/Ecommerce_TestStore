package Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class BasePage {
    private String url;
    private Properties properties;
    public static String screenShotDestinationPath;


    public BasePage() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/bowser_url.properties");
        properties.load(fileInputStream);
    }


    public static WebDriver getDriver() throws IOException {
        return WebDriverInstance.getDriver();
    }


    public String getUrl(){
        url = properties.getProperty("url");
        return url;
    }




    public static String takeSnapShot(String name) throws IOException {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/files/screenShotFiles/" + timestamp() + ".png";
        screenShotDestinationPath = destinationFile;
        try {
            FileUtils.copyFile(file, new File(destinationFile));
        }catch (IOException e){
            e.printStackTrace();
        }
        return name;
    }



    public static String timestamp(){
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }



    public static String getScreenShotDestinationPath(){
        return screenShotDestinationPath;
    }

    public static void waitForElementInvisible(WebElement element, Duration timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timer);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }




}
