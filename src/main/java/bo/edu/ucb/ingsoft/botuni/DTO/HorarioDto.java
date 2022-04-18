package bo.edu.ucb.ingsoft.botuni.DTO;

public class HorarioDto {
    private Integer horarioId;
    private Integer estudianteId;
    private Integer materiaId;

    public HorarioDto() {
    }

    public HorarioDto(Integer horarioId, Integer estudianteId, Integer materiaId) {
        this.horarioId = horarioId;
        this.estudianteId = estudianteId;
        this.materiaId = materiaId;
    }

    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {this.estudianteId = estudianteId; }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {this.materiaId = materiaId; }


    @Override
    public String toString() {
        return "HorarioDto{" +
                "horario_id=" + horarioId +
                ", estudiante_id=" + estudianteId +
                ", materia_id=" + materiaId +
                '}';
    }
}