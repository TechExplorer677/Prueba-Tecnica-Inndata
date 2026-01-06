package providers;

import model.VerificacionLegal;

public interface VerificacionLegalProvider {
    VerificacionLegal verificarLegalidad(String idEmpresa);
}
