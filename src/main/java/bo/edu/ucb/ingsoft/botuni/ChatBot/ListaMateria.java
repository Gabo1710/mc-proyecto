package bo.edu.ucb.ingsoft.botuni.ChatBot;


import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaHorarioDoBL;
import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaListaBL;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDocenteDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.ListaEstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.List;

@Component
public class ListaMateria extends ProcesoAbstracto {

    private final ConsultaListaBL ListaBL;
    private ConsultaHorarioDoBL horarioDoBL;

    @Autowired
    public ListaMateria(ConsultaListaBL consultaListaBL) {
        this.ListaBL = consultaListaBL;
        this.setName("Lista Estudiantes");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }
    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {
        ProcesoAbstracto result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();
        List<ListaEstudianteDTO> lista = ListaBL.findListaEstudianteByBotChatId(chatId);

        StringBuffer sb = new StringBuffer();


        sb.append("Usted tiene: \r\n" ).append(lista.size()).append(" alumnos en \r\n\n");
        //sb.append("La lista de Alumnos es la siguiente: \r\n\n" );
        sb.append("       Apellidos              Nombres                Ci \n\n" );
        int i=1;
        for(ListaEstudianteDTO horario: (lista)){
            sb.append(i++).append(". ").append(horario.getApellidos()).append("   ").append(horario.getNombres()).append("   ").append(horario.getCi()).append("\n");
        }
        sb.append("\n" );
        sb.append("**Ingrese cualquier tecla para continuar** \r\n\n" );

        sendStringBuffer(bot, chatId, sb);

        if (this.getStatus().equals("STARTED"))  {
            procesodefault(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un opción
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                System.out.println(text);
                try {
                    switch (text){
                        case "0" : result= new ProcesoMenuProfesores();
                            break;
                        case "4" : result= context.getBean(QueryListaDocente.class);
                            break;
                        default: procesodefault(bot, chatId);
                            break;
                    }
                } catch (NumberFormatException ex) {
                    procesodefault(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else {
                // Si me enviaron algo diferente de un texto.
                procesodefault(bot, chatId);
            }
        }

        return result;
    }

    private void procesodefault(BotUniLongPolling bot, Long chatId) {

        StringBuffer sb = new StringBuffer();
        sb.append("Ingrese 0 para volver al Menú Principal\r\n");
        sb.append("Ingrese 4 para consultar otra materia\r\n");
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