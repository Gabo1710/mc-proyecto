package bo.edu.ucb.ingsoft.botuni.DTO;

import java.sql.Date;


public class DeudaDTO {

    private Integer menualidad_id;
    private Integer tarifario_id;
    private Integer materiadetalleest_id;
    private Date fecha_pago;
    private String estado;
    private String interes;

    private String monto;

    public DeudaDTO(Integer menualidad_id, Integer tarifario_id, Integer materiadetalleest_id, Date fecha_pago, String estado, String interes, String monto) {
        this.menualidad_id = menualidad_id;
        this.tarifario_id = tarifario_id;
        this.materiadetalleest_id = materiadetalleest_id;
        this.fecha_pago = fecha_pago;
        this.estado = estado;
        this.interes= interes;
        this.monto= monto;

    }

    public Integer getMenualidad_id() {
        return menualidad_id;
    }

    public void setMenualidad_id(Integer menualidad_id) {
        this.menualidad_id = menualidad_id;
    }

    public Integer getTarifario_id() {
        return tarifario_id;
    }

    public void setTarifario_id(Integer tarifario_id) {
        this.tarifario_id = tarifario_id;
    }

    public Integer getMateriadetalleest_id() {
        return materiadetalleest_id;
    }

    public void setMateriadetalleest_id(Integer materiadetalleest_id) {
        this.materiadetalleest_id = materiadetalleest_id;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override


    public String toString() {
        return "DeudaDTO{" +
                "menualidad_id=" + menualidad_id +
                ", tarifario_id=" + tarifario_id +
                ", materiadetalleest_id=" + materiadetalleest_id +
                ", fecha_pago=" + fecha_pago +
                ", estado='" + estado + '\'' +
                ", interes='" + interes + '\'' +
                ", monto='" + monto + '\'' +
                '}';
    }
}
