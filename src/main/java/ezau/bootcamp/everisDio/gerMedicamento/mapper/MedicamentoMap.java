package ezau.bootcamp.everisDio.gerMedicamento.mapper;

import ezau.bootcamp.everisDio.gerMedicamento.dto.request.MedicamentoDTO;
import ezau.bootcamp.everisDio.gerMedicamento.entity.Medicamento;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicamentoMap {

    MedicamentoMap INSTANCE = Mappers.getMapper(MedicamentoMap.class);
    Medicamento toModel(MedicamentoDTO medicamentoDTO);

    MedicamentoDTO toDTO(Medicamento medicamento);

}
