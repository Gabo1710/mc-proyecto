package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.CarreraDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarreraDAO {
    @Select("SELECT carrera_id, carrera FROM carrera")
    List<CarreraDTO> findCarreraByPk(@Param("carreraId")Integer carreraId);
}
