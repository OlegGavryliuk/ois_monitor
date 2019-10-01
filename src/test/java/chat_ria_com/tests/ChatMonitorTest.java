package chat_ria_com.tests;

import Abstract.AbstractPage;
import chat_ria_com.pages.ChatElements;
import chat_ria_com.pages.ChatMethods;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static tools.AbstractString.ADVERT_MEIZU_URL;
import static tools.AbstractString.ID_USER_3;

@Listeners({ SoftAsserts.class})
public class ChatMonitorTest extends AbstractPage {

    private ChatElements chatElements(){return new ChatElements();}
    private ChatMethods chatMethods(){return new ChatMethods();}


    @Test
    public void printConsoleNameTest() {System.out.println("Монітор чату");}

    @Test(priority = 1, description = "Логінимося через admin3 під Юзером-3")
    public void logInToRiaComTest() {
        Assert.assertTrue(loginWithAdmin3(4, ID_USER_3).contains(ID_USER_3),"\n Не вдалось загогінитись ! Некоректний user_id !");
    }

    @Test(priority = 2, dependsOnMethods = {"logInToRiaComTest"}, description = "Відкриваємо сторінку оголошення")
    public void openAdvertPageTest() {
        open(ADVERT_MEIZU_URL);
        chatElements().writeChatAdvertBtn.waitUntil(visible.because("КНОПКА 'НАПИСАТЬ В ЧАТ' НА СТОРІНЦІ ОГОЛОШЕННЯ ПОВИННА ЗАГРУЗИТИСЯ."), 10000);
            if(!(chatElements().writeChatAdvertBtn.isDisplayed())){
                rebootPageJS();
                chatElements().writeChatAdvertBtn.waitUntil(visible.because("Кнопка 'написать в чат' ПІСЛЯ ПЕРЕЗАВАНТАЖЕННЯ СТОРІНКИ ОГОЛОШЕННЯ повинна з'явитися."), 8000);
            }
        Assert.assertTrue(chatElements().writeChatAdvertBtn.isDisplayed(),"Кнопка 'написать в чат' на сторінці оголошення не з'явилася!");
    }

    @Test(priority = 3, dependsOnMethods = {"openAdvertPageTest"}, description = "Перевірка міні-чату")
    public void clickToWriteChatButtonTest() {
        chatMethods().checkMiniChat();

    }



}
