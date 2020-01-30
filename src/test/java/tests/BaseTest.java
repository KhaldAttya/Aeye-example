package tests;

import com.github.KhaldAttya.Aeye.Aeye;
import common.ObjectRepo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


abstract public class BaseTest {

    public static AppiumDriver<?> driver;
    public static String platform;
    public static String deviceName;
    public static String build;
    public static String reposPath;
    public static void init(String platform, String deviceName, String build) {

        BaseTest.platform = platform;
        BaseTest.deviceName = deviceName;
        BaseTest.build = build;
        ObjectRepo.objectRepo(platform, build);
        reposPath = System.getProperty("user.dir") + File.separator + "src"+ File.separator + "test" +
                File.separator + "resources" +File.separator + platform + File.separator + deviceName ;

    }

    @BeforeSuite
    @Parameters({"platform", "deviceName", "build"})
    static void setUpBeforeClass(String platform, String DEVICE_NAME, String build) throws Exception {
        init(platform, DEVICE_NAME, build);
    }

    @BeforeTest
    @Parameters({"appiumVersion", "platformVersion", "platformName", "automationName", "deviceName", "udid", "appActivity", "appPackage", "bundleId", "host"})
    void setUp(String appiumVersion,
               String platformVersion,
               String platformName,
               String automationName,
               String deviceName,
               String udid,
               String appActivity,
               String appPackage,
               String bundleId,
               String host) throws MalformedURLException {

       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, appiumVersion);
       capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
       capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
       capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
       capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
       capabilities.setCapability("udid", udid);
       capabilities.setCapability("appActivity", appActivity);
       capabilities.setCapability("appPackage", appPackage);
       capabilities.setCapability("bundleId", bundleId);

       capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
       capabilities.setCapability("unicodeKeyboard", true);
       capabilities.setCapability("resetkeyboard", true);
       capabilities.setCapability("newCommandTimeout", 4000);
       capabilities.setCapability("adbExecTimeout", 4000);
       capabilities.setCapability("appWaitDuration", 40000);
       driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

   }
    @AfterTest
    void tearDown() throws Exception {
        driver.quit();
    }


}