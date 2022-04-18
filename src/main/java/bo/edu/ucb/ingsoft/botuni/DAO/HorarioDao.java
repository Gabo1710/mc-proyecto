package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.HorarioDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HorarioDao {
    @Select("SELECT b.aula_id as aula, b.nombre as materia, b.hora_inicio as horainicio, b.hora_fin as HoraFin " +
            "FROM horario a" +
            "   JOIN estudiante d ON (d.estudiante_id = a.estudiante_id) "+
            "   JOIN materia b ON (b.materia_id = a.materia_id) "+
            "   JOIN aula c ON (c.aula_id = b.aula_id) "+
            "WHERE " +
                //"c.aula_id=b.aula_id" +
               // "and d.estudiante_id=a.estudiante_id" +
                //"and b.materia_id=a.materia_id" +
                "d.bot_chat_id = #{id}")
            //"group by b.aula_id, b.nombre, b.hora_inicio, b.hora_fin")
     List<HorarioDto> findHorarioByBotChatId(@Param("id")String botChatId);

}