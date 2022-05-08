package bo.edu.ucb.ingsoft.botuni.BussinesLogic;
import bo.edu.ucb.ingsoft.botuni.DAO.AutentificacionDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.AutentificacionDTO;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class ConsultaAutentificacion {

    private AutentificacionDAO autentificacionDAO;
    @Autowired


    public ConsultaAutentificacion(AutentificacionDAO autentificacionDAO) {
        this.autentificacionDAO = autentificacionDAO;
    }

    public List<AutentificacionDTO> findAutentificacionByBotChatId(Long chatId) {
        return autentificacionDAO.findAutentificacionByBotChatId(chatId+"");
    }
}
