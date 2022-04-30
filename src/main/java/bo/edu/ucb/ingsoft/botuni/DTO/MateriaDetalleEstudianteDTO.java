package bo.edu.ucb.ingsoft.botuni.DTO;

import org.jruby.util.Numeric;

import java.math.BigDecimal;

public class MateriaDetalleEstudianteDTO {
    private Integer materiaDetalleEstudianteId;
    private MateriaDetalleDTO materiaDetalleId;
    private EstudianteDTO estudianteId;
    private String tipoNota;
    private BigDecimal nota;

    public MateriaDetalleEstudianteDTO() {
    }

    public MateriaDetalleEstudianteDTO(Integer materiaDetalleEstudianteId, MateriaDetalleDTO materiaDetalleId, EstudianteDTO estudianteId, String tipoNota, BigDecimal nota) {
        this.materiaDetalleEstudianteId = materiaDetalleEstudianteId;
        this.materiaDetalleId = materiaDetalleId;
        this.estudianteId = estudianteId;
        this.tipoNota = tipoNota;
        this.nota = nota;
    }

    public Integer getMateriaDetalleEstudianteId() {
        return materiaDetalleEstudianteId;
    }

    public void setMateriaDetalleEstudianteId(Integer materiaDetalleEstudianteId) {
        this.materiaDetalleEstudianteId = materiaDetalleEstudianteId;
    }

    public MateriaDetalleDTO getMateriaDetalleId() {
        return materiaDetalleId;
    }

    public void setMateriaDetalleId(MateriaDetalleDTO materiaDetalleId) {
        this.materiaDetalleId = materiaDetalleId;
    }

    public EstudianteDTO getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(EstudianteDTO estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "MateriaDetalleEstudianteDTO{" +
                "materiaDetalleEstudianteId=" + materiaDetalleEstudianteId +
                ", materiaDetalleId=" + materiaDetalleId +
                ", estudianteId=" + estudianteId +
                ", tipoNota='" + tipoNota + '\'' +
                ", nota=" + nota +
                '}';
    }
}
