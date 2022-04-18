package bo.edu.ucb.ingsoft.botuni.DTO;
import java.util.Date;

public class MateriaDto {
    private Integer materiaid;
    private String coidgo;
    private String aulaid;
    private String nombre;
    private Date hora_inicio;
    private Date hora_fin;
    private String dia;


    public MateriaDto() {
    }

    public MateriaDto(Integer materiaid, String coidgo, String aulaid, String nombre, Date hora_inicio, Date hora_fin, String dia) {
        this.materiaid = materiaid;
        this.coidgo = coidgo;
        this.aulaid = aulaid;
        this.nombre = nombre;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.dia = dia;


    }

    public Integer getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(Integer materiaid) {this.materiaid = materiaid;}

    public String getCoidgo() {
        return coidgo;
    }

    public void setCoidgo(String coidgo) {this.coidgo = coidgo; }

    public String getAulaid() {
        return aulaid;
    }

    public void setAulaid(String nombre) {this.aulaid = aulaid; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {this.coidgo = nombre; }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {this.dia = dia; }


    @Override
    public String toString() {
        return "MateriaDto{" +
                "materia_id=" + materiaid +
                ", coidgo=" + coidgo +
                "aula_id=" + aulaid +
                ", nombre=" + nombre +
                "hora_inicio=" + hora_inicio +
                ", hora_fin=" + hora_fin +
                "dia=" + dia +
                '}';
    }
}
