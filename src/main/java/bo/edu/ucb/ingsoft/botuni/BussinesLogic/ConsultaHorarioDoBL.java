package bo.edu.ucb.ingsoft.botuni.BussinesLogic;

import bo.edu.ucb.ingsoft.botuni.DAO.HorarioDocenteDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDocenteDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaHorarioDoBL {

    private HorarioDocenteDAO horarioDocenteDAO;

    @Autowired
    public ConsultaHorarioDoBL(HorarioDocenteDAO horarioDocenteDAO) {
        this.horarioDocenteDAO = horarioDocenteDAO;
    }

    public List<HorarioDocenteDTO> findHorarioDocenteByBotChatId(Long chatId) {
        return horarioDocenteDAO.findHorarioDocenteByBotChatId(chatId + "");
    }
}