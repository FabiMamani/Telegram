import extension.Telegram;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TelegramTest {
    
    @Test
    public void TelegramTest(){
        Telegram telegram = new Telegram();
        String nombreExt = "Telegram";
        Assert.assertEquals(telegram.obtenerNombre(), nombreExt);
        
    }
}
