package bo.edu.ucb.ingsoft.botuni.ChatBot;

import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;


public class HorarioDocente extends ProcesoAbstracto {

    public HorarioDocente() {
        this.setName("Menú principal");
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
            // Estamos esperando por una opción

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
                            ShowDetalle2(bot, chatId);
                            break;
                        case "0" : result = new ProcesoMenuProfesores();
                            break;
                        case "1" : result = new HorarioDocente();
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
        sb.append("HORARIO DOCENTE - BOT UNIVERSIDAD\r\n\n");
        sb.append("Ingrese siglas válidas de su materia:\r\n\n");// ejemplo sis111 o sis222
        sb.append("Ingrese 0 para volver al Menú Principal\r\n");
        sendStringBuffer(bot, chatId, sb);
        this.setStatus("AWAITING_USER_RESPONSE");
    }


    private void ShowDetalle(BotUniLongPolling bot, Long chatId) {

        StringBuffer sb = new StringBuffer();
        sb.append("Su horario es el siguiente:\r\n\n");
        sb.append("Materia: Análisis de Algoritmos\r\n\n");
        sb.append("Lunes: 11:00-12:30 - Aula D9\r\n");
        sb.append("Viernes: 11:00-12:30 - Aula D18\r\n\n");
        sb.append("Ingrese 0 para volver al Menú Principal\r\n");
        sb.append("Ingrese 1 para consultar otra materia\r\n");
        sendStringBuffer(bot, chatId, sb);

        this.setStatus("AWAITING_USER_RESPONSE");
    }
    private void ShowDetalle2(BotUniLongPolling bot, Long chatId) {

        StringBuffer sb = new StringBuffer();
        sb.append("Su horario es el siguiente:\r\n\n");
        sb.append("Materia: Ingeniería del Software\r\n\n");
        sb.append("Martes: 13:30-15:15 - Aula C003\r\n");
        sb.append("Jueves: 18:45-21:15 - Aula C105\r\n\n");
        sb.append("Ingrese 0 para volver al Menú Principal\r\n");
        sb.append("Ingrese 1 para consultar otra materia\r\n");
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