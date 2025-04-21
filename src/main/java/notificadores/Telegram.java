package notificadores;


import classroom.notifier.entity.Observable;
import classroom.notifier.implement.Observer;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Telegram implements Observer {
    String name = "Telegram";
    private static final String BOT_TOKEN = "7834829611:AAHBM2XOqC0F5dYFFqVlxENXNlgLYMq032w";
    private static final String CHAT_ID = "953342229";

    public static void sendMessage(String message) throws Exception {
        String urlString = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage?chat_id=" + CHAT_ID + "&text=" + message;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Leer la respuesta
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            System.out.println("Mensaje enviado con éxito!");
        } else {
            System.out.println("Error al enviar el mensaje: " + responseCode);
        }
        conn.disconnect();
    }

    @Override
    public void update(Observable observable, Object data) {
        try {
            sendMessage(new String((String) data));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //953342229
}
