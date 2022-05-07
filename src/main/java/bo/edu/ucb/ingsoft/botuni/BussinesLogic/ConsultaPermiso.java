package bo.edu.ucb.ingsoft.botuni.BussinesLogic;
import bo.edu.ucb.ingsoft.botuni.DAO.ListaPermisoEstudianteDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.ListaPermisoEstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component

public class ConsultaPermiso {

    private ListaPermisoEstudianteDAO listaPermisoEstudianteDAO;

    @Autowired
    public ConsultaPermiso(ListaPermisoEstudianteDAO listaPermisoEstudianteDAO) {
        this.listaPermisoEstudianteDAO = listaPermisoEstudianteDAO;
    }

    public List<ListaPermisoEstudianteDTO> findListaPermisoEstudianteByBotChatId(Long chatId) {
        return listaPermisoEstudianteDAO.findListaPermisoEstudianteByBotChatId(chatId+"");
    }


}