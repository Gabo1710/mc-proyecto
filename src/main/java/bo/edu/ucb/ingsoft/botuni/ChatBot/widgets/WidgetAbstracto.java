package bo.edu.ucb.ingsoft.botuni.ChatBot.widgets;

/**
 * Widget será: Menu, Pregunta, Mensaje de una o varias lineas
 * MenuWidgetImpl: inicialmente muestra un menu al usuario.
 * QuestionWidgetImpl: Muestgra una pregunta al usuario y captura la información.
 * MessageWidget: Una o varias líneas que se le muestra al usuario.
 */

public interface WidgetAbstracto {
    // Va a mostrar algo al usuario.
    public String showToUser();
}
