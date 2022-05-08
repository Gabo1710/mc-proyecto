package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDTO;
import bo.edu.ucb.ingsoft.botuni.DTO.SiglasDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SiglasDAO {
    @Select("SELECT a.siglas," +
            "FROM materia a" )
    List<SiglasDTO> findMateriabySigla(@Param("siglas")String siglas);
}