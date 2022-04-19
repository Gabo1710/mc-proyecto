

package bo.edu.ucb.ingsoft.botuni.ChatBot;

        import org.springframework.context.ApplicationContext;
        import org.telegram.telegrambots.meta.api.objects.Message;
        import org.telegram.telegrambots.meta.api.objects.Update;

        import java.util.HashMap;






        import org.springframework.context.ApplicationContext;
        import org.telegram.telegrambots.meta.api.objects.Message;
        import org.telegram.telegrambots.meta.api.objects.Update;

        import java.util.HashMap;

public class DetalleDeuda extends ProcesoAbstracto {

    public DetalleDeuda() {
        this.setName("Menú detalle deuda");
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
                        case "1" :

                            ShowDetalle(bot, chatId);
                            break;
                        case "0" : result = new ProcesoMenu(); // FIXME
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
        sb.append("-----DETALLE DE DEUDA----------\r\n");
        sb.append("1) Para consultar deuda actual \r\n");
        sb.append("INGRESE 0 PARA VOLVER AL MENU PRINCIPAL\r\n");
        sendStringBuffer(bot, chatId, sb);

        // String nombre = "Juan";
        // String apellido = "Perez";
        //String nombreCompleto = nombre + " " + apellido;
        this.setStatus("AWAITING_USER_RESPONSE");
    }


    private void ShowDetalle(BotUniLongPolling bot, Long chatId) {

        StringBuffer sb = new StringBuffer();
        sb.append("USTED TIENE LA SIGUIENTE DEUDA:\r\n");
        sb.append("1-2022 | 1ra cuota | 3240 bs:\r\n");
        sb.append("2-2022 | 2da cuota | 3240 bs:\r\n");
        sb.append("1-2022 | 3ra cuota | 3240 bs:\r\n");
        sb.append("1-2022 | 4ta cuota | 3240 bs:\r\n");
        sb.append("1-2022 | 5ta cuota | 3240 bs:\r\n");
        sb.append("Total------------> | 16200 bs:\r\n");




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