package smoke;

import org.junit.Test;

import base.BaseTest;
import screens.LoginScreen;

public class SimpleLoginTest extends BaseTest {

    /**
     * This is simple login automation script.
     */
    @Test
    public void simpleLoginTest() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.enterCredential()
                .tapLogoutButton()
                .checkThatAllElementsIsAvailable();
    }
}
