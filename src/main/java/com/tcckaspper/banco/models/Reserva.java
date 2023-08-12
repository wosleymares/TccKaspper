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
	@JoinColumn(name = "cpf")
	private Cliente cliente;
	
	@Column(name= "endereco_reserva", unique = true, nullable = false, length = 80)
	private String enderecoReserva;
	
	@Column(name= "horario_reserva")
	@JsonFormat(pattern = "hh:mm")
	private String horarioReserva;
	
	@Column(name= "data_reserva")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataReserva;
	
}
