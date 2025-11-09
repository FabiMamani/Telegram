package extension;

import java.util.List;
import java.util.ArrayList;

public class FabricaDeMedios {

    public List<MedioWidget> obtenerMedios() {
        List<MedioWidget> medios = new ArrayList<>();
        medios.add(new GmailWidget());
        medios.add(new TelegramWidget());
        return medios;
    }
}

