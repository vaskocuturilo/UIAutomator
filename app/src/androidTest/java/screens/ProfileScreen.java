package screens;

import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

public class ProfileScreen extends AbstractClass {

    private final static UiDevice UI_DEVICE = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());


    private final static UiObject LOGOUT_BUTTON = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/logout_button"));

    private final static UiObject USERNAME_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_user"));

    private final static UiObject EMAIL_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_email"));

    private final static UiObject FIRST_NAME_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_full_name"));

    private final static UiObject LAST_NAME_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_last_name"));

    private final static UiObject SAVE_BUTTON = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/btn_save"));

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

    public ProfileScreen checkThatAllElementsIsAvailable() {
        checkUserNameFieldIsAvailable();
        checkEmailFieldIsAvailable();
        checkFirstNameFieldIsAvailable();
        checkLastNameFieldIsAvailable();
        checkSaveButtonIsClickable();
    return this;
    }

    private void checkUserNameFieldIsAvailable() {
        USERNAME_FIELD.waitForExists(LAUNCH_TIME);
        try {
            USERNAME_FIELD.isEnabled();
        } catch (UiObjectNotFoundException exception) {
            Log.i("MDC-checkUserNameFieldIsAvailable", "Element is not enabled ");
            throw new RuntimeException("Element is not enabled ", exception);
        }
    }

    private void checkEmailFieldIsAvailable() {
        EMAIL_FIELD.waitForExists(LAUNCH_TIME);
        try {
            EMAIL_FIELD.isEnabled();
        } catch (UiObjectNotFoundException exception) {
            Log.i("MDC-checkEmailFieldIsAvailable", "Element is not enabled ");
            throw new RuntimeException("Element is not enabled ", exception);
        }
    }

    private void checkFirstNameFieldIsAvailable() {
        FIRST_NAME_FIELD.waitForExists(LAUNCH_TIME);
        try {
            FIRST_NAME_FIELD.isEnabled();
        } catch (UiObjectNotFoundException exception) {
            Log.i("MDC-checkFirstNameFieldIsAvailable", "Element is not enabled ");
            throw new RuntimeException("Element is not enabled ", exception);
        }
    }

    private void checkLastNameFieldIsAvailable() {
        LAST_NAME_FIELD.waitForExists(LAUNCH_TIME);
        try {
            LAST_NAME_FIELD.isEnabled();
        } catch (UiObjectNotFoundException exception) {
            Log.i("MDC-checkLastNameFieldIsAvailable", "Element is not enabled ");
            throw new RuntimeException("Element is not enabled ", exception);
        }
    }

    private void checkSaveButtonIsClickable() {
        SAVE_BUTTON.waitForExists(LAUNCH_TIME);
        try {
            SAVE_BUTTON.isClickable();
        } catch (UiObjectNotFoundException exception) {
            Log.i("MDC-checkSaveButtonIsClickable", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }
}
