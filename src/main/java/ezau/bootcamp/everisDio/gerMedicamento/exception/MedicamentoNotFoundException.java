package ezau.bootcamp.everisDio.gerMedicamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MedicamentoNotFoundException extends Exception{
    public MedicamentoNotFoundException(long id) {
        super("Medicamento não encontrado - ID: " + id );
    }
}
