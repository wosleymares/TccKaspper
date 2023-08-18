package com.tcckaspper.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcckaspper.banco.models.Anuncio;
import com.tcckaspper.banco.repositories.AnuncioRepository;
import jakarta.transaction.Transactional;

@Service
public class AnuncioServiceImplements implements AnuncioService{
	
	@Autowired
	private AnuncioRepository anuncioRepository;

	@Override
	@Transactional
	public Anuncio salvar(Anuncio anuncio) {
		return this.anuncioRepository.save(anuncio);
	}

	@Override
	@Transactional
	public Anuncio atualizar(Anuncio anuncio) {
		return this.anuncioRepository.save(anuncio);
	}

	@Override
	@Transactional
	public List<Anuncio> listarAnuncio() {
		return this.anuncioRepository.findAll();
	}

	@Override
	public Anuncio listarAnuncioId(Long id) {
		Optional<Anuncio> anuncio = this.anuncioRepository.findById(id);
		return anuncio.orElseThrow();
	}

	@Override
	public void remover(Long id) {
		this.anuncioRepository.deleteById(id);
		
	}


}
