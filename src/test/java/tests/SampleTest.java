package tests;
import com.github.KhaldAttya.Aeye.Aeye;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.io.IOException;

public class SampleTest extends BaseTest {

    /*
    declare a new Aeye instance
     */
    Aeye aeye = new Aeye();

    @BeforeMethod
    void aeyeSetUp() {
        /*
        Passing path to baseline folder which is containing baseline screenshots and also
        will be target for actual and result screens, Along with driver instance
         */
        aeye = new Aeye(reposPath,driver);
    }
    @Test
    public void test() throws IOException {

        /*
        Taking a full screenshot the screen, save it to actual folder and compare it with 'loginScreen.png' from baseline
         */
        aeye.see("loginScreen")
                .compare();
    }

    @Test
    public void excludeTestWithByElement() throws IOException {
        /*
        Taking a full screenshot the screen, save it to actual folder and compare it with 'loginScreen.png' from baseline
        with exclusion of provided element.
         */
        aeye.see("loginScreenExcluded")
                .exclude(By.xpath("//XCUIElementTypeStatusBar"))
                .compare();
    }
}
