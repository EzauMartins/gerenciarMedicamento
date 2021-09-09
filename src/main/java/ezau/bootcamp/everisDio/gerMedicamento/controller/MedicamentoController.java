package ezau.bootcamp.everisDio.gerMedicamento.controller;


import ezau.bootcamp.everisDio.gerMedicamento.entity.Medicamento;
import ezau.bootcamp.everisDio.gerMedicamento.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MedicamentoController {

    private MedicamentoRepository medicamentoRepository;

    @Autowired
    public MedicamentoController(MedicamentoRepository medicamentoRepository){
        this.medicamentoRepository = medicamentoRepository;
    }


    @PostMapping
    public String criarMedicamento(@RequestBody Medicamento medicamento){
        medicamentoRepository.save(medicamento);
        return "Medicamento Criado";
    }


}
