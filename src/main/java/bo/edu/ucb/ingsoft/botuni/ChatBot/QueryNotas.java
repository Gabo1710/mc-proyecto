package bo.edu.ucb.ingsoft.botuni.ChatBot;


import bo.edu.ucb.ingsoft.botuni.BussinesLogic.NotaBL;

import bo.edu.ucb.ingsoft.botuni.DTO.NotaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;
import java.util.HashMap;

@Component
public class QueryNotas extends ProcesoAbstracto {

    private NotaBL consultaBL;

    @Autowired
    public QueryNotas(NotaBL NotaBL) {
        this.consultaBL = NotaBL;
        this.setName("Consultar Notas");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }
    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {

        Long chatId = update.getMessage().getChatId();
        List<NotaDTO> consultaList = consultaBL.findNotaByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Sus calificaciones son las siguientes: \r\n\n" );
        int u=1;
        //IMPRIMIR HORARIO DE ESTUDIANTE
        for(NotaDTO de: (consultaList)){
            sb.append(" Materia: ").append(de.getMateria()).append(" evaluacion continua: ").append(de.getEvaluacionc()).append  (" evaluacion final: ").append(de.getEvaluacionf()).append(" \nnota final: ").append(de.getNota()).append("\r\n\n");
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
