package bo.edu.ucb.ingsoft.botuni.ChatBot;

import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaHorarioBL;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;

@Service
public class QueryConsultaProcess extends ProcesoAbstracto {

    private ConsultaHorarioBL consultaBL;

    @Autowired
    public QueryConsultaProcess(ConsultaHorarioBL ConsultaHorarioBL) {
        this.consultaBL = ConsultaHorarioBL;
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
        List<HorarioDto> consultaList = consultaBL.findAllHorario(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Tu Horario es el siguiente: \r\n\n" );
        sb.append("Usted pasa: \n" ).append(consultaList.size()).append(" clases en la semana \r\n\n");
        //IMPRIMIR HORARIO DE ESTUDIANTE
       for(HorarioDto horario: (consultaList)){
           sb.append(horario.toString()).append("\r\n\n");
       }
        sb.append("Ingrese cualquier tecla para continuar \r\n\n" );

        sendStringBuffer(bot, chatId, sb);
        return new ProcesoMenu();

    }
    private void showMainMenu(BotUniLongPolling bot, Long chatId) {

        StringBuffer sb = new StringBuffer();
        sb.append("MENU PRINCIPAL - BOT UNIVERSIDAD\r\n\n");
        sb.append("¿Qué Desea? Por Favor elija una opción:\r\n\n");
        sb.append("1. Consultar Horario\r\n");
        sb.append("2. Detalle de Materias\r\n");
        sb.append("3. Consultar Deuda\r\n");
        sb.append("4. Solicitar Permiso\r\n");

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
