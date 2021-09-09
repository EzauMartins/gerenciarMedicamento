package ezau.bootcamp.everisDio.gerMedicamento.service;

import ezau.bootcamp.everisDio.gerMedicamento.dto.MensagemRetornoDTO;
import ezau.bootcamp.everisDio.gerMedicamento.entity.Medicamento;
import ezau.bootcamp.everisDio.gerMedicamento.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MedicamentoService {

    private MedicamentoRepository medicamentoRepository;

    @Autowired
    public MedicamentoService(MedicamentoRepository medicamentoRepository){
        this.medicamentoRepository = medicamentoRepository;
    }


    public MensagemRetornoDTO criarMedicamento(Medicamento medicamento) {
        Medicamento medicamentoSalvo = medicamentoRepository.save(medicamento);
        return crairMensagemResposta(medicamentoSalvo.getName(), "Medicamento Adicionado:");
    }

    public MensagemRetornoDTO crairMensagemResposta(String nome, String retorno){
        return MensagemRetornoDTO
                .builder()
                .menssagem(retorno + nome)
                .build();
    }
}
