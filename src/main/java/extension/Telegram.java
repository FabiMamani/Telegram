package extension;

import interfaces.MedioComunicacion;

public class Telegram implements MedioComunicacion {
    @Override
    public void enviarComunicacion() {
        String msj = "Notificación enviada por "+obtenerNombre();
        System.out.println(msj);
    }

    @Override
    public String obtenerNombre() {
        String nombre =  "Telegram";
        return nombre;
    }
}
