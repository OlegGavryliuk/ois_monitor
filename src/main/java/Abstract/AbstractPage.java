package Abstract;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.TimeoutException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.maven.shared.utils.io.FileUtils;
import org.testng.ITestResult;
import tools.AbstractString;
//import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.TestConfig;
//import org.openqa.selenium.Cookie;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

import static org.testng.AssertJUnit.fail;
import static tools.TestConfig.getDriver;


public abstract class AbstractPage extends TestConfig {

    //Чекаємо, коли URL стане відповідним
    public void waitForUrlIsCurrent(String url) {
        waiter().until(ExpectedConditions.urlContains(url));
    }

    //Логін через "admin3"
    public String loginWithAdmin3(int project_id, String user_id) {
        open("http://admin3.ria.com/common_projects.php?target=login&project_id=" + project_id + "&clientID=" + user_id + "&curr_window=1");
        $x("//div[@class='app-head']//span[contains(text(), 'каб')]").waitUntil(Condition.visible
                .because("ПОВИНЕН З'ЯВИТИСЯ ОСОБИСТИЙ КАБІНЕТ В ХЕДЕРІ САЙТУ."),12000,1000);
        return getPSP_ID();
    }

    //Отримуємо значення конкретних куки PSP_ID
    public String getPSP_ID() {
        String result = "";
        try {result = getDriver().manage().getCookieNamed("PSP_ID").getValue();
        }catch (NullPointerException ignore){}
        return result;
    }

    //Перезавантажуємо сторінку через JS
    public void rebootPageJS(){
        try{
            executeJavaScript("window.location.reload();");
            sleep(500);
        }catch (TimeoutException ignore){}
    }



    //Дата
    public String getCurrentTimeStamp() {return new SimpleDateFormat("HH:mm").format(new Date());}
    public String getCurrentTimeStampForScreanshots() {return new SimpleDateFormat("yy.MM.dd_HH:mm").format(new Date());}

    //Створення скріншотів
//    public void screenShot(String testname,ITestResult result) throws IOException {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            takeScreen(testname);
//        }
//
//    }
//
//    public void takeScreen(String testname) throws IOException {
//        String filename = testname + "_" + getCurrentTimeStampForScreanshots() + ".png";
//
//        TakesScreenshot ts = (TakesScreenshot)getDriver();
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String dest = System.getProperty("user.dir") + "/src/test/resources/screenshots/"; //testscreenshot.png
//        File destination = new File(dest + filename);
//        FileUtils.copyFile(source, destination);
//    }

    //Рандомна строка
    public static String randomString(int countSymbols){
        String s = RandomStringUtils.randomAlphabetic(countSymbols);
        return s;
    }


}
