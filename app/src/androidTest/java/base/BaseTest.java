package base;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SdkSuppress;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import utils.StartMainActivityFromHomeScreen;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class BaseTest {

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
