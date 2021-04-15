package smoke;

import org.junit.Test;

import base.BaseClass;
import screens.LoginScreen;

public class SimpleLoginTest extends BaseClass {

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
