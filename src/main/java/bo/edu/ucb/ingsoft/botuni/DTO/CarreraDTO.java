package bo.edu.ucb.ingsoft.botuni.DTO;

public class CarreraDTO {
    private Integer carreraId;
    private String carrera;

    public CarreraDTO() {
    }

    public CarreraDTO(Integer carreraId, String carrera) {
        this.carreraId = carreraId;
        this.carrera = carrera;
    }

    public Integer getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "CarreraDTO{" +
                "carreraId=" + carreraId +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
