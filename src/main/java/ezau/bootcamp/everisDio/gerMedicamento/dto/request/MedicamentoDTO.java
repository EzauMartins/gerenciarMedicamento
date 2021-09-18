package ezau.bootcamp.everisDio.gerMedicamento.dto.request;

import ezau.bootcamp.everisDio.gerMedicamento.entity.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoDTO {


    private Long id;

    @Size(min =2, max = 20)
    @NotEmpty
    private String name;

    @Size(min =2, max = 10)
    @NotEmpty
    private String tarja;


    private String codBar;

    @Valid
    @NotEmpty
    private List<TipoDTO> tipo;

}
