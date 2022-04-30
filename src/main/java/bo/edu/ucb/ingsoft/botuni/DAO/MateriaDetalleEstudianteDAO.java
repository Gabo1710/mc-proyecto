package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDetalleEstudianteDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface MateriaDetalleEstudianteDAO {
    @Select(" SELECT e.dia as dia, f.codigo_aula as aula, d.materia as materia, e.hora_inicio as horainicio, e.hora_fin as horafin " +
            " FROM materia_detalle_estudiante a " +
            "   JOIN materia_detalle e ON (a.materia_detalle_id = e.materia_detalle_id)" +
            "   JOIN estudiante b ON (a.estudiante_id = b.estudiante_id)" +
            "   JOIN docente c ON (e.docente_id=c.docente_id)" +
            "   JOIN materia d ON (e.materia_id = d.materia_id)" +
            "   JOIN aula f ON (e.aula_id = f.aula_id)" +
            " WHERE" +
            " b.bot_chat_id = #{id}")
    List<MateriaDetalleEstudianteDTO> findMateriaDetalleEstudianteByBotChatId(@Param("id")String botchatId);

}
/**@Select(" SELECT a.materia_detalle_estudiante_id, a.materia_detalle_id, a.estudiante_id, a.tipo_nota, a.nota" +
" FROM materia_detalle_estudiante a" +
"   JOIN materia_detalle e ON (a.materia_detalle_id = e.materia_detalle_id)" +
"   JOIN estudiante b ON (a.estudiante_id = b.estudiante_id)" +
"   JOIN docente c ON (e.docente_id=c.docente_id)" +
"   JOIN materia d ON (e.materia_id = d.materia_id)" +
"   JOIN aula f ON (e.aula_id = f.aula_id)" +
" WHERE" +
" b.bot_chat_id = #{id}")**/