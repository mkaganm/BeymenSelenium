package com.beymen.pages;

import core.driver.DriverChrome;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    DriverChrome core;

    public HomePage(DriverChrome webDriver) {
        this.core = webDriver;
    }

    private String url = "https://www.beymen.com";

    private final By acceptCookiesButton = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    private final By genderMaleButton = By.xpath("//*[@id=\"genderManButton\"");
    private final By genderFemaleButton = By.xpath("//*[@id=\"genderWomanButton\"]");



    public HomePage openHomePage() {
        core.open(url);
        return this;
    }

    public HomePage acceptCookies() {
        core.getElement(acceptCookiesButton).click();
        return this;
    }

    public HomePage selectGender() {
        core.getElement(genderFemaleButton).click();
        return this;
    }



}
