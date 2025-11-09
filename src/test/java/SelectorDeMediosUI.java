import extension.FabricaDeMedios;
import extension.MedioWidget;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SelectorDeMediosUI {

    private final JFrame frame;
    private final List<MedioWidget> medios;
    private final ButtonGroup grupoSeleccion;

    public SelectorDeMediosUI() {
        FabricaDeMedios fabrica = new FabricaDeMedios();
        medios = fabrica.obtenerMedios();
        grupoSeleccion = new ButtonGroup();

        frame = new JFrame("Seleccionar Medio de Notificación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setPreferredSize(new Dimension(400, 350));

        // Panel central con los widgets
        JPanel centro = new JPanel(new GridLayout(0, 1, 10, 10));
        for (MedioWidget medio : medios) {
            centro.add(crearPanelConSeleccion(medio));
        }
        frame.add(centro, BorderLayout.CENTER);

        // --- Panel inferior con el botón más chico ---
        JButton guardarBtn = new JButton("Guardar selección");
        guardarBtn.setPreferredSize(new Dimension(150, 30)); // 👈 tamaño más pequeño
        guardarBtn.addActionListener(e -> guardarSeleccion());

        JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botonPanel.add(guardarBtn);
        frame.add(botonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Al inicio, deshabilitamos todos los campos
        setCamposHabilitados(false);
    }

    private JPanel crearPanelConSeleccion(MedioWidget medio) {
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JRadioButton radio = new JRadioButton("Usar " + medio.getNombre());
        grupoSeleccion.add(radio);
        contenedor.add(radio, BorderLayout.NORTH);

        JPanel panel = medio.getPanel();
        contenedor.add(panel, BorderLayout.CENTER);

        radio.addActionListener(e -> {
            for (MedioWidget m : medios) {
                boolean habilitar = (m == medio);
                habilitarCampos(m.getPanel(), habilitar);
            }
        });

        return contenedor;
    }

    private void habilitarCampos(JPanel panel, boolean habilitar) {
        for (Component comp : panel.getComponents()) {
            comp.setEnabled(habilitar);
        }
    }

    private void setCamposHabilitados(boolean habilitar) {
        for (MedioWidget medio : medios) {
            habilitarCampos(medio.getPanel(), habilitar);
        }
    }

    private void guardarSeleccion() {
        MedioWidget seleccionado = null;
        for (MedioWidget medio : medios) {
            JPanel panel = medio.getPanel();
            if (panel.isEnabled() && tieneCampoActivo(panel)) {
                seleccionado = medio;
                break;
            }
        }

        if (seleccionado == null) {
            JOptionPane.showMessageDialog(frame, "Debe seleccionar un medio antes de continuar.");
            return;
        }

        String dato = seleccionado.getDato();
        if (dato.isBlank()) {
            JOptionPane.showMessageDialog(frame, "Por favor complete el campo del medio seleccionado.");
            return;
        }

        JOptionPane.showMessageDialog(frame,
                "Medio seleccionado: " + seleccionado.getNombre() + "\nDato ingresado: " + dato);
    }

    private boolean tieneCampoActivo(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp.isEnabled() && comp instanceof JTextField) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SelectorDeMediosUI::new);
    }
}
