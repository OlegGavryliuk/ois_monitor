package chat_ria_com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ChatElements {


    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*  Е Л Е М Е Н Т И  *-*-*-*-*-*-*-*-*-*-*-*-*-*-//



    public SelenideElement writeChatAdvertBtn = $x("//div[@class='contact-user']//a[contains(@class, 'start_chat')]");

    public SelenideElement minichatWrapperIframe = $x("//div[@class='chat-wrapper mhide']/div[2]");

    public SelenideElement miniChatFrame = $x("//div[@class='chat-wrapper mhide']//iframe");

    public SelenideElement closeMiniChatButton = $x("//div[@class='nav-mini-chat']/span[3]");

    public SelenideElement fadeLeftPanelButton = $x("//a[@class='t-cell fade-left-panel dhide']"); //Кнопка повернення до списку діалогів




}


