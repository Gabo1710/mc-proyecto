package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.ConsultaHorarioDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultaDao {
    @Select("SELECT c.estudiante_id as estudianteId, c.fecha_consulta as FechaConsulta" +
            " FROM consulta c " +
            "      JOIN estudiante e ON (c.estudiante_id = e.estudiante_id) " +
            "WHERE " +
            " e.bot_chat_id = #{id}")
    List<ConsultaHorarioDto> findAllConsultasByBotChatId(@Param("id") String botChatId);
}
