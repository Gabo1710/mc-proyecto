package bo.edu.ucb.ingsoft.botuni.ChatBot;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

public class Autenticacion extends ProcesoAbstracto {

    public Autenticacion() {
        this.setName("Autenticacion");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    // Retornar un Widget de tipo menu
//    @Override
//    public AbstractWidget onInit() {
//        MenuWidgetImpl menuWidget = new MenuWidgetImpl(messages);
//        return menuWidget;
//    }


    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {
        ProcesoAbstracto result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();
        //768564158
        int ci=0;
        if (this.getStatus().equals("STARTED")) {
            ci=AutCi(bot, chatId, update);
        }
        else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            ci=AutCi(bot, chatId, update);
            int c=0;

            if(ci==2){

                result = new ProcesoMenu();
            }
            if((ci==1)){
                result = new ProcesoMenuProfesores();
            }






        }
        return result;

    }

    private int AutCi(BotUniLongPolling bot, Long chatId,  Update update) {

        StringBuffer sb = new StringBuffer();
        sb.append("AUTENTICACIÓN - BOT UNIVERSIDAD\r\n\n");
        sb.append("Para comprobar su identidad, Ingrese su Ci:\r\n\n");
        int x=0;
        Message message = update.getMessage();
        sendStringBuffer(bot, chatId, sb);
        if ( message.hasText() ) {
            // Intentamos transformar en número
            String text = message.getText(); // El texto contiene asdasdas
            //Menú para Profesores
            if(text.equals("123")){
                x= 1;}
            //Menú para Estudiantes
            if(text.equals("321")){
                x= 2;
            }
        }
        this.setStatus("AWAITING_USER_RESPONSE");
        return x;
    }




    /*private int Autpass(BotUniLongPolling bot, Long chatId,  Update update) {

        StringBuffer sb = new StringBuffer();
        sb.append("Autenticacion - BOT UNIVERSIDAD\r\n");
        sb.append("Ingrese su Pasword\r\n");
        int x=0;
        Message message = update.getMessage();
        sendStringBuffer(bot, chatId, sb);
        if ( message.hasText() ) {
            // Intentamos transformar en número
            String text = message.getText(); // El texto contiene asdasdas
if(text.equals("123")){

    x= 1;
    if(text.equals("321")){
        x= 2;
        }}
else{
   x= 0;
}}
        String nombre = "Juan";
        String apellido = "Perez";
        String nombreCompleto = nombre + " " + apellido;
        this.setStatus("AWAITING_USER_RESPONSE");
return x;
    }
*/


    @Override
    public ProcesoAbstracto onError() {
        return null;
    }

    @Override
    public ProcesoAbstracto onSuccess() {
        return null;
    }

    @Override
    public ProcesoAbstracto onTimeout() {
        return null;
    }
}