package extension;

import javax.swing.*;

public interface MedioWidget {
    JPanel getPanel();  // Devuelve el componente visual
    String getNombre(); // "Gmail", "Telegram", etc.
    String getDato();   // Devuelve el dato ingresado (mail, número, etc.)

    void notificar();
}