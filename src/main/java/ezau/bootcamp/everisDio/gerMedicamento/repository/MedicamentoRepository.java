package ezau.bootcamp.everisDio.gerMedicamento.repository;

import ezau.bootcamp.everisDio.gerMedicamento.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicamentoRepository extends JpaRepository<Medicamento,Long> {
}
