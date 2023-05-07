package core.controller;

import core.utility.Command;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ServiceController {

    public ServiceController() {
    }

    public <T> T startTest(T page) {
        ThreadLocal<T> tl = new ThreadLocal();
        tl.set(page);
        return tl.get();
    }

    @BeforeSuite(alwaysRun = true)
    public void removeReportHistory() {
        Command.runCommand("allure generate --clean --output allure-results");
    }

    @AfterSuite(alwaysRun = true)
    public void openAllureReport() {
        Command.runCommand("allure serve -h localhost");
    }
}
