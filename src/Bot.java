import org.telegram.telegrambots.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.send.SendVideo;
import org.telegram.telegrambots.api.objects.File;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.Video;
import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;
import org.telegram.telegrambots.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiValidationException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by soshiant on 5/1/2017.
 */

public class Bot extends TelegramLongPollingBot {
    //    public  static final String CHANNEL_ID="@mj1992mj1992";
    List matn=new ArrayList<String >();
    boolean dido=true;
    Geto get=new Geto();
    long ID;
    String hardware ="";
    String share;
    @Override
    public void onUpdateReceived(Update update) {
//        System.out.println(update.getInlineQuery());
//        System.out.println(update);

        if(update.hasChosenInlineQuery()){
//            matn.add("https://t.me/digiman/97");
//            System.out.println(update.getMessage().getText());
//            hardware=update.getMessage().getText();
//            System.out.println("here1");
            if(dido)
                try {
                    share=  get.sendGet("https://digimanshop.ir/upone.php?hardi="+hardware.substring(7)+
                        "&usi="+update.getChosenInlineQuery().getFrom().getUserName());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            SendMessage sm = new SendMessage();

            sm .setChatId(ID)

                    .enableMarkdown(true).setText("تعداد اشتراک گذاری ها"+String.valueOf(share));

//            sm.setReplyMarkup(sidebyside());

            try {
                // Send the message
                sendMessage(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }}
//            InlineQueryResultArticle mordor =new InlineQueryResultArticle();
//            mordor.setId(update.getChosenInlineQuery().getResultId());
//            mordor.setTitle("برای تایید به اشتراک گذاری اینجا رو بزن");
//            InputTextMessageContent hobit =new InputTextMessageContent() ;
//            hobit.setMessageText("https://t.me/digiman/97");
//            mordor.setInputMessageContent(hobit);
//            AnswerInlineQuery bolo = new AnswerInlineQuery();
//            bolo.setResults(mordor);
//            bolo.setInlineQueryId(update.getChosenInlineQuery().getResultId());
//            try {
//                System.out.println("https://digimanshop.ir/upone.php?hardi="+hardware.substring(7)+
//                        "&usi="+update.getChosenInlineQuery().getFrom().getUserName());
//                answerInlineQuery(bolo);;
//                get.sendGet("https://digimanshop.ir/upone.php?hardi="+hardware.substring(7)+
//                        "&usi="+update.getChosenInlineQuery().getFrom().getUserName());
//
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }




        if( update.hasInlineQuery()){

            System.out.println(update.getInlineQuery());
            InlineQueryResultArticle mordor =new InlineQueryResultArticle();

            mordor.setId(update.getInlineQuery().getId());
            mordor.setTitle("برای تایید به اشتراک گذاری اینجا رو بزن");
            InputTextMessageContent hobit =new InputTextMessageContent() ;
            hobit.setMessageText("https://t.me/digiman/97");
            mordor.setInputMessageContent(hobit);
            AnswerInlineQuery bolo = new AnswerInlineQuery();
            bolo.setResults(mordor);
            bolo.setInlineQueryId(update.getInlineQuery().getId());
            try {

                dido= answerInlineQuery(bolo);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


///////////////////////////////////////TEX////////////////////////////////////////////////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        if(update.hasMessage()&&update.getMessage().hasText()){
            matn.add("https://t.me/digiman/2");
            System.out.println(update.getMessage().getText());
            hardware=update.getMessage().getText();
            SendMessage sm = new SendMessage();
            ID=update.getMessage().getChatId();
            sm .setChatId(update.getMessage().getChatId())

                    .enableMarkdown(true).setText(matn.get(0).toString());

            sm.setReplyMarkup(sidebyside());

            try {
                // Send the message
                sendMessage(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }}
    }

    ///////////////////////////////////////sidebyside////////////////////////////////////////////////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    public InlineKeyboardMarkup sidebyside(){
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> ikb2 = new ArrayList<>();
        InlineKeyboardButton ikb11 = new InlineKeyboardButton();
        InlineKeyboardButton ikb12 = new InlineKeyboardButton();
        ikb11.setText("به اشتراک گذاری با دوستان");
        ikb11.setSwitchInlineQuery("یک سانت بالاتر رو کلیک کنید");
        ikb2.add(ikb11);
        keyboard.add(ikb2);
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }


    @Override
    public String getBotUsername() {
        return "q11qbot";
    }

    @Override
    public String getBotToken() {
        return "188440451:AAGPDsHcHWVveTuLbG4SCrjfLNmCTqAykVI";
    }

}












































//
//
//  if(update.hasChannelPost() && update.getChannelPost().hasPhoto()) {
//          System.out.println(update.getChannelPost());
//          List<PhotoSize> photos = update.getChannelPost().getPhoto();
//        // Get largest photo's file_id
//        String f_id;
//
//        f_id = photos.stream()
//        .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
//        .findFirst()
//        .orElse(null).getFileId();
//        SendPhoto photo = new SendPhoto()
//        .setChatId(update.getChannelPost().getChatId())
////                    .setReplyToMessageId(update.getChannelPost().getMessageId())
////                    .setPhoto("https://s-media-cache-ak0.pinimg.com/736x/c6/9a/fd/c69afdc51d27d22ca50f944ed7285eca.jpg")
//        .setPhoto(f_id)
//        .setCaption( "\n بیچ اسلپ" + "\n"+"شیت مک فر بالز" );
//        // Create ReplyKeyboardMarkup object
//        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
//        // Create the keyboard (list of keyboard rows)
//        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
//
//
//        List<InlineKeyboardButton> ikb2 = new ArrayList<>();
//        InlineKeyboardButton ikb = new InlineKeyboardButton();
//
//        ikb.setText("sdf");
//        ikb.setUrl("https://s-media-cache-ak0.pinimg.com/736x/c6/9a/fd/c69afdc51d27d22ca50f944ed7285eca.jpg");
//        ikb2.add(ikb);
//        keyboard.add(ikb2);
//        // Set the keyboard to the markup
//        keyboardMarkup.setKeyboard(keyboard);
//        // Add it to the message
//        photo.setReplyMarkup(keyboardMarkup);
//
//        try {
//        // Send the message
//        sendPhoto(photo);
//        } catch (TelegramApiException e) {
//        e.printStackTrace();
//        }
//
//        }
//
//        if(update.hasChannelPost() && update.getChannelPost().hasText()) {
//        System.out.println(update.getChannelPost());
//        SendMessage sm = new SendMessage();
//        sm .setChatId(update.getChannelPost().getChatId())
////                           .setReplyToMessageId(update.getChannelPost().getMessageId())
//        .enableMarkdown(true).setText("[فاک](www.google.com)");
//
//
//        // Create ReplyKeyboardMarkup object
//        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
//        // Create the keyboard (list of keyboard rows)
//        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
//
//
//        List<InlineKeyboardButton> ikb2 = new ArrayList<>();
//        InlineKeyboardButton ikb = new InlineKeyboardButton();
//
//        ikb.setText("sdf");
//        ikb.setUrl("https://s-media-cache-ak0.pinimg.com/736x/c6/9a/fd/c69afdc51d27d22ca50f944ed7285eca.jpg");
//        ikb2.add(ikb);
//        keyboard.add(ikb2);
//        // Set the keyboard to the markup
//        keyboardMarkup.setKeyboard(keyboard);
//        // Add it to the message
//        sm.setReplyMarkup(keyboardMarkup);
//
//        try {
//        // Send the message
//        sendMessage(sm);
//        } catch (TelegramApiException e) {
//        e.printStackTrace();
//        }
//
//
//        }
//        if(update.hasChannelPost() && !update.getChannelPost().hasText()&& !update.getChannelPost().hasPhoto()) {
//
//        update.getChannelPost().getVideo();
//        }
