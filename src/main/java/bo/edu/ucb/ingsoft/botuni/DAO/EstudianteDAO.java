package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.AulaDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.EstudianteDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EstudianteDAO {
    @Select("SELECT estudiante_id, nombres, apellidos, bot_chat_id, ci, pass FROM estudiante")
    List<EstudianteDTO> findEstudianteById(@Param("estudianteId")Integer estudianteId);
}
