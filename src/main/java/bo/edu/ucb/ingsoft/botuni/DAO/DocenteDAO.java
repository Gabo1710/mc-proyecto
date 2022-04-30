package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.DocenteDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DocenteDAO {
    @Select("SELECT docente_id, nombres, apellidos, bot_chat_id, ci, pass FROM docente WHERE ")
    List<DocenteDTO> findDocenteById(@Param("docenteId")Integer docenteId);
}