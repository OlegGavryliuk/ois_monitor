package chat_ria_com.pages;

import Abstract.AbstractPage;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import tools.Email;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

@Listeners({ SoftAsserts.class})
public class ChatMethods extends AbstractPage {

    public ChatElements chatMethods(){
        return new ChatElements();
    }
    Email email = new Email();

    private SoftAssert soft;
    @BeforeMethod
    public void beforeMethods() {soft = new SoftAssert();}

    // 1.Робимо клік на кнопку 'Написати в чат'
    public void clickToWriteChatButton(){
        chatMethods().writeChatAdvertBtn.hover().click();
        chatMethods().minichatWrapperIframe.shouldBe(visible)
                .shouldHave(attribute("style","").because("МІНІ-ЧАТ ПОВИНЕН ВІДКРИТИСЯ."));

        if(!(chatMethods().minichatWrapperIframe.isDisplayed())){
            chatMethods().writeChatAdvertBtn.hover().click();
            chatMethods().minichatWrapperIframe.shouldBe(visible)
                    .shouldHave(attribute("style","").because("МІНІ-ЧАТ ПОВИНЕН ВІДКРИТИСЯ."));
            System.out.println("Міні-чат не відкрився після кліка на кнопку 'Написати в чат'  → " + getCurrentTimeStamp());
            email.address("oleg.gavryliuk@ria.com").subject("Міні-чат не відкрився після кліка на кнопку 'Написати в чат'")
                    .message("Міні-чат не відкрився після кліка на кнопку 'Написати в чат'  → " + getCurrentTimeStamp()).send();
            sleep(2000);
            clickToWriteChatButton(); //повтор метода
        }
    }

    //2. Переключаємось у фрейм міні-чату
    public void switchToMiniChatFrame(){
        switchTo().frame(chatMethods().miniChatFrame); //переключаємось у фрейм міні-чату
        chatMethods().fadeLeftPanelButton.shouldBe(visible);
        if (!(chatMethods().fadeLeftPanelButton.isDisplayed())){ //перевіряємо чи в діалозі є кнопка повернення до списку діалогів
            System.out.println("В діалозі відсутня кнопка повернення до списку діалогів → " + getCurrentTimeStamp());
            email.address("oleg.gavryliuk@ria.com").subject("В діалозі відсутня кнопка повернення до списку діалогів")
                    .message("В діалозі відсутня кнопка повернення до списку діалогів  → " + getCurrentTimeStamp()).send();
            sleep(10000);
            switchTo().parentFrame(); //виходимо з фрейму міні-чату
            clickToWriteChatButton(); //робимо клік на кнопку 'Написати в чат'
            switchToMiniChatFrame(); //повтор метода
        }
        else switchTo().parentFrame();
    }

    //3. Закриваємо Міні-чат
    public void closeMiniChat(){
        if(chatMethods().closeMiniChatButton.isDisplayed()){
            chatMethods().closeMiniChatButton.click();
            chatMethods().minichatWrapperIframe.shouldHave(attribute("style","display: none;")
                    .because("МІНІ-ЧАТ ПОВИНЕН ЗАКРИТИСЯ."));
            if(chatMethods().closeMiniChatButton.isDisplayed()){
                System.out.println("Міні-чат не закрився  → " + getCurrentTimeStamp());
                email.address("oleg.gavryliuk@ria.com").subject("Міні-чат не закрився")
                        .message("Міні-чат не закрився  → " + getCurrentTimeStamp()).send();
            }

        }
    }


    // Перевірка міні-чату після кліка на "Написать в чат" з оголошення
    public void checkMiniChat(){
        clickToWriteChatButton();
        sleep(2000);
        switchToMiniChatFrame();
        sleep(2000);
        closeMiniChat();
        sleep(20000);
        checkMiniChat();//повтор метода




//        chatMethods().writeChatAdvertBtn.click();
//        chatMethods().minichatWrapperIframe.shouldBe(exist.because("БЛОК МІНІ-ЧАТУ ПОВИНЕН ЗЯВИТИСЯ НА СТОРІНЦІ."))
//                .shouldHave(attribute("style","").because("БЛОК МІНІ-ЧАТУ ПОВИНЕН БУТИ ВИДИМИМ НА СТОРІНЦІ."));
//        if(!(chatMethods().minichatWrapperIframe.isDisplayed())){
//            System.out.println("Міні-чат не відкрився після  → в " + getCurrentTimeStamp());
//        }
//
//        chatMethods().minichatWrapperIframe.shouldBe(exist.because("БЛОК МІНІ-ЧАТУ ПОВИНЕН ЗЯВИТИСЯ НА СТОРІНЦІ."))
//                .shouldHave(attribute("style","").because("БЛОК МІНІ-ЧАТУ ПОВИНЕН БУТИ ВИДИМИМ НА СТОРІНЦІ."));





//        waitForElementPresence(By.xpath("//div[@class='chat-wrapper mhide']//iframe"));
//        SWITCHtoFRAME(miniChatFrame);
//        if((isElementDisplayed(mainContainer))){
//            ifSpinerVisible(preloader);
//            SWITCHtoPARRENTFRAME();
//            openAnotherPage("https://www.ria.com/");
//            waitFor(2000);
//            allMethodsPage.ifOpenedBigChatButNotMiniChat(minichatHeaderIcon);
//            waitFor(10000);
//            miniChatSimpleAssertMethod(); //зациклюємо
//        }else {
//            email.address("oleg.gavryliuk@ria.com").subject("Chat Monitor. Mini-chat fail !!!").message("Mini-chat fail !!!").send();
//            System.out.println("\t * Міні-Чат лежить → " + getCurrentTimeStamp());
//            SWITCHtoPARRENTFRAME();
//            openAnotherPage("https://www.ria.com/");
//            waitFor(15000);
//            miniChatSimpleAssertMethod(); //зациклюємо
//        }
    }




}
