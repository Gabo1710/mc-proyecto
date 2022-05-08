package bo.edu.ucb.ingsoft.botuni.DAO;



import bo.edu.ucb.ingsoft.botuni.DTO.NotaDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface NotaDAO {
    //p.fecha_inicio, p.fecha_fin,
    @Select("SELECT p.evaluacionc, p.evaluacionf, p.nota_final, c.siglas " +
            "FROM Estudiante_Materia p" +
            "   JOIN estudiante e ON (p.estudiante_estudiante_id = e.estudiante_id) " +
            "   JOIN materia c ON (p.materia_materia_id = c.materia_id) " +
            "WHERE " +
            " e.bot_chat_id = #{id} "  )

    List<NotaDTO> findNotaByBotChatId(@Param("id")String botchatId);
}