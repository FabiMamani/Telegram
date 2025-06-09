


import classroom.notifier.interfaces.Observer;
import notificadores.Telegram;
import org.junit.jupiter.api.Test;


public class NotificadorTest {

    @Test
    public void TelegramTest(){
        Observer notificador =  new Telegram();
        String msj = "La materia pp3 cambio al aula A0102";
        notificador.update(msj);
    }
}
