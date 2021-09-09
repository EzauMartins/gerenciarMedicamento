package ezau.bootcamp.everisDio.gerMedicamento.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String tarja;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Tipo> tipo;


}
