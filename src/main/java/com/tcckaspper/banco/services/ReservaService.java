package com.tcckaspper.banco.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcckaspper.banco.models.Reserva;

@Service
public interface ReservaService {
	
		// Save
		Reserva salvar(Reserva reserva);

		// Update
		Reserva atualizar(Reserva reserva);

		// ListAll
		List<Reserva> listarReservas();

		// ListById
		Reserva listarReservaId(Long id);

		// Delete
		void remover(Long id);

}