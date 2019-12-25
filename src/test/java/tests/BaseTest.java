package tests;

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
    public static String actualRepo;
    public static String expectedRepo;
    public static String resultRepo;
    public static String build;

    private static void setRepoPaths() {
        actualRepo = System.getProperty("user.dir") + File.separator + "test-data" + File.separator + platform
                + File.separator + deviceName + File.separator + "actual" + File.separator;

        expectedRepo = System.getProperty("user.dir") + File.separator + "test-data" + File.separator + platform
                + File.separator + deviceName + File.separator + "expected" + File.separator;

        resultRepo = System.getProperty("user.dir") + File.separator + "test-data" + File.separator + platform
                + File.separator + deviceName + File.separator + "result" + File.separator;
    }

    public static void init(String platform, String deviceName, String build) {
        BaseTest.platform = platform;
        BaseTest.deviceName = deviceName;
        BaseTest.build = build;
        ObjectRepo.objectRepo(platform, build);
        setRepoPaths();
    }

    @BeforeSuite
    @Parameters({"platform", "DEVICE_NAME", "build"})
    static void setUpBeforeClass(String platform, String DEVICE_NAME, String build) throws Exception {
        init(platform, DEVICE_NAME, build);
    }

    @AfterClass
    static void tearDownAfterClass() throws Exception {
    }

    public static WebElement element(By element) {
        return driver.findElement(element);

    }


    public RemoteWebElement remoteElement(By element) {
        return (RemoteWebElement) driver.findElement(element);
    }

    @BeforeClass
    @Parameters({"APPIUM_VERSION", "PLATFORM_VERSION", "PLATFORM_NAME", "AUTOMATION_NAME", "DEVICE_NAME", "udid", "appActivity", "appPackage", "bundleId", "host"})
    void setUp(String APPIUM_VERSION,
               String PLATFORM_VERSION,
               String PLATFORM_NAME,
               String AUTOMATION_NAME,
               String DEVICE_NAME,
               String udid,
               String appActivity,
               String appPackage,
               String bundleId,
               String host) throws MalformedURLException {

       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, APPIUM_VERSION);
       capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
       capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
       capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
       capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
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