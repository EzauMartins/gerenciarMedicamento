package ezau.bootcamp.everisDio.gerMedicamento.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // INDICA O ESTADO DO MEDICAMENTO(CAPSULA,COMPRIMIDO,LIQUIDO)
    private String tipoMed;

    @Column(nullable = false) // INDICA MEDIDADA (ml,Litro,unidade)
    private String medida;



}
