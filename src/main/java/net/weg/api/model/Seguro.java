package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_plano")
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
    private Seguradora seguradora;
    @OneToOne
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;

}
