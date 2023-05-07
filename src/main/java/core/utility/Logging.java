package core.utility;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;

import java.util.Arrays;

public class Logging {

    static {
        init();
    }

    private static final Logger LOGGER = LogManager.getLogger(Logging.class);

    private Logging() {

    }

    private static void init() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    public static <T> void pass(T message) {
        Allure.step(message.toString(), Status.PASSED);
        LOGGER.info(message);
    }

    public static <T> void warning(T message) {
        Allure.step(message.toString(), Status.BROKEN);
        LOGGER.warn(message);
    }

    public static <T> void fail(T message) {
        fail(message, null);
    }

    public static <T> void fail(T message, Exception e) {
        String stackTrace = "";
        if (e != null)
            stackTrace = Arrays.toString(e.getStackTrace());
        Allure.step(message + stackTrace, Status.FAILED);
        LOGGER.error(message);
        Assert.fail(message.toString(), e);
    }

}
