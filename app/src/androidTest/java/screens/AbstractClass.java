package screens;

import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

public abstract class AbstractClass {

    private final static UiDevice UI_DEVICE = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    private final static UiObject POSITIVE_BUTTON = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/button1"));

    private final static UiObject NEGATIVE_BUTTON = UI_DEVICE.findObject(new UiSelector().resourceIdMatches(".*:id/button2"));

    public final static long LAUNCH_TIME = 5000L;

    public void tapOkButton() {
        try {
            POSITIVE_BUTTON.waitForExists(LAUNCH_TIME);
            POSITIVE_BUTTON.clickAndWaitForNewWindow(LAUNCH_TIME);

        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-tapOkButton", "Ok button is not clickable ");
            throw new RuntimeException("Positive button is not clickable ", exception);
        }
    }

    public void tapCancelButton() {
        try {
            NEGATIVE_BUTTON.waitForExists(LAUNCH_TIME);
            NEGATIVE_BUTTON.clickAndWaitForNewWindow(LAUNCH_TIME);

        } catch (UiObjectNotFoundException exception) {
            Log.d("MDC-tapCancelButton", "Cancel button is not clickable ");
            throw new RuntimeException("Cancel button is not clickable ", exception);
        }
    }
}
