package sanity;

import org.junit.Test;

import base.BaseClass;
import screens.LoginScreen;

public class SimpleEmptyConnectToServer extends BaseClass {

    /**
     * This is simple login automation script without connect to server.
     */
    @Test
    public void simpleEmptyConnectToServer() {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.enterCredential("ivalid@email.com", "qwerty123456")
                .expectErrorMessage("unauthorized");
    }
}
