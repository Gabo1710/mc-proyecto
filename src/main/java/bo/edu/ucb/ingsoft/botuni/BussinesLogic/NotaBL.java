package bo.edu.ucb.ingsoft.botuni.BussinesLogic;
import bo.edu.ucb.ingsoft.botuni.DAO.NotaDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.NotaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component

public class NotaBL {

    private NotaDAO NotaDAO;

    @Autowired
    public NotaBL(NotaDAO NotaDAO) {
        this.NotaDAO = NotaDAO;
    }

    public List<NotaDTO> findNotaByBotChatId(Long chatId) {
        return NotaDAO.findNotaByBotChatId(chatId+"");
    }


}