package smoke;

import org.junit.Test;

import base.BaseTest;
import screens.LoginScreen;

public class SimpleAutomationScriptTest extends BaseTest {
    /**
     * This automation script check that all elements is present on the login page.
     */
    @Test
    public void simpleAutomationScriptTest() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.checkThatAllElementsIsAvailable();
    }
}
