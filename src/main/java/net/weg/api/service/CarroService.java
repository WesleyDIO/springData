package net.weg.api.service;

import net.weg.api.model.Carro;
import net.weg.api.repository.CarroDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@AllArgsConstructor
@Service
public class CarroService {
    private CarroRepository
    carroRepository;




    public Collection<Carro> buscarTodos(){
        return carroRepository.findAll();
    }


    public void deletar( Integer id){
        carroRepository.deleteById(id);
    }


    public void salvar( Carro carro){
       carroRepository.save(carro);
    }

    public Carro buscarUm(Integer id) {
        return carroRepository.findById(id).get();
    }
}
