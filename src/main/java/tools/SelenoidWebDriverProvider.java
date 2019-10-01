package tools;


import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidWebDriverProvider implements WebDriverProvider {

    @Override
    public RemoteWebDriver createDriver(DesiredCapabilities capabilities) {
//        final DesiredCapabilities browser = DesiredCapabilities.chrome();
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");
        browser.setVersion("76.0");
        browser.setCapability("enableVNC", true);
//        browser.setCapability("sessionTimeout", "30m");

        try {
            RemoteWebDriver driver = new RemoteWebDriver(
//                    URI.create("http://10.1.18.194:4444/wd/hub").toURL(),
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    browser);
//            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://test:test-password@10.1.20.220:4444/wd/hub"), browser);
            driver.manage().window().setSize(new Dimension(1280, 1024));
            return driver;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}