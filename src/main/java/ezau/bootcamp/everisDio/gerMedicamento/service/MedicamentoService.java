package ezau.bootcamp.everisDio.gerMedicamento.service;

import ezau.bootcamp.everisDio.gerMedicamento.dto.MensagemRetornoDTO;
import ezau.bootcamp.everisDio.gerMedicamento.dto.request.MedicamentoDTO;

import ezau.bootcamp.everisDio.gerMedicamento.entity.Medicamento;
import ezau.bootcamp.everisDio.gerMedicamento.mapper.MedicamentoMap;
import ezau.bootcamp.everisDio.gerMedicamento.repository.MedicamentoRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class MedicamentoService {

    private MedicamentoRepository medicamentoRepository;

    private final MedicamentoMap medicamentoMap = MedicamentoMap.INSTANCE;



    public MensagemRetornoDTO criarMedicamento(MedicamentoDTO medicamentoDTO) {

        Medicamento medicamentoAsalvar = medicamentoMap.toModel(medicamentoDTO);

        Medicamento medicamentoSalvo = medicamentoRepository.save(medicamentoAsalvar);
        return crairMensagemResposta(medicamentoSalvo.getId(),"Medicamento add iD:");
    }

    public MensagemRetornoDTO crairMensagemResposta(Long id, String retorno){
        return MensagemRetornoDTO
                .builder()
                .menssagem(retorno + id)
                .build();

}}
