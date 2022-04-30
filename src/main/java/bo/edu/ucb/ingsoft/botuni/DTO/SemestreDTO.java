package bo.edu.ucb.ingsoft.botuni.DTO;

public class SemestreDTO {
    private Integer semestreId;
    private String codigo;

    public SemestreDTO() {
    }

    public SemestreDTO(Integer semestreId, String codigo) {
        this.semestreId = semestreId;
        this.codigo = codigo;
    }

    public Integer getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Integer semestreId) {
        this.semestreId = semestreId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "SemestreDTO{" +
                "semestreId=" + semestreId +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
