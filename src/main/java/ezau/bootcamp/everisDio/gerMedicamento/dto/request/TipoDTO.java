package ezau.bootcamp.everisDio.gerMedicamento.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDTO {

    private Long id;

    @Size(min =2, max = 20)
    @NotEmpty
    private String tipoMed ;

    @Size(min =1, max = 10)
    @NotEmpty
    private String medida;
}
