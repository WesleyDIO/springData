package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.repository.SeguradoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguradoraService {
    private SeguradoraRepository seguradoraRepository;

    public void salvar(Seguradora seguradora){
        seguradoraRepository.save(seguradora);
    }

    public void deletar(Integer id){
        seguradoraRepository.deleteById(id);
    }

    public Seguradora buscarUm(Integer id){
        return seguradoraRepository.findById(id).get();
    }

    public List<Seguradora> buscarTodos(){
        return seguradoraRepository.findAll();
    }

}
