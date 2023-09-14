package com.tcckaspper.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcckaspper.banco.models.Cliente;
import com.tcckaspper.banco.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImplements implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public Cliente atualizar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public List<Cliente> listarClientes() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente listarClienteId(Long id) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		return cliente.orElseThrow();
	}

	@Override
	public void remover(Long id) {
		this.clienteRepository.deleteById(id);

	}

	@Override
	public Cliente validarSenha(String senha) {
		this.clienteRepository.findByEmail(senha);
		return null;
	}

}
