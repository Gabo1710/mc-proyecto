package bo.edu.ucb.ingsoft.botuni.ChatBot;

import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaHorarioBL;
import bo.edu.ucb.ingsoft.botuni.BussinesLogic.ConsultaHorarioDoBL;
import bo.edu.ucb.ingsoft.botuni.DAO.HorarioEstudianteDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDocenteDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioEstudianteDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDetalleDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDetalleEstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;
@Component
public class ShowHorarioMateria2 extends ProcesoAbstracto {

    private ConsultaHorarioDoBL consultaBL;

    @Autowired
    public ShowHorarioMateria2(ConsultaHorarioDoBL ConsultaHorarioDoBL) {
        this.consultaBL = ConsultaHorarioDoBL;
        this.setName("Mostrar Materia");
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
        List<HorarioDocenteDTO> consultaList = consultaBL.findHorarioDocenteByBotChatId(chatId);
        StringBuffer sb = new StringBuffer();

        for (HorarioDocenteDTO horario : (consultaList)) {
            for (HorarioDocenteDTO horario1 : (consultaList)) {
                if(!horario.getMateria().equals(horario1.getMateria())) {
                    //Muestro Materias y toda la información necesaria
                    sb.append("Materia: ").append(horario1.getMateria()).append("\n");
                    sb.append(horario1.getDia()).append("\n").append("De: ").append(horario1.getHorainicio()).append(" Hasta: ").append(horario1.getHorafin()).append("\nAula: ").append(horario1.getAula()).append("\n\n");

                }

            }
            break;

        }
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
                        case "4" : result= context.getBean(QueryHorarioDocente.class);
                            break;
                        default: procesodefault(bot, chatId);
                            break;
                    }
                } catch (NumberFormatException ex) {
                    procesodefault(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
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