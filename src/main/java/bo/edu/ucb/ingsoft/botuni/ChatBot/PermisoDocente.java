package bo.edu.ucb.ingsoft.botuni.ChatBot;


import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaPermisoDocente;

import bo.edu.ucb.ingsoft.botuni.DTO.ListaPermisoDocenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;
import java.util.HashMap;

@Component
public class PermisoDocente extends ProcesoAbstracto {

    private ConsultaPermisoDocente consultaBL;

    @Autowired
    public PermisoDocente(ConsultaPermisoDocente ConsultaPermisoDocente) {
        this.consultaBL = ConsultaPermisoDocente;
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
        List<ListaPermisoDocenteDTO> consultaList = consultaBL.findListaPermisoDocenteByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Los Permisos de estudiantes Recibidos: \r\n\n" );
        int u=1;

        for(ListaPermisoDocenteDTO perm: (consultaList)){
            sb.append("N°: ").append(u++).append(" Estudiante: ").append(perm.getApellidos()).append(" ").append(perm.getNombres()).append(" CI: ").append(perm.getCi()).append(" \nRazon: ").append(perm.getRazon()).append(" \nInicio: ").append(perm.getFecha_inicio()).append(" Fin: ").append(perm.getFecha_fin()).append("\n Estado-->").append(perm.getEstado_permiso()).append("\r\n\n");
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
