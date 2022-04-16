package bo.edu.ucb.ingsoft.botuni.DTO;

import java.util.Date;

public class ConsultaHorarioDto {
    private Integer consultaId;
    private Integer estudianteId;
    private Date fecha_consulta;
    private Date endDate;
    private String reason;

    public ConsultaHorarioDto() {
    }

    public ConsultaHorarioDto(Integer consultaId, Integer estudianteId, Date startDate) {
        this.consultaId = consultaId;
        this.estudianteId = estudianteId;
        this.fecha_consulta = startDate;
    }

    public Integer getPermissionId() {
        return consultaId;
    }

    public void setPermissionId(Integer permissionId) {
        this.consultaId = permissionId;
    }

    public Date getFecha_consulta() {
        return fecha_consulta;
    }

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudiante_id(Integer estudiante_id) {
        this.estudianteId = estudiante_id;
    }

    public void setFecha_consulta(Date fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }



    @Override
    public String toString() {
        return "ConsultaHorarioDto{" +
                "consultaId=" + consultaId +
                ", estudianteId=" + estudianteId +
                ", startDate=" + fecha_consulta +
                '}';
    }
}
