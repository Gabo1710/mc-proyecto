package bo.edu.ucb.ingsoft.botuni.DTO;

public class ListaEstudianteDTO {
    private String nombres;
    private String apellidos;
    private String ci;

    public ListaEstudianteDTO() {
    }

    public ListaEstudianteDTO(String nombres, String apellidos, String ci) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @Override
    public String toString() {
        return "ListaEstudianteDTO{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ci='" + ci + '\'' +
                '}';
    }
}
