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
public class QueryListaDocente extends ProcesoAbstracto {

    private ConsultaListaBL ListaBL;
    private ConsultaHorarioDoBL horarioDoBL;

    @Autowired
    public QueryListaDocente(ConsultaListaBL ConsultaListaBL, ConsultaHorarioDoBL ConsultaHorarioDoBL) {
        this.ListaBL = ConsultaListaBL;
        this.horarioDoBL = ConsultaHorarioDoBL;
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
        //List<ListaEstudianteDTO> lista = ListaBL.findListaEstudianteByBotChatId(chatId);
        //StringBuffer sb = new StringBuffer();


        if (this.getStatus().equals("STARTED"))  {

            showLista(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por una opción
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas

                try {
                    int opcion = Integer.parseInt(text);

                    switch (opcion){
                        case 0 : result = new ProcesoMenuProfesores();
                            break;
                        //caso 1 = Para una materia
                        case 1 : result = context.getBean(ListaMateria.class);
                            break;
                        case 2  :result = context.getBean(ListaMateria2.class);
                            break;

                        case 3  : showLista(bot, chatId);
                            break;
                        default: showLista(bot, chatId);
                            break;
                    }
                } catch (NumberFormatException ex) {
                    showLista(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showLista(bot, chatId);
            }

        }
        //sendStringBuffer(bot, chatId, sb);
        return result;
    }

    private void showLista(BotUniLongPolling bot, Long chatId) {
        int i=1;
        List<ListaEstudianteDTO> consultaList = ListaBL.findListaEstudianteByBotChatId(chatId);
        List<HorarioDocenteDTO> consulta = horarioDoBL.findHorarioDocenteByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();
        //IMPRIMIR LISTAS DE MATERIAS DE DOCENTE
        for (HorarioDocenteDTO horario : (consulta)) {
            for (HorarioDocenteDTO horario1 : (consulta)) {
                if ((!(horario.getMateria()).equals(horario1.getMateria()))&&(horario.getDocenteId().equals(horario1.getDocenteId()))) {
                    sb.append("Materia:\n").append(i++).append(") ").append((horario.getMateria()) + " \r\n");
                    sb.append(i++).append(") ").append((horario1.getMateria()) + " \r\n\n");
                    break;
                }
            }
            break;
        }

        sb.append("Ingrese número de opción (ejem: '1' ):\r\n\n");
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