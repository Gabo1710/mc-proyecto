package bo.edu.ucb.ingsoft.botuni.ChatBot;

import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotUniLongPolling extends TelegramLongPollingBot {

    /**
     * Atributo que sirve para guardar el proceso actual de los diferentes usuarios.
     */
    private Map<Long, ProcesoAbstracto> usersSession;
    private boolean test = false;
    private List<BotApiMethod> testMessages = new ArrayList<>();
    private ApplicationContext context;

    public BotUniLongPolling(ApplicationContext context) {
        this.context = context;
        usersSession = new HashMap<Long, ProcesoAbstracto>();
    }

    public BotUniLongPolling(ApplicationContext context, boolean test) {
        this.context = context;
        this.test = test;
        usersSession = new HashMap<Long, ProcesoAbstracto>();
    }

    //@Override
    //public String getBotUsername() {
     //   return "demo_ucb_bot";
    //}TODO BOT DEMO

    //@Override
    //public String getBotToken() {
    //  return "5182243986:AAHFVYdPl67M0aLQLDIuTEjnnq0s47hsXUQ";
    //} TODO BOT DEMO

    public String getBotUsername() {
       return "ucb_uni_bot";
    }//TODO BOT OFICIAL


    public String getBotToken() {
        return "5330759754:AAEV8WiCCmFs22tPrdDHY4pOCzwVEjWpzbo";
    } //TODO BOT OFICIAL

    @Override
    public void onUpdateReceived(Update update) {
        // Primero identifico al usuario por chat Id Long
        Long chatId = update.getMessage().getChatId();
        System.out.println("\n\n===========> Recibiendo chatId: " + chatId);
        // Busco si ya existe Proceso en el map userSession
        ProcesoAbstracto currentProcess = usersSession.get(chatId);
        //currentProcess = new Autenticacion();
        if (currentProcess == null) { // Primera vez que se contacto con nostros.
            System.out.println("Creando proceso para el  chatId: " + chatId);
            // Debo crear el proceso por defecto

                usersSession.put(chatId, currentProcess);
                currentProcess = new Autenticacion();
                System.out.println("Derivando la conversación al proceso: " + currentProcess.getName());
                ProcesoAbstracto nextProcess = currentProcess.handle(context, update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente lo iniciamos
                System.out.println("Iniciando siguiente proceso: " + nextProcess.getName());
                nextProcess.handle(context, update, this);
            } else {
                System.out.println("No hay cambio de proceso, así que termina conversación");
            }
            usersSession.put(chatId, nextProcess);

        } else { // Ya existe un proceso
            System.out.println("Continuamos el proceso para el  chatId: " + chatId
                    + " proceso: " + currentProcess.getName());
            ProcesoAbstracto nextProcess = currentProcess.handle(context, update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente
                System.out.println("Iniciando siguiente proceso: " + nextProcess.getName());
                nextProcess = nextProcess.handle(context, update, this);
            } else {
                System.out.println("No hay cambio de proceso, así que termina conversación");
            }
            usersSession.put(chatId, nextProcess);
        }

    }
    public void sendMyMessage(BotApiMethod method) throws TelegramApiException {
        System.out.println("Enviando mensaje: " + method);
        if (test) {
            // no enviamos
            testMessages.add(method);
        } else {
            this.execute(method);
        }
    }
    public List<BotApiMethod> getTestMessages() {
        return testMessages;
    }
}