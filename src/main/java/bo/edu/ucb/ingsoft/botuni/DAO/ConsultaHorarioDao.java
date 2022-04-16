package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.ConsultaHorarioDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultaHorarioDao {
    @Select("SELECT p.estudiante_id as estudianteId, p.start_date as startDate" +
            " FROM consulta c " +
            "      JOIN estudiante e ON (p.estudianteId = e.estudianteId) " +
            "WHERE " +
            " e.bot_chat_id = #{id}")
    List<ConsultaHorarioDto> findAllConsultasByBotChatId(@Param("id") String botChatId);
}
