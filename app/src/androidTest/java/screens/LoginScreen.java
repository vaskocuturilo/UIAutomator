package screens;

import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

public class LoginScreen extends AbstractClass {

    private final static UiDevice UI_DEVICE = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    private final static UiObject TV_SUBTITLE = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/tv_subtitle"));

    private final static UiObject LOGIN_BUTTON = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/btn_login"));

    private final static UiObject EMAIL_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_email"));

    private final static UiObject PASSWORD_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_password"));

    public final static long LAUNCH_TIME = 5000L;

    public void checkThatAllElementsIsAvailable() {
        checkJoinUsTitleIsAvailable();
        checkEmailFieldIsAvailable();
        checkPasswordFieldPageIsAvailable();
        checkLoginButtonIsAvailable();
    }

    public LogoutScreen enterCredential() {
        setEmailField();
        setPasswordField();
        tapLoginButton();
        tapOkButton();
        return new LogoutScreen();
    }

    private void setEmailField() {
        EMAIL_FIELD.waitForExists(LAUNCH_TIME);
        try {
            EMAIL_FIELD.setText("test@test.ru");
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-setEmailField", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void setPasswordField() {
        PASSWORD_FIELD.waitForExists(LAUNCH_TIME);
        try {
            PASSWORD_FIELD.setText("qwerty123456");
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-setPasswordField", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void tapLoginButton() {
        LOGIN_BUTTON.waitForExists(LAUNCH_TIME);
        try {
            LOGIN_BUTTON.clickAndWaitForNewWindow(LAUNCH_TIME);
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-tapLoginButton", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void checkJoinUsTitleIsAvailable() {
        TV_SUBTITLE.waitForExists(LAUNCH_TIME);
        try {
            TV_SUBTITLE.isEnabled();
        } catch (UiObjectNotFoundException exception) {
            Log.i("MDC-checkJoinUsTitleIsAvailable", "Element is not enabled ");
            throw new RuntimeException("Element is not enabled ", exception);
        }
    }

    private void checkLoginButtonIsAvailable() {
        LOGIN_BUTTON.waitForExists(LAUNCH_TIME);
        try {
            LOGIN_BUTTON.isClickable();
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-checkLoginPageIsAvailable", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void checkEmailFieldIsAvailable() {
        EMAIL_FIELD.waitForExists(LAUNCH_TIME);
        try {
            LOGIN_BUTTON.isClickable();
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-checkEmailFieldIsAvailable", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void checkPasswordFieldPageIsAvailable() {
        PASSWORD_FIELD.waitForExists(LAUNCH_TIME);
        try {
            LOGIN_BUTTON.isClickable();
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-checkPasswordFieldPageIsAvailable", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }
}