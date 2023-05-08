package com.beymen.base;

import com.beymen.data.GetDataOptions;
import com.beymen.data.Variables;
import core.controller.ServiceController;
import core.driver.DriverChrome;
import core.utility.Logging;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BeymenTestController extends ServiceController {

    public DriverChrome driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        try {
            driver = new DriverChrome(GetDataOptions.getParameters().getOptions());
        } catch (Exception e) {
            Logging.fail("fail");
        }

    }

//    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.closeDriver();
        Logging.pass("Closing driver.");
    }



}
