package tools;

import tools.environment.Switch;

public interface Urls extends Switch {

    /* Сторінки */
    String CHAT_EMULATOR_URL = "http://local.chat.ria.com/html/index.html"; // ЕМУЛЯТОР ЧАТУ
    String RIA_COM_URL = PAGE + "www.ria.com/";
    String CHAT_MAIN_PAGE = CHAT + "chat.ria.com"+LANG+"/1/0/0";
    String MINI_CHAT_PAGE = RIA_COM_URL; // EMULATOR або RIA_COM_URL (міняємо значення)
    String LOG_OUT_URL = PAGE + "www.ria.com/index/logout/"; // URL для розлогіна на сторінці

    /* Оголошення */
    String ADVERT_MEIZU_URL = PAGE + "www.ria.com/ru/mobile-phones-dyspleynyy-modul-meizu-m2-note-ne-rabochyy-53876555.html"; // Дисплейний модуль Meizu

    //USERS_ID
    String ID_USER_3 = "8629288"; // Юзер-3




}
