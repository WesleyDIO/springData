package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.repository.ClienteRepository;
import net.weg.api.repository.HabilitacaoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;
    private HabilitacaoRepository habilitacaoRepository;

    public Cliente buscarUm(Integer id){
        return clienteRepository.findById(id).get();
    }

    public Collection<Cliente> buscarTodos(){
       return clienteRepository.findAll();
    }

    public void deletar(Integer id){
        clienteRepository.deleteById(id);
    }

    public void salvar(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
