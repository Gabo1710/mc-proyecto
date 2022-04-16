package bo.edu.ucb.ingsoft.botuni.BussinesLogic;

import bo.edu.ucb.ingsoft.botuni.DAO.ConsultaHorarioDao;
import bo.edu.ucb.ingsoft.botuni.DTO.ConsultaHorarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaHorarioBL {

    private ConsultaHorarioDao consultaHorarioDao;

    @Autowired
    public ConsultaHorarioBL(ConsultaHorarioDao consultaHorarioDao) {
        this.consultaHorarioDao = consultaHorarioDao;
    }

    public List<ConsultaHorarioDto> findLast10ConsultasByChatId(Long chatId) {
        return consultaHorarioDao.findAllConsultasByBotChatId(chatId+"");
    }
}
