package com.tcckaspper.banco.services;

import java.util.List;

import com.tcckaspper.banco.models.Anuncio;

public interface AnuncioService {

	// Save
	Anuncio salvar(Anuncio anuncio);

	// Update
	Anuncio atualizar(Anuncio anuncio);

	// ListAll
	List<Anuncio> listarAnuncio();

	// ListById
	Anuncio listarAnuncioId(Long id);

	// Delete
	void remover(Long id);

}
