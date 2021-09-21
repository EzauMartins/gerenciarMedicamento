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
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class MedicamentoService {

    private MedicamentoRepository medicamentoRepository;

    private final MedicamentoMap medicamentoMap = MedicamentoMap.INSTANCE;



    public MensagemRetornoDTO criarMedicamento(MedicamentoDTO medicamentoDTO) {

        Medicamento medicamentoAsalvar = medicamentoMap.toModel(medicamentoDTO);

        Medicamento medicamentoSalvo = medicamentoRepository.save(medicamentoAsalvar);
        return crairMensagemResposta(medicamentoSalvo.getId(),"Medicamento adicionado id: ", " Nome: ");
    }

    public MensagemRetornoDTO crairMensagemResposta(Long id, String retorno,String nome){
        return MensagemRetornoDTO
                .builder()
                .menssagem(retorno + id + nome)
                .build();

}

    public List<MedicamentoDTO> listAll() {
       List<Medicamento> allMedicamentos = medicamentoRepository.findAll();
       return allMedicamentos.stream()
               .map(medicamentoMap::toDTO)
               .collect(Collectors.toList());
    }

    public MedicamentoDTO findById(long id) throws MedicamentoNotFoundException {
        Optional<Medicamento> optionalMedicamento = medicamentoRepository.findById(id);
        if(optionalMedicamento.isEmpty()){
            throw new MedicamentoNotFoundException(id);
        }
        return medicamentoMap.toDTO(optionalMedicamento.get());

    }

}
