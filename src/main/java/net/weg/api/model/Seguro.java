package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_seguro")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SeguroIdClass.class)
public class Seguro {
//    @EmbeddedId
//    private SeguroId idComposto;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer seguroId;
 @Id
 private Integer seguradoraId;
    private Double valor;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
//    @MapsId("seguradoraId")
    @JoinColumn(name = "seguradoraId")
    private Seguradora seguradora;
    @OneToOne
//    @MapsId("veiculoId")
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;

}
