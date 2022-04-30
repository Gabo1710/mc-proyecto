package bo.edu.ucb.ingsoft.botuni.ChatBot;


import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaHorarioDoBL;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDocenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;

@Component
public class QueryHorarioDocente extends ProcesoAbstracto {

    private ConsultaHorarioDoBL consultaBL;

    @Autowired
    public QueryHorarioDocente(ConsultaHorarioDoBL ConsultaHorarioDoBL) {
        this.consultaBL = ConsultaHorarioDoBL;
        this.setName("Consultar Horario");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }
    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {
        Long chatId = update.getMessage().getChatId();
        List<HorarioDocenteDTO> consultaList = consultaBL.findHorarioDocenteByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Su Horario es el siguiente: \r\n\n" );
        //IMPRIMIR HORARIO DE DOCENTE
        for(HorarioDocenteDTO horario: (consultaList)){
            sb.append(horario.toString()).append("\r\n\n");
        }
        sb.append("Ingrese cualquier tecla para continuar \r\n\n" );

        sendStringBuffer(bot, chatId, sb);
        return new ProcesoMenuProfesores();

    }
    private void showMainMenu(BotUniLongPolling bot, Long chatId) {

        StringBuffer sb = new StringBuffer();
        sb.append("HORARIO DOCENTE - BOT UNIVERSIDAD\r\n\n");
        sb.append("Ingrese siglas válidas de su materia:\r\n\n");// ejemplo sis111 o sis222
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