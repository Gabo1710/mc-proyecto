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

@Service
public class QueryHorarioDocente extends ProcesoAbstracto {

    private ConsultaHorarioDoBL consultaBL;

    @Autowired
    public QueryHorarioDocente(ConsultaHorarioDoBL ConsultaHorarioDoBL) {
        this.consultaBL = ConsultaHorarioDoBL;
        this.setName("Consultar Horario");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis() / 1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public ProcesoAbstracto handle(ApplicationContext context, Update update, BotUniLongPolling bot) {
        ProcesoAbstracto result = this;
        Long chatId = update.getMessage().getChatId();
        StringBuffer sb = new StringBuffer();

        if (this.getStatus().equals("STARTED"))  {

            showHorario(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por una opción
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                System.out.println(text);
                try {
                    int opcion = Integer.parseInt(text);
                    switch (opcion){
                        case 0 : result = new ProcesoMenuProfesores();
                            break;
                        case 1  : showHorarioMateria(bot, chatId);
                            break;
                        case 2  : showHorarioMateria(bot, chatId);
                            break;
                        case 3  : showHorario(bot, chatId);
                            break;
                            default: showHorario(bot, chatId);
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
        List<HorarioDocenteDTO> consultaList = consultaBL.findHorarioDocenteByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Su Horario es el siguiente: \r\n\n");
        //IMPRIMIR HORARIO DE DOCENTE
        sb.append("Usted da: \n").append((consultaList.size()) / 2).append(" materias en la semana \r\n\n");
        for (HorarioDocenteDTO horario : (consultaList)) {
            for (HorarioDocenteDTO horario1 : (consultaList)) {
                if (horario.getSiglas().equals(horario1.getSiglas())) {
                    sb.append("Sigla:\n").append(horario.getId()).append(") ").append((horario.getSiglas()) + " \r\n\n");
                    sb.append("Ingrese número de opción (ejem: 1):\r\n\n");
                    sb.append("Ingrese 0 para volver al Menú Principal\r\n");
                    sendStringBuffer(bot, chatId, sb);
                    this.setStatus("AWAITING_USER_RESPONSE");
                }
                break;
            }
            break;
        }}

    private void showHorarioMateria(BotUniLongPolling bot, Long chatId) {

        List<HorarioDocenteDTO> consultaList = consultaBL.findHorarioDocenteByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();
        for (HorarioDocenteDTO horario : (consultaList)) {
            //Muestro Materias y toda la información necesaria
            sb.append("Materia: ").append(horario.getMateria()).append("\n");
            sb.append(horario.getDia()).append("\n").append("De: ").append(horario.getHorainicio()).append(" Hasta: ").append(horario.getHorafin()).append("\nAula: ").append(horario.getAula()).append("\n\n");
        }
        //Elegir opción
        sb.append("Ingrese 0 para volver al Menú Principal\r\n");
        sb.append("Ingrese 3 para consultar otra materia\r\n");
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