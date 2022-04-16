package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.EstudianteDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstudianteDao {
    @Select("SELECT estudiante_id, nombres, apellidos, bot_chat_id FROM estudiante")
    public List<EstudianteDto> findAllEstudiante();
}