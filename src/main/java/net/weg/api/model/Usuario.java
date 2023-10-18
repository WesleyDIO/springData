package net.weg.api.model;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "usuario")

public class Usuario {

   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
           private Integer id;
   @Column(name = "username", unique = true, nullable = false)
    private String usuario;
    private String senha;
    private Integer idade;
    @ManyToOne
    private Carro carro;

    public Usuario(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.usuario = resultSet.getString("nome");
        this.senha = resultSet.getString("Senha");
        this.idade = resultSet.getInt("idade");
        int idCarro = resultSet.getInt("id_carro");
        if (idCarro !=0) {
            this.carro = new Carro(idCarro);
        }
    }

}
