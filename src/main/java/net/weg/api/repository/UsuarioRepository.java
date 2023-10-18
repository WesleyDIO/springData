package net.weg.api.repository;



import net.weg.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
