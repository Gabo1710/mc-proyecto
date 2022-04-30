package bo.edu.ucb.ingsoft.botuni.DTO;

import java.sql.Time;
import java.util.Date;

public class MateriaDetalleDTO {
    private Integer materiaDetalleId;
    private MateriaDTO materiaId;
    private AulaDTO aulaId;
    private DocenteDTO docenteId;
    private Time horaInicio;
    private Time horaFin;
    private String paralelo;
    private  String dia;

    public MateriaDetalleDTO() {
    }

    public MateriaDetalleDTO(Integer materiaDetalleId, MateriaDTO materiaId, AulaDTO aulaId, DocenteDTO docenteId, Time horaInicio, Time horaFin, String paralelo, String dia) {
        this.materiaDetalleId = materiaDetalleId;
        this.materiaId = materiaId;
        this.aulaId = aulaId;
        this.docenteId = docenteId;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.paralelo = paralelo;
        this.dia = dia;
    }

    public Integer getMateriaDetalleId() {
        return materiaDetalleId;
    }

    public void setMateriaDetalleId(Integer materiaDetalleId) {
        this.materiaDetalleId = materiaDetalleId;
    }

    public MateriaDTO getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(MateriaDTO materiaId) {
        this.materiaId = materiaId;
    }

    public AulaDTO getAulaId() {
        return aulaId;
    }

    public void setAulaId(AulaDTO aulaId) {
        this.aulaId = aulaId;
    }

    public DocenteDTO getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(DocenteDTO docenteId) {
        this.docenteId = docenteId;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
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
        return "MateriaDetalleDTO{" +
                "materiaDetalleId=" + materiaDetalleId +
                ", materiaId=" + materiaId +
                ", aulaId=" + aulaId +
                ", docenteId=" + docenteId +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", paralelo='" + paralelo + '\'' +
                ", dia='" + dia + '\'' +
                '}';
    }
}
