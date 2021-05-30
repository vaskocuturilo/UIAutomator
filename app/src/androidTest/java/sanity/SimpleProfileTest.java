package sanity;

import org.junit.Test;

import base.BaseClass;
import screens.LoginScreen;

public class SimpleProfileTest extends BaseClass {

    /**
     * This is simple automation script for check profile page.
     */
    @Test
    public void simpleProfileTest() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen
                .enterCredential()
                .tapProfileButton()
                .checkThatAllElementsIsAvailable()
                .tapLogoutButton();
    }
}
