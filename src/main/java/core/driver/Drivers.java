package core.driver;

import core.utility.Logging;
import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Drivers {

    // * webdriver variable for all drivers
    public WebDriver driver;


    // * this method for opening url
    // * All driver class using this method
    public void open(String url){
        driver.get(url);
    }
    // * click method
    public void clickById(String id){
        try {
            driver.findElement(By.id(id)).click();
        } catch (Exception e) {
            Logging.fail(e.getMessage());
        }

    }


    public WebElement getElement(By elementName){
        try {
            return driver.findElement(elementName);
        } catch (Exception e) {
            Logging.fail(e.getMessage());
            return null;
        }
    }

    public List<WebElement> getElements(By elementName){
        try {
            return driver.findElements(elementName);
        } catch (Exception e) {
            Logging.fail(e.getMessage());
            return Collections.emptyList();
        }
    }

    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Logging.fail(e.getMessage());
        }
    }

    public void cleanText(By elementName, int textSize){
        try {
            driver.findElement(elementName).clear();

            for (int i = 0; i < textSize; i++) {

                driver.findElement(elementName).sendKeys(Keys.BACK_SPACE);
            }
            Thread.sleep(1000);

        } catch (Exception e) {
            Logging.fail(e.getMessage());
        }
    }

    public void clickEnter(By elementName) {
        try {

            driver.findElement(elementName).sendKeys(Keys.ENTER);

        } catch (Exception e) {
            Logging.fail(e);
        }
    }

    public void closeDriver() {
        driver.close();
    }

    public void control(boolean statement, String onTrue, String onFalse) {
        if (statement) {
            Logging.pass(onTrue);
        } else {
            Logging.fail(onFalse);
        }
    }

    public void wait1s(){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            Logging.fail(e.getMessage());
        }
    }

}
