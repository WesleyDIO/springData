package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {
    private SeguroService seguroService;
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        seguroService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.salvar(seguroCadastroDTO);
    }

    @PutMapping
    public void atualizar(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.salvar(seguroCadastroDTO);
    }

    @GetMapping("/{id}")
    public void buscarUm(@PathVariable Integer id){
        seguroService.buscarUm(id);
    }

}
