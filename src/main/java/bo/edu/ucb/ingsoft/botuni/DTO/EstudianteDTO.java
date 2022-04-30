package bo.edu.ucb.ingsoft.botuni.DTO;

public class EstudianteDTO {
    private Integer estudianteId;
    private String nombres;
    private String apellidos;
    private String botchatId;
    private String ci;
    private String pass;

    public EstudianteDTO() {
    }

    public EstudianteDTO(Integer estudianteId, String nombres, String apellidos, String botchatId, String ci, String pass) {
        this.estudianteId = estudianteId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.botchatId = botchatId;
        this.ci = ci;
        this.pass = pass;
    }

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
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

    public String getBotchatId() {
        return botchatId;
    }

    public void setBotchatId(String botchatId) {
        this.botchatId = botchatId;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "estudianteId=" + estudianteId +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", botchatId='" + botchatId + '\'' +
                ", ci='" + ci + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
