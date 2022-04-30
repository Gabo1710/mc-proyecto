package bo.edu.ucb.ingsoft.botuni.DTO;

public class AulaDTO {
    private Integer aulaId;
    private String codigoAula;
    private String bloque;

    public AulaDTO() {
    }

    public AulaDTO(Integer aulaId, String codigoAula, String bloque) {
        this.aulaId = aulaId;
        this.codigoAula = codigoAula;
        this.bloque = bloque;
    }

    public Integer getAulaId() {
        return aulaId;
    }

    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }

    public String getCodigoAula() {
        return codigoAula;
    }

    public void setCodigoAula(String codigoAula) {
        this.codigoAula = codigoAula;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    @Override
    public String toString() {
        return "AulaDTO{" +
                "aulaId=" + aulaId +
                ", codigoAula='" + codigoAula + '\'' +
                ", bloque='" + bloque + '\'' +
                '}';
    }
}
