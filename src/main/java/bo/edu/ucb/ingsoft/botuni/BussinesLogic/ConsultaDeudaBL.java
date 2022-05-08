package bo.edu.ucb.ingsoft.botuni.BussinesLogic;
import bo.edu.ucb.ingsoft.botuni.DAO.DeudaDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.DeudaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component

public class ConsultaDeudaBL {

    private DeudaDAO DeudaDAO;

    @Autowired
    public ConsultaDeudaBL(DeudaDAO DeudaDAO) {
        this.DeudaDAO = DeudaDAO;
    }

    public List<DeudaDTO> findDeudaByBotChatId(Long chatId) {
        return DeudaDAO.findDeudaByBotChatId(chatId+"");
    }


}