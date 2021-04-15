package smoke;

import org.junit.Test;

import base.BaseClass;
import screens.RegisterScreen;

public class SimpleRegisterTest extends BaseClass {
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
