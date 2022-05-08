package bo.edu.ucb.ingsoft.botuni.DTO;

public class AutentificacionDTO {

    String bot_chat_id;
    String Nombres;
    String Apellidos;

    public AutentificacionDTO(String bot_chat_id, String nombres, String apellidos) {
        this.bot_chat_id = bot_chat_id;
        Nombres = nombres;
        Apellidos = apellidos;
    }

    public String getBot_chat_id() {
        return bot_chat_id;
    }

    public void setBot_chat_id(String bot_chat_id) {
        this.bot_chat_id = bot_chat_id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "AutentificacionDTO{" +
                "bot_chat_id='" + bot_chat_id + '\'' +
                ", Nombres='" + Nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                '}';
    }
}
