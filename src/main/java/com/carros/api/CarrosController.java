package com.carros.api;

import com.carros.domain.Carro;
import com.carros.domain.CarroService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carros")
public class CarrosController {
	@Autowired

	private CarroService service = new CarroService();
	
	
	@GetMapping()
	public ResponseEntity<Iterable<Carro>> get() {
		return new ResponseEntity<>(service.getCarros(), HttpStatus.OK) ;


	}
	
	@GetMapping("/{id}")
	public ResponseEntity get (@PathVariable("id") Long id) {
		Optional<Carro> carro =  service.getCarrosById(id);


		if(carro.isPresent()) {
			Carro c = carro.get();
			return ResponseEntity.ok(carro.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/tipo/{tipo}")
	public Iterable<Carro>get(@PathVariable("tipo") String tipo) {
		return service.getCarrosByTipo(tipo);


	}
	
	@GetMapping("/nome/{nome}")
	public Iterable<Carro>getNome(@PathVariable("nome") String nome) {
		return service.getCarrosByNome(nome);


	}
	

	@GetMapping("/v2")
		public List<Carro>getCarros2() {
		
		return service.getCarros2();
		
		
		
	}
	
	@PostMapping
	public String post (@RequestBody Carro carro) {
		Carro c = service.save(carro);
		 
		return "Carro salvo com sucesso: "+c.getId();
		
	}
	
	@DeleteMapping("/{id}")
	public String delete (@PathVariable("id")Long id) {
		service.delete(id);
		
		return "Carro deletado com sucesso";
	}
	
	@GetMapping("/tipo")
	public Iterable <Carro> getTipo(@RequestParam () String tipo){
		return service.getCarrosByTipo(tipo);
	}
	
	
	

	

	
	


	

	

	
	
	
	

	
	
	
}
