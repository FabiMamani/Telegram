package extension;

import javax.swing.*;
import java.awt.*;

public class TelegramWidget implements MedioWidget{
    private JPanel panel;
    private JTextField phoneField;
    public TelegramWidget() {
        panel = new JPanel(new GridLayout(2, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Telegram"));
        panel.add(new JLabel("Ingrese su número de teléfono:"));

        phoneField = new JTextField();
        panel.add(phoneField);
    }
    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getNombre() {
        return "Telegram";
    }

    @Override
    public String getDato() {
        return phoneField.getText();
    }

    @Override
    public void notificar() {
        System.out.println("Enviando notificación");
    }
}
