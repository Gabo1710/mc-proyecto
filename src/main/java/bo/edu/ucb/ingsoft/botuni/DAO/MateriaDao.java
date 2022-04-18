package bo.edu.ucb.ingsoft.botuni.DAO;

import bo.edu.ucb.ingsoft.botuni.DTO.EstudianteDto;
import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MateriaDao {
    @Select("SELECT a.materia_id , a.coidgo, a.aula_id, a.nombre, a.hora_inicio, a.hora_fin, a.dia FROM materia a, aula b WHERE a.aula_id=b.aula_id")
    public List<MateriaDto> findAllMateria();
}