package bo.edu.ucb.ingsoft.botuni.DTO;

import java.sql.Time;
import java.util.Date;

public class HorarioDto {
    private Integer estudianteId;
    private String codigo;
    private String materia;
    private Time horainicio;
    private Time horafin;
    private String dia;

    public HorarioDto() {
    }

    public HorarioDto(Integer estudianteId, String codigo, String materia, Time horainicio, Time horafin, String dia) {
        this.estudianteId = estudianteId;
        this.codigo = codigo;
        this.materia = materia;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.dia = dia;
    }

    public Integer getEstudianteId(){return estudianteId;}

    public void setEstudianteId (Integer estudianteId) {this.estudianteId = estudianteId;}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {this.materia = materia; }

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {this.horainicio = horainicio; }

    public Time getHorafin() {    return horafin;}

    public void setHorafin(Time horafin) {this.horafin = horafin; }

    public String getDia(String dia) {return dia;}

    public void setDia(String dia) {this.dia = dia;}


    @Override
    public String toString() {
        return "HorarioDto{" +
                "estudiante_id" + estudianteId +
                ", codigo=" + codigo +
                ", materia=" + materia +
                ", horainicio=" + horainicio +
                ", horafin=" + horafin +
                ", dia=" + dia +'}';
    }
}