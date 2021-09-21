package ezau.bootcamp.everisDio.gerMedicamento.controller;


import ezau.bootcamp.everisDio.gerMedicamento.dto.MensagemRetornoDTO;
import ezau.bootcamp.everisDio.gerMedicamento.dto.request.MedicamentoDTO;
import ezau.bootcamp.everisDio.gerMedicamento.entity.Medicamento;
import ezau.bootcamp.everisDio.gerMedicamento.exception.MedicamentoNotFoundException;
import ezau.bootcamp.everisDio.gerMedicamento.repository.MedicamentoRepository;
import ezau.bootcamp.everisDio.gerMedicamento.service.MedicamentoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medicamentos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MedicamentoController {

    private MedicamentoService medicamentoService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRetornoDTO criarMedicamento(@RequestBody @Valid MedicamentoDTO medicamentoDTO){ // ALTERADO PARA DTO @ VALIDAT
        return medicamentoService.criarMedicamento(medicamentoDTO);
    }

    @GetMapping
    public List<MedicamentoDTO> ListAll() {
        return medicamentoService.listAll();
    }

    @GetMapping("/{id}")
    public MedicamentoDTO findById(@PathVariable Long id) throws MedicamentoNotFoundException {
        return medicamentoService.findById(id);
    }


}
