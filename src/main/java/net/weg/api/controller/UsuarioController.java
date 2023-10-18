package net.weg.api.controller;

import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioDAO;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Usuario buscarUm(@PathVariable Integer id){
        return usuarioService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos(){
        return usuarioService.buscarTodos();
    }
    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
    }

    @PutMapping()
    public void atualizar(@RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
    }



}

