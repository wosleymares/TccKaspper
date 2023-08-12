package com.tcckaspper.banco.services;

import java.util.List;

import com.tcckaspper.banco.models.Cliente;

public interface ClienteService {

	// Save
	Cliente salvar(Cliente cliente);

	// Update
	Cliente atualizar(Cliente cliente);

	// ListAll
	List<Cliente> listarClientes();

	// ListById
	Cliente listarClienteId(Long id);

	// Validation
	Cliente validarSenha(String senha);

	// Delete
	void remover(Long id);
}
