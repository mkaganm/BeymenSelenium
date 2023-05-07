import com.beymen.base.BeymenTestController;
import com.beymen.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class BeymenTests extends BeymenTestController {

    @Test
    @Epic("Beymen Tests")
    @Description("Beymen Tests")

    public void testCase() {

        startTest(new HomePage(driver))
                .openHomePage()
                .acceptCookies()
                .selectGender()
        ;

    }
}
