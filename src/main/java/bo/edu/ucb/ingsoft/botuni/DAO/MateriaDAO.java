package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDetalleDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MateriaDAO {
    @Select("SELECT a.materia_id, a.semestre_id, a.carrera_id, a.materia, a.siglas," +
            "FROM materia a" +
            "JOIN semestre b ON (a.semestre_id=b.semestre_id)" +
            "JOIN carrera c ON (a.carrera_id = c.carrera_id)" +
            "JOIN materia_detalle d ON (a.materia_id = d.materia_id)" +
            "JOIN docente e ON (e.docente_id = d.docente_id)" +
            "WHERE" +
            "e.bot_chat_id = #{id}" )
    List<MateriaDTO> findMateria(@Param("id")String botchatId);
}
