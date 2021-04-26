package sanity;

import org.junit.Test;

import base.BaseClass;
import screens.LoginScreen;

public class SimpleInvalidEmail extends BaseClass {

    /**
     * This is simple login automation script with invalid email.
     */
    @Test
    public void simpleInvalidEmail() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.enterCredential("ivalid@email.com", "qwerty123456")
                .expectErrorMessage("Invalid username/password.");
    }
}
