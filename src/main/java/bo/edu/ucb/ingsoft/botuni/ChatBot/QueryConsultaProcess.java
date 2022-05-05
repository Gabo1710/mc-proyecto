package bo.edu.ucb.ingsoft.botuni.ChatBot;

import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaHorarioBL;
import bo.edu.ucb.ingsoft.botuni.DAO.HorarioEstudianteDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioEstudianteDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDetalleDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDetalleEstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;

@Component
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
        List<HorarioEstudianteDTO> consultaList = consultaBL.findHorarioEstudianteByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Tu Horario es el siguiente: \r\n\n" );
        sb.append("Pasas: " ).append(consultaList.size()).append(" clases en la semana \r\n\n");
        //IMPRIMIR HORARIO DE ESTUDIANTE
       for(HorarioEstudianteDTO horario: (consultaList)){
           sb.append("Día: ").append(horario.getDia()).append(" \nMateria: ").append(horario.getMateria()).append(" Paralelo: ").append(horario.getParalelo()).append("               Aula: ").append(horario.getAula()).append(" \nInicio: ").append(horario.getHorainicio()).append("        Fin: ").append(horario.getHorafin()).append("\r\n\n");
       }
        sb.append("**Ingrese cualquier tecla para continuar**\r\n\n" );
        sendStringBuffer(bot, chatId, sb);
        return new ProcesoMenu();

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
