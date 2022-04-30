package bo.edu.ucb.ingsoft.botuni.BussinesLogic;


import bo.edu.ucb.ingsoft.botuni.DAO.ListaEstudianteDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.ListaEstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaListaBL {

    private ListaEstudianteDAO listaEstudianteDAO;

    @Autowired
    public ConsultaListaBL(ListaEstudianteDAO listaEstudianteDAO) {
        this.listaEstudianteDAO = listaEstudianteDAO;
    }

    public List<ListaEstudianteDTO> findListaEstudianteByBotChatId(Long chatId) {
        return listaEstudianteDAO.findListaEstudianteByBotChatId(chatId+"");
    }
}

