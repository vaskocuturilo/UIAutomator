package sanity;

import org.junit.Test;

import base.BaseClass;
import screens.LoginScreen;

public class SimpleEmptyEmailAndPassword extends BaseClass {
    /**
     * This is simple login automation script with credential.
     */
    @Test
    public void simpleEmptyEmailAndPassword() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.enterCredential("", "")
                .expectErrorMessage("Please, insert an Email and a Password.");
    }
}
