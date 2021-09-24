package ezau.bootcamp.everisDio.gerMedicamento.service;

import ezau.bootcamp.everisDio.gerMedicamento.dto.MensagemRetornoDTO;
import ezau.bootcamp.everisDio.gerMedicamento.dto.request.MedicamentoDTO;

import ezau.bootcamp.everisDio.gerMedicamento.entity.Medicamento;
import ezau.bootcamp.everisDio.gerMedicamento.exception.MedicamentoNotFoundException;
import ezau.bootcamp.everisDio.gerMedicamento.mapper.MedicamentoMap;
import ezau.bootcamp.everisDio.gerMedicamento.repository.MedicamentoRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class MedicamentoService {

    private MedicamentoRepository medicamentoRepository;

    private final MedicamentoMap medicamentoMap = MedicamentoMap.INSTANCE;

    public MensagemRetornoDTO criarMedicamento(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamentoAsalvar = medicamentoMap.toModel(medicamentoDTO);

        Medicamento medicamentoSalvo = medicamentoRepository.save(medicamentoAsalvar);
        return criarMensagemResposta(medicamentoSalvo.getId(),"Medicamento adicionado id: ", " Nome: "+medicamentoSalvo.getName());
    }

    //RESPONSE
    public MensagemRetornoDTO criarMensagemResposta(Long id, String retorno, String nome){
        return MensagemRetornoDTO
                .builder()
                .menssagem(retorno + id + nome)
                .build();
    }

    //LIST
    public List<MedicamentoDTO> listAll() {
       List<Medicamento> allMedicamentos = medicamentoRepository.findAll();
       return allMedicamentos.stream()
               .map(medicamentoMap::toDTO)
               .collect(Collectors.toList());
    }

    //FIND
    public MedicamentoDTO findById(long id) throws MedicamentoNotFoundException {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new MedicamentoNotFoundException(id));
        return medicamentoMap.toDTO(medicamento);
    }

    //DELETE
    public void delById(Long id) throws MedicamentoNotFoundException {
        medicamentoRepository.findById(id)
                .orElseThrow(() -> new MedicamentoNotFoundException(id));
        medicamentoRepository.deleteById(id);
    }

    //UPDATE
    public MensagemRetornoDTO updateById(Long id, MedicamentoDTO medicamentoDTO) throws MedicamentoNotFoundException {
        medicamentoRepository.findById(id)
                .orElseThrow(() -> new MedicamentoNotFoundException(id));

        Medicamento medicamentoAsalvar = medicamentoMap.toModel(medicamentoDTO);

        Medicamento medicamentoAtualiza = medicamentoRepository.save(medicamentoAsalvar);
        return criarMensagemResposta(medicamentoAtualiza.getId(),"Medicamento Atualizado id: ", " Nome: "+medicamentoAtualiza.getName());


    }


}
