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

import com.tcckaspper.banco.models.Reserva;
import com.tcckaspper.banco.services.ReservaServiceImplements;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaServiceImplements reservaService;

	@GetMapping
	public ResponseEntity<List<Reserva>> listarTodos() {
		List<Reserva> reserva = this.reservaService.listarReservas();
		return new ResponseEntity<>(reserva, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reserva> listarReservaId(@PathVariable Long id) {
		Reserva reserva = this.reservaService.listarReservaId(id);
		return ResponseEntity.ok().body(reserva);
	}

	@PostMapping
	public ResponseEntity<Reserva> salvar(@Valid @RequestBody Reserva reserva) {
		this.reservaService.salvar(reserva);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<Reserva> atualizar(@RequestBody Reserva reserva) {
		return ResponseEntity.ok(this.reservaService.atualizar(reserva));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id) {
		this.reservaService.remover(id);
		return ResponseEntity.ok("Reserva removida! ");
	}

}