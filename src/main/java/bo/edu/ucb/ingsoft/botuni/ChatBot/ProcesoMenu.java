package bo.edu.ucb.ingsoft.botuni.ChatBot;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

public class ProcesoMenu extends ProcesoAbstracto {

    public ProcesoMenu() {
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

            if (this.getStatus().equals("STARTED"))  {

                showMainMenu(bot, chatId);
            } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
                // Estamos esperando por un numero 1 o 2

                Message message = update.getMessage();
                if ( message.hasText() ) {
                    // Intentamos transformar en número
                    String text = message.getText(); // El texto contiene asdasdas
                    try {
                        int opcion = Integer.parseInt(text);
                        switch (opcion){
                            case 1 : result = new ConsultaProcess(); // FIXME
                                break;
                            //case 2 : result = new ConsultaDetallePorMateria(); // FIXME
                              //  break;
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
        sb.append("MENU PRINCIPAL - BOT UNIVERSIDAD\r\n");
        sb.append("¿Qué Desea? Por Favor elija una opción:\r\n");
        sb.append("1. Consultar Horario\r\n");
        sb.append("2. **********\r\n");

        sendStringBuffer(bot, chatId, sb);

        String nombre = "Juan";
        String apellido = "Perez";
        String nombreCompleto = nombre + " " + apellido;
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
