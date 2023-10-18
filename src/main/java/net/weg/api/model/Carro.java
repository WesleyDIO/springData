package net.weg.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@NoArgsConstructor
@Entity
@Table (name = "carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = Generation.type.IDENTITY)
    private int id;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;
}
