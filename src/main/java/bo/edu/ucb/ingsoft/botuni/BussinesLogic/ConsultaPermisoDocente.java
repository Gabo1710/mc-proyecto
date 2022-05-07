package bo.edu.ucb.ingsoft.botuni.BussinesLogic;
import bo.edu.ucb.ingsoft.botuni.DAO.ListaPermisoDocenteDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.ListaPermisoDocenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component

public class ConsultaPermisoDocente {

    private ListaPermisoDocenteDAO listaPermisoDocenteDAO;
    @Autowired
    public ConsultaPermisoDocente(ListaPermisoDocenteDAO listaPermisoDocenteDAO) {
        this.listaPermisoDocenteDAO = listaPermisoDocenteDAO;
    }




    public List<ListaPermisoDocenteDTO> findListaPermisoDocenteByBotChatId(Long chatId) {
        return listaPermisoDocenteDAO.findListaPermisoDocenteByBotChatId(chatId+"");
    }


}