package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.HorarioEstudianteDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.ListaEstudianteDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ListaEstudianteDAO {
    @Select("SELECT a.apellidos as apellidos, a.nombres as nombres, a.ci as Carnet " +
            "FROM estudiante a " +
            "   JOIN materia_detalle_estudiante e ON (a.estudiante_id = e.estudiante_id) " +
            "   JOIN materia_detalle b ON (b.materia_detalle_id = e. materia_detalle_id) " +
            "   JOIN docente c ON (b.docente_id=c.docente_id) " +
            "   JOIN materia d ON (b.materia_id = d.materia_id) " +
            "WHERE " +
            " c.bot_chat_id = #{id} " +
            "GROUP BY a.apellidos, a.nombres, a.ci " )
    List<ListaEstudianteDTO> findListaEstudianteByBotChatId(@Param("id")String botchatId);
}

