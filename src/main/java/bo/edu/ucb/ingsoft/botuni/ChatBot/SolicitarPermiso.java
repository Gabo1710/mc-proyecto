
package bo.edu.ucb.ingsoft.botuni.ChatBot;

        import org.springframework.context.ApplicationContext;
        import org.telegram.telegrambots.meta.api.objects.Message;
        import org.telegram.telegrambots.meta.api.objects.Update;

        import java.util.HashMap;






        import org.springframework.context.ApplicationContext;
        import org.telegram.telegrambots.meta.api.objects.Message;
        import org.telegram.telegrambots.meta.api.objects.Update;

        import java.util.HashMap;

public class SolicitarPermiso extends ProcesoAbstracto {

    public SolicitarPermiso() {
        this.setName("Solicitar Permiso");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {
        ProcesoAbstracto result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();
        //768564158
        StringBuffer sb = new StringBuffer();

        if (this.getStatus().equals("STARTED"))  {

            showMainMenu(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por alguna opción

            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                System.out.println(text);
                try {

                    switch (text){
                        case "sis111" :
                            ShowPermiso(bot, chatId);
                            break;
                        case "sis222" :
                            ShowPermiso(bot, chatId);
                            break;
                        case "0" : result = new ProcesoMenu();
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
        sb.append("******SOLICITAR PERMISO*****\r\n\n");
        sb.append("Ingrese siglas válidas de su materia a solicitar permiso: Ej: sis111 \r\n\n");
        sb.append("Ingrese 0 para volver al Menú Principal\r\n");
        sendStringBuffer(bot, chatId, sb);
        this.setStatus("AWAITING_USER_RESPONSE");
    }


    private void ShowPermiso(BotUniLongPolling bot, Long chatId) {

        StringBuffer sb = new StringBuffer();
        sb.append("Escriba el motivo del permiso:\r\n\n");
        sb.append("Ingrese 0 para volver al Menú Principal\r\n");
        sendStringBuffer(bot, chatId, sb);
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
