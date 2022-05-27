package com.carros.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class IndexController {
	String naninha;
	
	@GetMapping	
	public String get() {
		return "API dos carros";
	}
	

	
	@GetMapping("/carros/{id}")
	public String getCarroById(@PathVariable("id")Long id) {
		return"Carro By id:"+ id;
		
	}
	
	@GetMapping("/carros/tipo/{tipo}")
	public String getCarroByTipo(@PathVariable("tipo")String tipo) {
		return"Lista de Carros"+ tipo;
		
	}
	
	@GetMapping("carros/luxo/{luxo}")
	public String getLuxo(@PathVariable("luxo")String luxo) {
		return "Carros de luxo" +luxo;
	}
	
	@GetMapping("/carros/preco/{preco}")
	public String getPreco(@PathVariable("preco")String preco) {
		return "preço:" +preco;
	}
	
	@GetMapping("/carros/preco2/{preco2}")
	public int getPreco2(@PathVariable("preco2")int preco2) {
		return preco2;
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("login")String login,@RequestParam("senha") String senha) {
		return "login "+login+"senha "+senha;
		
	}
	
	
	
	
	
	

	
	
	
}
