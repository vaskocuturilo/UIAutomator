package screens;

import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Assert;

import model.User;

import static utils.JsonData.getJsonData;

public class LoginScreen extends AbstractClass {

    private final static UiDevice UI_DEVICE = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    private final static UiObject TV_SUBTITLE = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/tv_subtitle"));

    private final static UiObject LOGIN_BUTTON = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/btn_login"));

    private final static UiObject EMAIL_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_email"));

    private final static UiObject PASSWORD_FIELD = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/et_password"));

    private final static UiObject MESSAGE = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/message"));

    private final static String ACCOUNT = "account";

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

    public LoginScreen enterCredential(final String email, final String password) {
        setEmailField(email);
        setPasswordField(password);
        tapLoginButton();

        return this;
    }

    public LoginScreen expectErrorMessage(final String message) {
        try {
            Assert.assertEquals(MESSAGE.getText(), message);
        } catch (UiObjectNotFoundException e) {
            Log.d("MDC-expectErrorMessage", "expectErrorMessage is not found");
            throw new RuntimeException("expectErrorMessage is not found");
        }
        return this;
    }

    private void setEmailField() {
        final User user = getJsonData(ACCOUNT, User.class, ACCOUNT);
        EMAIL_FIELD.waitForExists(LAUNCH_TIME);
        try {
            EMAIL_FIELD.setText(user.getEmail());
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-setEmailField", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void setEmailField(final String emailField) {
        EMAIL_FIELD.waitForExists(LAUNCH_TIME);
        try {
            EMAIL_FIELD.setText(emailField);
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-setEmailField", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void setPasswordField() {
        final User user = getJsonData(ACCOUNT, User.class, ACCOUNT);
        PASSWORD_FIELD.waitForExists(LAUNCH_TIME);
        try {
            PASSWORD_FIELD.setText(user.getPassword());
        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-setPasswordField", "Element is not clickable ");
            throw new RuntimeException("Element is not clickable ", exception);
        }
    }

    private void setPasswordField(final String passwordField) {
        PASSWORD_FIELD.waitForExists(LAUNCH_TIME);
        try {
            PASSWORD_FIELD.setText(passwordField);
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
