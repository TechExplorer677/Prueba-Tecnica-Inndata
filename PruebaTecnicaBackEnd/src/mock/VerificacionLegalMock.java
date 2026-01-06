package mock;

import model.VerificacionLegal;
import providers.VerificacionLegalProvider;

public class VerificacionLegalMock implements VerificacionLegalProvider {
    @Override
    public VerificacionLegal verificarLegalidad(String idEmpresa) {
        // Retorna una verificación legal ficticia para pruebas
        return new VerificacionLegal(true,false,"Demanda mercantil activa");
    }
}
