package extension;

import javax.swing.*;
import java.awt.*;

public class GmailWidget implements MedioWidget {

    private JPanel panel;
    private JTextField emailField;

    public GmailWidget() {
        panel = new JPanel(new GridLayout(2, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Gmail"));
        panel.add(new JLabel("Ingrese su correo electrónico:"));

        emailField = new JTextField();
        panel.add(emailField);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getNombre() {
        return "Gmail";
    }

    @Override
    public String getDato() {
        return emailField.getText();
    }

    @Override
    public void notificar() {
        System.out.println("Notificacion por Gmail");
    }
}
