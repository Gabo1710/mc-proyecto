package bo.edu.ucb.ingsoft.botuni.ChatBot.widgets;

import java.util.List;

public class MenuWidget implements WidgetAbstracto{
    private List<String> items;
    private int choice;

    public MenuWidget(List<String> items) {
        this.items = items;
    }

    @Override
    public String showToUser() {
        StringBuffer sb = new StringBuffer();
        for (String item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
