package bo.edu.ucb.ingsoft.botuni.ChatBot;


import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaDetalleBL;
import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaHorarioBL;
import bo.edu.ucb.ingsoft.botuni.DTO.DetalleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;

@Component
public class QueryDetalleProces extends ProcesoAbstracto {

    private ConsultaDetalleBL consultaBL;

    @Autowired
    public QueryDetalleProces(ConsultaDetalleBL ConsultaDetalleBL) {
        this.consultaBL = ConsultaDetalleBL;
        this.setName("Consulta Detalle");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");

    }
    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {

        Long chatId = update.getMessage().getChatId();
        List<DetalleDTO> consultaList = consultaBL.findDetalleByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();


        sb.append("El detalle de la materia es el siguiente: \r\n\n" );

        //IMPRIMIR HORARIO DE ESTUDIANTE
        for(DetalleDTO det: (consultaList)){
            sb.append("Día: ").append(det.getDia()).append(" \nAula: ").append(det.getAulaId()).append(" Inicio: ").append(det.getHoraInicio()).append("               Fin: ").append(det.getHoraFin()).append(" \nParalelo: ").append(det.getParalelo()).append("        Docente: ").append(det.getDocenteId()).append("\r\n\n");
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
