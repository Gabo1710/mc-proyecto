package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.AutentificacionDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AutentificacionDAO {

    @Select("SELECT * " +
            "FROM permiso p" +
            "   JOIN estudiante e ON (p.estudiante_id = e.estudiante_id) " +
            "   JOIN docente c ON (p.docente_id=c.docente_id) " +
            "WHERE " +
            " e.bot_chat_id = #{id} "  )

    List<AutentificacionDTO> findAutentificacionByBotChatId(@Param("id")String botchatId);
}
