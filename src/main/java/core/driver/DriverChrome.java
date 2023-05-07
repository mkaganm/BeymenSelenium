package core.driver;

import core.utility.Logging;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverChrome extends Drivers{


    // * default constructor for driver
    public DriverChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // * constructor with options
    public DriverChrome(String[] args){

        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(optionsChrome(args));
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            Logging.fail(e.getMessage());
        }
    }

    // * set options
    public ChromeOptions optionsChrome(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(args);
        return options;
    }


}
