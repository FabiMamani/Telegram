
import classroom.notifier.implement.MedioComunicacion;
import notificadores.Telegram;
import notificadores.Whatsapp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class NotificadorTest {
    public MedioComunicacion notificador;
    @Test
    public void WhatsappTest(){
        notificador = new Telegram();
        notificador.Notificar("PP2","A0102", null);
    }


}
