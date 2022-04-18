package bo.edu.ucb.ingsoft.botuni.ChatBot;

import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ConsultaHorarioProcess extends ProcesoAbstracto {

    public ConsultaHorarioProcess() {
        this.setName("Consultar Horario");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }


    // Retornar un Widget Solicitando Fecha Inicio
//    @Override
//    public AbstractWidget onInit() {
//        return null;
//    }

    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {
        Long chatId = update.getMessage().getChatId();
        StringBuffer sb = new StringBuffer();
        sb.append("SU HORARIO ES EL SIGUIENTE \r\n");

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(sb.toString());

        try {
            bot.execute(sendMessage);
        } catch (Exception ex) {
            // relanzamos la excepción
            throw new RuntimeException(ex);
        }
        return new ProcesoMenu();


    }

    @Override
    public ProcesoAbstracto onError() {
        return null;
    }

    @Override
    public ProcesoAbstracto onSuccess() {
        return new ProcesoMenu();
    }

    @Override
    public ProcesoAbstracto onTimeout() {
        return new ProcesoMenu();
    }
}
