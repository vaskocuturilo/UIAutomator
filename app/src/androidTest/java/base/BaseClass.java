package base;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import utils.StartMainActivityFromHomeScreen;

@RunWith(AllureAndroidJUnit4.class)
public class BaseClass {

    public static UiDevice device;

    @BeforeClass
    public static void initDevice() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Before
    public void start() {
        StartMainActivityFromHomeScreen.startMainActivityFromHomeScreen();
    }
}
