package bo.edu.ucb.ingsoft.botuni.ChatBot;


import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaDeudaBL;

import bo.edu.ucb.ingsoft.botuni.DTO.DeudaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;
import java.util.HashMap;

@Component
public class QueryDeuda extends ProcesoAbstracto {

    private ConsultaDeudaBL consultaBL;

    @Autowired
    public QueryDeuda(ConsultaDeudaBL ConsultaDeudaBL) {
        this.consultaBL = ConsultaDeudaBL;
        this.setName("Consultar Permiso");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }
    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {

        Long chatId = update.getMessage().getChatId();
        List<DeudaDTO> consultaList = consultaBL.findDeudaByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Los Permisos Solicitados son los siguientes: \r\n\n" );
        int u=1;
        //IMPRIMIR HORARIO DE ESTUDIANTE
        for(DeudaDTO de: (consultaList)){
            sb.append("N°: ").append(u++).append(" fecha de pago: ").append(de.getFecha_pago()).append(" Interes: ").append(de.getInteres()).append      (" \nEstado: ").append("\r\n\n");
        }
        sb.append("**Ingrese cualquier tecla para continuar**\r\n\n" );
        sendStringBuffer(bot, chatId, sb);
        return new ProcesoMenuPermisos();

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
