package tools.environment;

public interface Switch {

    /** Керування середовищем (TEST, LOCAL, PROD)*/

    String PAGE = "https://"; // !-NOT local-! | Головна сторінка (оголшення)
    String CHAT = "https://"; // Сторінка чату ('http://test.' | 'https://' | 'http://local.')
    String LANG = "?lang_id=2&"; // Вибір мови чату
    String EMULATOR = "http://local.chat.ria.com/html/index.html"; // ЕМУЛЯТОР ЧАТУ

    /**---------------------------------------------------------------------------------**/



    /****************** Продавець: testseller1@ukr.net ******************/
    ///--трещотка
//        public String SELLER_DIALOG_SHIMANO = "http://local.chat.ria.com/?chat_id=1512"; /// LOCAL
        public String SELLER_DIALOG_SHIMANO = "http://test.chat.ria.com/?chat_id=491711"; /// TEST
//        public String SELLER_DIALOG_SHIMANO = "https://chat.ria.com/?chat_id=3001647"; /// PROD
    /*******************************************************************/

    /****************** Покупець1: testois@ukr.net ******************/
    ///--трещотка
//        public String BUYER_1_DIALOG_SHIMANO = "http://local.chat.ria.com/?chat_id=1512"; /// LOCAL
        public String BUYER_1_DIALOG_SHIMANO = "http://test.chat.ria.com/?chat_id=491711"; /// TEST
//        public String BUYER_1_DIALOG_SHIMANO = "https://chat.ria.com/?chat_id=3001647"; /// PROD

    ///--модуль
//        public String BUYER_1_DIALOG_MEIZU = "http://local.chat.ria.com/?chat_id=288"; /// LOCAL
        public String BUYER_1_DIALOG_MEIZU = "http://test.chat.ria.com/?chat_id=489137"; /// TEST
//        public String BUYER_1_DIALOG_MEIZU = "https://chat.ria.com/?chat_id=1179191"; /// PROD
    /***************************************************************/

    /****************** Покупець3: testi2018@i.ua ******************/
    ///--модуль
//        public String BUYER_3_DIALOG_MEIZU = "http://local.chat.ria.com/?chat_id=773"; /// LOCAL
        public String BUYER_3_DIALOG_MEIZU = "http://test.chat.ria.com/?chat_id=490087"; /// TEST
//        public String BUYER_3_DIALOG_MEIZU = "https://chat.ria.com/?chat_id=1520762"; /// PROD

    /***************************************************************/

}
