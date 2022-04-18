package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.AulaDto;
import bo.edu.ucb.ingsoft.botuni.DTO.EstudianteDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AulaDao {
    @Select("SELECT aula_id, bloque FROM aula")
    public List<AulaDto> findAllAula();
}