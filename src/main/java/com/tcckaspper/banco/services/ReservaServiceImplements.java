package com.tcckaspper.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcckaspper.banco.models.Reserva;
import com.tcckaspper.banco.repositories.ReservaRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservaServiceImplements implements ReservaService{
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	@Transactional
	public Reserva salvar (Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}

	@Override
	@Transactional
	public Reserva atualizar(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}

	@Override
	@Transactional
	public List<Reserva> listarReservas() {
		return this.reservaRepository.findAll();
	}

	@Override
	public Reserva listarReservaId(Long id) {
		Optional<Reserva> reserva = this.reservaRepository.findById(id);
		return reserva.orElseThrow();
	}

	@Override
	public void remover(Long id) {
		this.reservaRepository.deleteById(id);
		
	}
	
}
