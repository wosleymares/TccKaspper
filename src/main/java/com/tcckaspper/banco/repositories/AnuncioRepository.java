package com.tcckaspper.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcckaspper.banco.models.Anuncio;


	@Repository
	public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

	}
