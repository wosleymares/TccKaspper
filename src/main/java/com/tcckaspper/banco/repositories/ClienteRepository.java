package com.tcckaspper.banco.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcckaspper.banco.models.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Optional<Cliente> findByEmail(String senha);

}
