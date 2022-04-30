package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.SemestreDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SemestreDAO {
    @Select("SELECT semestre_id, codigo FROM semestre")
    List<SemestreDTO> findSemestreByPk(@Param("semestreaId")Integer semestreId);
}
