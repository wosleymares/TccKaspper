package com.tcckaspper.banco.enums;

public enum Reserva {
	
	ENDERECO("Endereco"),
	HORARIO("Horario"),
	DATA("Data");
	
	private String reserva;
	
	private Reserva(String reserva) {
		this.reserva = reserva;
	}

	public String getReserva() {
		return reserva;
	}

	public void setReserva(String reserva) {
		this.reserva = reserva;
	}
	
	

}
