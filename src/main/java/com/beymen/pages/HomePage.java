package com.beymen.pages;

import com.beymen.data.GetDataXLSFile;
import core.driver.DriverChrome;
import core.utility.Logging;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    DriverChrome core;

    public HomePage(DriverChrome webDriver) {
        this.core = webDriver;
    }

    private String url = "https://www.beymen.com";

    private final By acceptCookiesButton = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    private final By genderMaleButton = By.xpath("//*[@id=\"genderManButton\"");
    private final By genderFemaleButton = By.xpath("//*[@id=\"genderWomanButton\"]");
    private final By searchBox = By.xpath("//*[@class=\"default-input o-header__search--input\"]");
    private final By searchButton = By.xpath("//*[@class=\"o-header__search--btn bmi-search\"]");

    private final String product1 = GetDataXLSFile.getParameters().getListProduct().get(0);
    private final String product2 = GetDataXLSFile.getParameters().getListProduct().get(1);

    public HomePage openHomePage() {
        core.open(url);
        Logging.pass("Open Home Page");
        return this;
    }

    public HomePage acceptCookies() {
        core.getElement(acceptCookiesButton).click();
        Logging.pass("Click accept cookies");
        return this;
    }

    public HomePage selectGender() {
        core.getElement(genderFemaleButton).click();
        Logging.pass("Click gender button");
        return this;
    }

    public HomePage searchProduct1() {
        core.getElement(searchBox).sendKeys(product1);
        Logging.pass("Search box send keys : " + product1);
        return this;
    }

    public HomePage cleanSearchBox() {
        core.cleanText(searchBox, product1.length());
        Logging.pass("Click backspace x" +product1.length());
        return this;
    }

    public HomePage searchProduct2() {
        core.getElement(searchBox).sendKeys(product2);
        Logging.pass("Search box send keys : " + product2);
        return this;
    }

    public HomePage searchClickEnter() {
        core.clickEnter(searchBox);
        Logging.pass("Clicking enter");
        return this;
    }

    public ProductPage getProductPage() {
        return new ProductPage(core);
    }




}
