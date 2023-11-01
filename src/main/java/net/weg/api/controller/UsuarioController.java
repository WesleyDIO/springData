package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Cliente;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService clienteService;

    @GetMapping("/{id}")
    public Cliente buscarUm(@PathVariable Integer id){
        return clienteService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Cliente> buscarTodos(){
        return clienteService.buscarTodos();
    }
    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        clienteService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
    }

    @PutMapping()
    public void atualizar(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
    }



}

