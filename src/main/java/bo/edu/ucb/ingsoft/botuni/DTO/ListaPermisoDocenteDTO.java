package bo.edu.ucb.ingsoft.botuni.DTO;
import java.sql.Date;

public class ListaPermisoDocenteDTO {

    private String apellidos;
    private String nombres;
    private String ci;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String razon;
    private String estado_permiso;

    public ListaPermisoDocenteDTO(String apellidos, String nombres, String ci, Date fecha_inicio, Date fecha_fin, String razon, String estado_permiso) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.ci = ci;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.razon = razon;
        this.estado_permiso = estado_permiso;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
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
        return "ListaPermisoDocenteDTO{" +
                "apellidos='" + apellidos + '\'' +
                ", nombres='" + nombres + '\'' +
                ", ci='" + ci + '\'' +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", razon='" + razon + '\'' +
                ", estado_permiso='" + estado_permiso + '\'' +
                '}';
    }
}
