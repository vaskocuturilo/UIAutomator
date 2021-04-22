package base;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.LogcatRule;
import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import utils.StartMainActivityFromHomeScreen;

@Ignore("Ignoring BaseClass")
@RunWith(AllureAndroidJUnit4.class)
public class BaseClass {

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, "screenshot-failure");

    @Rule
    public LogcatRule logcatRule = new LogcatRule();

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
