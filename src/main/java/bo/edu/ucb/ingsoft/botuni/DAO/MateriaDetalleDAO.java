package bo.edu.ucb.ingsoft.botuni.DAO;


import bo.edu.ucb.ingsoft.botuni.DTO.MateriaDetalleDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MateriaDetalleDAO {
    @Select("SELECT a.materia_detalle_id, a.materia_id, a.aula_id, a.docente_id, a.hora_inicio," +
            "a.hora_fin, a.paralelo, a.dia" +
            "FROM materia_detalle a" +
            "JOIN docente b ON (a.docente_id=b.docente_id) \" +\n" +
            "JOIN materia c ON (a.materia_id = c.materia_id) \" +\n" +
            "JOIN aula d ON (a.aula_id = d.aula_id) \" +\n")
    List<MateriaDetalleDTO> findMateriaDetalleByPk(@Param("materiaDetalleId")Integer materiaDetalleId);

}
