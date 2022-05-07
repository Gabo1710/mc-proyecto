package bo.edu.ucb.ingsoft.botuni.ChatBot;

import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaListaBL;

import bo.edu.ucb.ingsoft.botuni.DTO.ListaEstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.List;

@Component
public class QueryListaDocente extends ProcesoAbstracto {

    ConsultaListaBL ListaBL;

    @Autowired
    public QueryListaDocente() {

        this.setName("Listado de Alumnos");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {
        ProcesoAbstracto result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();
        List<ListaEstudianteDTO> lista = ListaBL.findListaEstudianteByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Usted tiene: \r\n" ).append(lista.size()).append(" alumnos en esta materia \r\n\n");
        sb.append("La lista de Alumnos es la siguiente: \r\n\n" );
        sb.append("      Apellidos           Nombres            Ci \n\n" );
        for(ListaEstudianteDTO horario: (lista)){
            sb.append(horario.getApellidos()).append("   ").append(horario.getNombres()).append("   ").append(horario.getCi()).append("\n\n\n");
        }
        sb.append("**Ingrese cualquier tecla para continuar** \r\n\n" );

        sendStringBuffer(bot, chatId, sb);
        return new ProcesoMenuProfesores();

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