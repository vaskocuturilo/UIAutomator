package screens;

import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

public class LogoutScreen extends AbstractClass {


    private final static UiDevice UI_DEVICE = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    private final static UiObject LOGOUT_BUTTON = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/logout_button"));

    public final static long LAUNCH_TIME = 5000L;

    public LoginScreen tapLogoutButton() {
        try {
            LOGOUT_BUTTON.waitForExists(LAUNCH_TIME);
            LOGOUT_BUTTON.clickAndWaitForNewWindow();
            tapOkButton();
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-tapLogoutButton", "Logout button is not clickable ");
            throw new RuntimeException("Logout button is not clickable ", exception);
        }
        return new LoginScreen();
    }
}
