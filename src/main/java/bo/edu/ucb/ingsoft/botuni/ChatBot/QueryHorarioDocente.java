package bo.edu.ucb.ingsoft.botuni.ChatBot;


import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaHorarioDoBL;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDocenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.List;

@Component
public class QueryHorarioDocente extends ProcesoAbstracto {

    private ConsultaHorarioDoBL consultaBL;


    @Autowired
    public QueryHorarioDocente(ConsultaHorarioDoBL ConsultaHorarioDoBL) {
        this.consultaBL = ConsultaHorarioDoBL;
        this.setName("Consultar Horario");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis() / 1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {
        ProcesoAbstracto result = this;
        Long chatId = update.getMessage().getChatId();


        if (this.getStatus().equals("STARTED"))  {

            showHorario(bot, chatId);
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
                        case 1 : result = context.getBean(ShowHorarioMateria.class);
                            break;
                        case 2  :result = context.getBean(ShowHorarioMateria2.class);
                            break;

                        case 3  : showHorario(bot, chatId);
                            break;
                            default: showHorario(bot, chatId);
                            break;
                    }
                } catch (NumberFormatException ex) {
                    showHorario(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showHorario(bot, chatId);
            }

        }
        //sendStringBuffer(bot, chatId, sb);
        return result;
    }

    private void showHorario(BotUniLongPolling bot, Long chatId) {
        int i=1;
        List<HorarioDocenteDTO> consultaList = consultaBL.findHorarioDocenteByBotChatId(chatId);

        StringBuffer sb = new StringBuffer();
        //IMPRIMIR HORARIO DE DOCENTE
        sb.append("Usted da: \n").append((consultaList.size())/2).append(" materias en la semana \r\n\n");

        for (HorarioDocenteDTO horario : (consultaList)) {
            for (HorarioDocenteDTO horario1 : (consultaList)) {
                if (!(horario.getMateria()).equals(horario1.getMateria())) {
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