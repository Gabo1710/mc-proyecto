package bo.edu.ucb.ingsoft.botuni.DTO;

public class SiglasDTO {
    private String siglas;

    public SiglasDTO() {
    }

    public SiglasDTO(String siglas) {
        this.siglas = siglas;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @Override
    public String toString() {
        return "SiglasDTO{" +
                "siglas='" + siglas + '\'' +
                '}';
    }
}

