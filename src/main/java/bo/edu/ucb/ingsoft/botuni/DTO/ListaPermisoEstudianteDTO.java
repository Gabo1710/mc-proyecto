package bo.edu.ucb.ingsoft.botuni.DTO;

import java.sql.Date;


public class ListaPermisoEstudianteDTO {

    private Integer permiso_id;
    private Integer estudiante_id;
    private Integer docente_id;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String razon;
    private String estado_permiso;

    public ListaPermisoEstudianteDTO(Integer permiso_id, Integer estudiante_id, Integer docente_id, Date fecha_inicio, Date fecha_fin, String razon, String estado_permiso) {
        this.permiso_id = permiso_id;
        this.estudiante_id = estudiante_id;
        this.docente_id = docente_id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.razon = razon;
        this.estado_permiso = estado_permiso;
    }

    public Integer getPermiso_id() {
        return permiso_id;
    }

    public void setPermiso_id(Integer permiso_id) {
        this.permiso_id = permiso_id;
    }

    public Integer getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Integer estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public Integer getDocente_id() {
        return docente_id;
    }

    public void setDocente_id(Integer docente_id) {
        this.docente_id = docente_id;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getEstado_permiso() {
        return estado_permiso;
    }

    public void setEstado_permiso(String estado_permiso) {
        this.estado_permiso = estado_permiso;
    }

    @Override
    public String toString() {
        return "ListaPermisoEstudianteDTO{" +
                "permiso_id=" + permiso_id +
                ", estudiante_id=" + estudiante_id +
                ", docente_id=" + docente_id +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", razon='" + razon + '\'' +
                ", estado_permiso='" + estado_permiso + '\'' +
                '}';
    }
}
