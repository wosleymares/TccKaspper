package com.tcckaspper.banco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcckaspper.banco.models.Anuncio;
import com.tcckaspper.banco.services.AnuncioServiceImplements;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/anuncios")
public class AnuncioController {
	
	@Autowired
	private AnuncioServiceImplements anuncioService;

	@GetMapping
	public ResponseEntity<List<Anuncio>> listarTodos() {
		List<Anuncio> anuncio = this.anuncioService.listarAnuncio();
		return new ResponseEntity<>(anuncio, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Anuncio> listarAnuncioId(@PathVariable Long id) {
		Anuncio anuncio = this.anuncioService.listarAnuncioId(id);
		return ResponseEntity.ok().body(anuncio);
	}
	
	@PostMapping
	public ResponseEntity<Anuncio> salvar(@Valid @RequestBody Anuncio anuncio){
		this.anuncioService.salvar(anuncio);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Anuncio> atualizar(@RequestBody Anuncio anuncio) {
		return ResponseEntity.ok(this.anuncioService.atualizar(anuncio));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id) {
		this.anuncioService.remover(id);
		return ResponseEntity.ok("Usuário removido! ");
	}
	

}
