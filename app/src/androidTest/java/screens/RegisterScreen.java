package screens;

import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

public class RegisterScreen extends AbstractClass {

    private final static UiDevice UI_DEVICE = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    private final static UiObject SWIPE_RIGHT = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/swipeRight"));

    private final static UiObject NAME_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_name"));

    private final static UiObject EMAIL_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_email"));

    private final static UiObject PASSWORD_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_password"));

    private final static UiObject RE_PASSWORD_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_repassword"));

    private final static UiObject REGISTER_BUTTON = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/btn_register"));

    public final static long LAUNCH_TIME = 5000L;

    public LogoutScreen enterRegisterInformation() {
        tapSwipeRight();
        setFullNameField();
        setEmailField();
        setPasswordField();
        setRePasswordField();
        tapLoginButton();
        tapOkButton();
        return new LogoutScreen();
    }

    private void tapSwipeRight() {
        SWIPE_RIGHT.waitForExists(LAUNCH_TIME);
        try {
            SWIPE_RIGHT.clickAndWaitForNewWindow(LAUNCH_TIME);
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-tapSwipeRight", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void setFullNameField() {
        NAME_FIELD.waitForExists(LAUNCH_TIME);
        try {
            NAME_FIELD.setText("Vasko Cuturilo");
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-setFullNameField", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void setEmailField() {
        EMAIL_FIELD.waitForExists(LAUNCH_TIME);
        try {
            EMAIL_FIELD.setText(createEmailForNewUser());
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-setEmailField", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void setPasswordField() {
        PASSWORD_FIELD.waitForExists(LAUNCH_TIME);
        try {
            PASSWORD_FIELD.setText("qwerty12345");
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-setPasswordField", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void setRePasswordField() {
        RE_PASSWORD_FIELD.waitForExists(LAUNCH_TIME);
        try {
            RE_PASSWORD_FIELD.setText("qwerty12345");
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-setRePasswordField", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void tapLoginButton() {
        REGISTER_BUTTON.waitForExists(LAUNCH_TIME);
        try {
            REGISTER_BUTTON.clickAndWaitForNewWindow(LAUNCH_TIME);
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-tapLoginButton", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }
}
