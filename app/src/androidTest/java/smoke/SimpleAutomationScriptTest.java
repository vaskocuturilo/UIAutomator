package smoke;

import androidx.test.uiautomator.UiObjectNotFoundException;

import org.junit.Test;

import base.BaseTest;
import screens.LoginScreen;

public class SimpleAutomationScriptTest extends BaseTest {
    /**
     * This automation script check that all elements is present on the login page.
     */
    @Test
    public void simpleAutomationScriptTest() throws UiObjectNotFoundException {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.checkThatAllElementsIsAvailable();
    }
}
