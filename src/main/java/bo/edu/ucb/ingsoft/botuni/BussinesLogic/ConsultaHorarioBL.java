package bo.edu.ucb.ingsoft.botuni.BussinesLogic;

import bo.edu.ucb.ingsoft.botuni.DAO.HorarioDao;

import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ConsultaHorarioBL {

    private HorarioDao horarioDao;

    @Autowired
    public ConsultaHorarioBL(HorarioDao horarioDao) {
        this.horarioDao = horarioDao;
    }


    public List<HorarioDto> findAllHorario(Long chatId) {
        return horarioDao.findHorarioByBotChatId(chatId+"");
    }
}
