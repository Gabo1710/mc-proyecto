package bo.edu.ucb.ingsoft.botuni.BussinesLogic;

import bo.edu.ucb.ingsoft.botuni.DAO.HorarioDocenteDAO;
import bo.edu.ucb.ingsoft.botuni.DAO.SiglasDAO;
import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDocenteDTO;

import bo.edu.ucb.ingsoft.botuni.DTO.SiglasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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