package bo.edu.ucb.ingsoft.botuni.DAO;



import bo.edu.ucb.ingsoft.botuni.DTO.DeudaDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DeudaDAO {
    //p.fecha_inicio, p.fecha_fin,
    @Select("SELECT p.mensualidad_id, p.tarifario_id, p.materia_detalle_estudiante_id, p.fecha_pago, p.estado_mensualidad, y.monto, x.monto_mensual " +
            "FROM mensualidad p" +
            "   JOIN tarifario e ON (p.mensualidad_id = e.tarifario_id) " +
            "   JOIN materia_detalle_estudiante c ON (p.materia_detalle_estudiante_id = c.materia_detalle_estudiante_id) " +
            "   JOIN estudiante l ON (l.estudiante_id = c.estudiante_id) " +
            "   JOIN mensualidad_interes o ON (p.mensualidad_id = o.mensualidad_id) " +
            "   JOIN interes y ON (o.interes_id = y.interes_id) " +
            "   JOIN tarifario x ON (p.tarifario_id = x.tarifario_id) " +
            "WHERE " +
            " l.bot_chat_id = #{id} "  )

    List<DeudaDTO> findDeudaByBotChatId(@Param("id")String botchatId);
}