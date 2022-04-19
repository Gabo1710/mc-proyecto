package bo.edu.ucb.ingsoft.botuni.ChatBot;

import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;






        import org.springframework.context.ApplicationContext;
        import org.telegram.telegrambots.meta.api.objects.Message;
        import org.telegram.telegrambots.meta.api.objects.Update;

        import java.util.HashMap;

public class DetalleDocente extends ProcesoAbstracto {

    public DetalleDocente() {
        this.setName("Menú principal");
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
        StringBuffer sb = new StringBuffer();

        if (this.getStatus().equals("STARTED"))  {

            showMainMenu(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2

            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                System.out.println(text);
                try {

                    switch (text){
                        case "sis111" :

                            ShowDetalle(bot, chatId);
                            break;
                        case "sis222" :
                            ShowDetalle(bot, chatId);
                            break;
                        case "0" : result = new ProcesoMenuProfesores(); // FIXME
                            break;
                        default: showMainMenu(bot, chatId);
                    }
                } catch (NumberFormatException ex) {
                    showMainMenu(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMainMenu(bot, chatId);
            }
        }
        return result;

    }


    private void showMainMenu(BotUniLongPolling bot, Long chatId) {

        StringBuffer sb = new StringBuffer();
        sb.append("DETALLE DE MATERIA BOT UNIVERSIDAD\r\n");
        sb.append("INGRESE SIGLAS VALIDAS DE SU MATERIA: Ej: sis111 \r\n");
        sb.append("INGRESE 0 PARA VOLVER AL MENU PRINCIPAL\r\n");
        sendStringBuffer(bot, chatId, sb);

        // String nombre = "Juan";
        // String apellido = "Perez";
        //String nombreCompleto = nombre + " " + apellido;
        this.setStatus("AWAITING_USER_RESPONSE");
    }


    private void ShowDetalle(BotUniLongPolling bot, Long chatId) {

        StringBuffer sb = new StringBuffer();
        sb.append("LA MATERIA TIENE LOS SIGUIENTES LINKS:\r\n");
        sb.append("https://neo.ucb.edu.bo/\r\n");
        sb.append("INGRESE 0 PARA VOLVER AL MENU PRINCIPAL\r\n");
        sendStringBuffer(bot, chatId, sb);

        // String nombre = "Juan";
        // String apellido = "Perez";
        //String nombreCompleto = nombre + " " + apellido;
        this.setStatus("AWAITING_USER_RESPONSE");
    }

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