package bo.edu.ucb.ingsoft.botuni.ChatBot;

import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaHorarioBL;
import bo.edu.ucb.ingsoft.botuni.DTO.ConsultaHorarioDto;
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
        this.setName("Consultar solicitudes pasadas");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    // Retornar un Widget con la información de los permisos solicitados
//    @Override
//    public AbstractWidget onInit() {
//        return null;
//    }

    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {
        Long chatId = update.getMessage().getChatId();
        List<ConsultaHorarioDto> consultaList = consultaBL.findLast10ConsultasByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Este año has solicitado " ).append(consultaList.size());
        sb.append(" permisos. Bajo el siguiente detalle\r\n");
        for(ConsultaHorarioDto permission: consultaList) {
            sb.append(permission.toString()).append("\n\r");
        }
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
