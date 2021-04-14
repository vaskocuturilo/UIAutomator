package smoke;

import org.junit.Test;

import base.BaseTest;
import screens.RegisterScreen;

public class SimpleRegisterTest extends BaseTest {
    /**
     * This is simple register automation script. This automation script create a new user.
     */
    @Test
    public void simpleRegisterTest() {
        RegisterScreen registerScreen = new RegisterScreen();
        registerScreen.enterRegisterInformation()
                .tapLogoutButton()
                .checkThatAllElementsIsAvailable();
    }
}
