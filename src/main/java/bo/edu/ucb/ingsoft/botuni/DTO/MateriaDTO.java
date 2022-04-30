package bo.edu.ucb.ingsoft.botuni.DTO;

public class MateriaDTO {
    private Integer materiaId;
    private SemestreDTO semestreId;
    private CarreraDTO carreraId;
    private Integer creditos;
    private String materia;
    private String siglas;

    public MateriaDTO() {
    }

    public MateriaDTO(Integer materiaId, SemestreDTO semestreId, CarreraDTO carreraId, Integer creditos, String materia, String siglas) {
        this.materiaId = materiaId;
        this.semestreId = semestreId;
        this.carreraId = carreraId;
        this.creditos = creditos;
        this.materia = materia;
        this.siglas = siglas;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public SemestreDTO getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(SemestreDTO semestreId) {
        this.semestreId = semestreId;
    }

    public CarreraDTO getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(CarreraDTO carreraId) {
        this.carreraId = carreraId;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @Override
    public String toString() {
        return "MateriaDTO{" +
                "materiaId=" + materiaId +
                ", semestreId=" + semestreId +
                ", carreraId=" + carreraId +
                ", creditos=" + creditos +
                ", materia='" + materia + '\'' +
                ", siglas='" + siglas + '\'' +
                '}';
    }
}
