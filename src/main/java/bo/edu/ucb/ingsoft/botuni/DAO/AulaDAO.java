package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.AulaDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface AulaDAO {
    @Select("SELECT aula_id, codigo_aula, bloque FROM aula")
    List<AulaDTO> findAulaByPk(@Param("aulaId")Integer aulaId);
}
