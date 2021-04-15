package smoke;

import org.junit.Test;

import base.BaseClass;
import screens.LoginScreen;

public class SimpleAutomationScriptTest extends BaseClass {
    /**
     * This automation script check that all elements is present on the login page.
     */
    @Test
    public void simpleAutomationScriptTest() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.checkThatAllElementsIsAvailable();
    }
}
