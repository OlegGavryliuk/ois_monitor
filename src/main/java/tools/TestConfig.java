package tools;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static com.codeborne.selenide.Configuration.AssertionMode.SOFT;


public class TestConfig {

    private String runType = "docker"; //docker or local for run tests

    @Parameters({"session_timeout"})
    @BeforeTest
    public void setUp(@Optional("session_timeout") String session_timeout){

        Configuration.assertionMode = SOFT;
        Configuration.browserSize = "1280x1024";
        Configuration.timeout = 6000;

        switch (runType) {
            case ("local"):
                Configuration.browser = "chrome";
                Configuration.holdBrowserOpen = false;
                Configuration.headless = true;
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver75");
                System.setProperty("selenide.browser", "chrome");
                break;

            case ("docker"):
                Configuration.browser = "tools.SelenoidWebDriverProvider";
                Configuration.holdBrowserOpen = false;
                break;
        }
    }

    public static WebDriver getDriver(){
        return WebDriverRunner.getWebDriver();
    }

    public WebDriverWait waiter(){
        return new WebDriverWait(getDriver(),10,500);
    }

}
