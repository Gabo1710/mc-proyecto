package bo.edu.ucb.ingsoft.botuni.BussinesLogic;

import bo.edu.ucb.ingsoft.botuni.DAO.HorarioDocenteDAO;
import bo.edu.ucb.ingsoft.botuni.DAO.HorarioEstudianteDAO;
import bo.edu.ucb.ingsoft.botuni.DAO.MateriaDetalleEstudianteDAO;

import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDocenteDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioEstudianteDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDetalleEstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ConsultaHorarioBL {

    private HorarioEstudianteDAO horarioEstudianteDAO;

    @Autowired
    public ConsultaHorarioBL(HorarioEstudianteDAO horarioEstudianteDAO) {
        this.horarioEstudianteDAO = horarioEstudianteDAO;
    }

    public List<HorarioEstudianteDTO> findHorarioEstudianteByBotChatId(Long chatId) {
        return horarioEstudianteDAO.findHorarioEstudianteByBotChatId(chatId+"");
    }
}

