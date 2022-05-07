package bo.edu.ucb.ingsoft.botuni.DAO;



import bo.edu.ucb.ingsoft.botuni.DTO.ListaPermisoEstudianteDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.ListaPermisoDocenteDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ListaPermisoDocenteDAO {
    //p.fecha_inicio, p.fecha_fin,
    @Select("SELECT  e.apellidos as apellidos, e.nombres as nombres, e.ci as ci ,p.fecha_inicio as fecha_inicio, p.fecha_fin as fecha_fin, p.razon as razon, p.estado_permiso as estado_permiso " +
            "FROM permiso p" +
            "   JOIN estudiante e ON (p.estudiante_id = e.estudiante_id) " +
            "   JOIN docente c ON (p.docente_id=c.docente_id) " +
            "WHERE " +
            " c.bot_chat_id = #{id} "  )

    List<ListaPermisoDocenteDTO> findListaPermisoDocenteByBotChatId(@Param("id")String botchatId);
}
