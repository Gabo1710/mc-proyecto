package bo.edu.ucb.ingsoft.botuni.DTO;

import java.util.Date;

public class AulaDto {
    private String aulaId;
    private String bloque;


    public AulaDto() {
    }

    public AulaDto(String aulaId, String bloque) {
        this.aulaId = aulaId;
        this.bloque = bloque;
    }

    public String getAulaId() {
        return aulaId;
    }

    public void setAulaId(String aulaId) {
        this.aulaId = aulaId;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {this.bloque = bloque; }


    @Override
    public String toString() {
        return "AulaDto{" +
                "consulta_id=" + aulaId +
                ", estudiante_id=" + bloque +
                '}';
    }
}
