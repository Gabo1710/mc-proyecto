package bo.edu.ucb.ingsoft.botuni.ChatBot;

import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public abstract class ProcesoAbstracto {
    // Nombre del proceso, ej: Menu Principal
    private String name;
    // Proceso por defecto cuando se inicio o existe un error
    private boolean isDefault;

    // Atributo me dice si el proceso expira
    private boolean expires;

    // Cantidad de segundos para que expire
    private long timeout;

    // La fecha de inicio serán la cantidad de segundos desde 1970
    // Se lo puede obtener con System.getCurretnMillis()/1000
    private long startDate;

    // Un mapa para almacenar los datos del usuario durante el proceso del chat.
    private Map<String, Object> userData;

    // Posibles valores: STARTED, FINISH, ERROR, AWAITING_USER_RESPONSE
    private String status;

    // Este método decide que hacer con el usuario en cada tipo de proceso.
    public abstract ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot);

//    // Método que se invoca al iniciar el proceso
//    public abstract AbstractWidget onInit();

    // A que proceso se debe ir en caso de error.
    public abstract ProcesoAbstracto onError();

    // A que proceso se debe ir en caso de terminar satisfactoriamente.
    public abstract ProcesoAbstracto onSuccess();

    // En caso de que el proceso de timeout con cuál continuo
    public abstract ProcesoAbstracto onTimeout();

    protected void sendStringBuffer(BotUniLongPolling bot, Long chatId, StringBuffer sb) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(sb.toString());
        try {
            bot.sendMyMessage(sendMessage);
        } catch (Exception ex) {
            // relanzamos la excepción
            throw new RuntimeException(ex);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isExpires() {
        return expires;
    }

    public void setExpires(boolean expires) {
        this.expires = expires;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public Map<String, Object> getUserData() {
        return userData;
    }

    public void setUserData(Map<String, Object> userData) {
        this.userData = userData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
