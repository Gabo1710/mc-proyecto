package bo.edu.ucb.ingsoft.botuni.DTO;

public class ListaEstudianteDTO {
    private String nombres;
    private String apellidos;
    private String ci;
    private String materia;
    private Integer docenteId;

    public ListaEstudianteDTO() {
    }

    public ListaEstudianteDTO(String nombres, String apellidos, String ci, String materia, Integer docenteId) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
        this.materia = materia;
        this.docenteId = docenteId;
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

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Integer getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Integer docenteId) {
        this.docenteId = docenteId;
    }

    @Override
    public String toString() {
        return "ListaEstudianteDTO{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ci='" + ci + '\'' +
                ", materia='" + materia + '\'' +
                ", docenteId=" + docenteId +
                '}';
    }
}

