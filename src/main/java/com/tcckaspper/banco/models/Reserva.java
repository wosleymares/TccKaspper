package com.tcckaspper.banco.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name= "reservas")
@Table(name="reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reserva {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name= "id_usuario", nullable = false, updatable = false)
	private Usuario usuario;
	

	@Column(name= "buffet",unique = true, nullable = false, length = 80)
	@NotNull
	private String buffet;
	
	@Column(name= "endereco",unique = true, nullable = false, length = 80)
	@NotNull
	private String endereco;
	
	@Column(name= "horario", length = 10)
	@JsonFormat(pattern = "hh:mm")
	private String horario;
	
	@Column(name= "data", length = 10)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
}
