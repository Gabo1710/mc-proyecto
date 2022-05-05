package bo.edu.ucb.ingsoft.botuni.DTO;

import java.sql.Time;

public class HorarioDocenteDTO {

    private Integer id;
    private String siglas;
    private String materia;
    private Time horainicio;
    private Time horafin;
    private String aula;
    private String paralelo;
    private String dia;

    public HorarioDocenteDTO() {
    }

    public HorarioDocenteDTO(Integer id, String siglas, String materia, Time horainicio, Time horafin, String aula, String paralelo, String dia) {
        this.id = id;
        this.siglas = siglas;
        this.materia = materia;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.aula = aula;
        this.paralelo = paralelo;
        this.dia = dia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {
        this.horainicio = horainicio;
    }

    public Time getHorafin() {
        return horafin;
    }

    public void setHorafin(Time horafin) {
        this.horafin = horafin;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "HorarioDocenteDTO{" +
                "id=" + id +
                ", siglas='" + siglas + '\'' +
                ", materia='" + materia + '\'' +
                ", horainicio=" + horainicio +
                ", horafin=" + horafin +
                ", aula='" + aula + '\'' +
                ", paralelo='" + paralelo + '\'' +
                ", dia='" + dia + '\'' +
                '}';
    }
}

