package net.weg.api.service;

import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
@AllArgsContructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private CarroService carroService;

    public Usuario buscarUm(Integer id){
        return usuarioRepository.findById(id).get();
    }

    public Collection<Usuario> buscarTodos(){
       return usuarioRepository.findAll().get();
    }

    public void deletar(Integer id){
        usuarioRepository.deleteById(id);
    }

    public void salvar(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
