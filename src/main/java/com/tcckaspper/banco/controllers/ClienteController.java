package com.tcckaspper.banco.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcckaspper.banco.models.Cliente;
import com.tcckaspper.banco.repositories.ClienteRepository;
import com.tcckaspper.banco.services.ClienteServiceImplements;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private final ClienteRepository repository;
	private final PasswordEncoder encoder;
	
	public ClienteController(ClienteRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}

	@Autowired
	private ClienteServiceImplements clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos() {
		List<Cliente> clientes = this.clienteService.listarClientes();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarClienteId(@PathVariable Long id) {
		Cliente cliente = this.clienteService.listarClienteId(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@GetMapping("/validarSenha")
	public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
												@RequestParam String senha){
		Optional<Cliente> optCliente = repository.findByLogin(login);
		if(optCliente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		
		Cliente cliente = optCliente.get();
		boolean valid = encoder.matches(senha, cliente.getSenha());
		
		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return ResponseEntity.status(status).body(valid);
	}

	@PostMapping
	public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente){
		this.clienteService.salvar(cliente);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/validation")
	public ResponseEntity<Cliente> validation(@RequestBody Cliente cliente){
		cliente.setSenha(encoder.encode(cliente.getSenha()));
		return ResponseEntity.ok (repository.save(cliente));
	}

	@PutMapping
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(this.clienteService.atualizar(cliente));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id) {
		this.clienteService.remover(id);
		return ResponseEntity.ok("Usuário removido! ");
	}

}
