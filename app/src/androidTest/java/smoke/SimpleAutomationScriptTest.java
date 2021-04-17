package smoke;

import org.junit.Test;

import base.BaseClass;
import screens.LoginScreen;
import screens.RegisterScreen;

public class SimpleAutomationScriptTest extends BaseClass {
    /**
     * This automation script check that all elements is present on the login and register pages.
     */
    @Test
    public void simpleAutomationScriptTest() {
        LoginScreen loginScreen = new LoginScreen();
        RegisterScreen registerScreen = new RegisterScreen();
        loginScreen.checkThatAllElementsIsAvailable();
        registerScreen.checkThatAllElementsIsAvailable();
    }
}
