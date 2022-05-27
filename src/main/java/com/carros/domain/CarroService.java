package com.carros.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CarroService {
	
	@Autowired
	private CarroRepository rep;
	
	public Iterable<Carro> getCarros(){
		return rep.findAll();
	}
	

    
	
	public List<Carro>getCarrosFake(){
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L,"Fusca"));
        carros.add(new Carro(2L,"Jetta"));
        carros.add(new Carro(3L,"Lixo"));
        carros.add(new Carro(4L, "Touareg"));
        carros.add(new Carro (5L, "golzinho"));

        return carros;
    }
    
    public List<Carro>getCarros2(){
    	List<Carro> carros2 = new ArrayList<>();
    	
    	carros2.add(new Carro (1L, "Tiguan"));
    	carros2.add(new Carro (2L, "Bimba"));
    	carros2.add(new Carro(80L, "Jetta"));
    	
    	return carros2;
    	
    }

	public Iterable<Carro> getCarrosByTipo(String tipo) {
		// TODO Auto-generated method stub
		return rep.findByTipo(tipo);
	}
	
	public Optional<Carro> getCarrosById(Long id) {
		// TODO Auto-generated method stub
		return rep.findById(id);
	}




	public Iterable<Carro> getCarrosByNome(String nome) {
		// TODO Auto-generated method stub
		return rep.findByNome(nome);
	}




	public Carro save(Carro carro) {
		return rep.save(carro);
		
	}




	public void delete(Long id) {
		Optional<Carro> carro = getCarrosById(id);
		if(carro.isPresent()) {
		rep.deleteById(id);
		}
	}





   
    	
    
}
