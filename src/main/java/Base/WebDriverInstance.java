package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverInstance {


    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (driver.get() == null){
            try{
                driver.set(createDriver());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return driver.get();
    }


    public static WebDriver createDriver() throws IOException {
        WebDriver driver = null;
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/bowser_url.properties");
        properties.load(fileInputStream);

        if (properties.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (properties.getProperty("browser").equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }


    public static void cleanUpDriver(){
        driver.get().quit();
        driver.remove();
    }
}
