package bo.edu.ucb.ingsoft.botuni.DTO;

public class EstudianteDto {
    private Integer estudiante_id;
    private String nombres;
    private String apellidos;
    private String bot_chat_id;

    public EstudianteDto() {
    }

    public EstudianteDto(Integer estudiante_id, String nombres, String apellidos, String bot_chat_id) {
        this.estudiante_id = estudiante_id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.bot_chat_id = bot_chat_id;
    }

    public Integer getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Integer estudiante_id) {
        this.estudiante_id = estudiante_id;
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

    public String getBot_chat_id() {
        return bot_chat_id;
    }

    public void setBot_chat_id(String bot_chat_id) {
        this.bot_chat_id = bot_chat_id;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "estudianteId=" + estudiante_id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", botchatid='" + bot_chat_id + '\'' +
                '}';
    }
}
