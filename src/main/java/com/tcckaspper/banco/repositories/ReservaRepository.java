package com.tcckaspper.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcckaspper.banco.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
