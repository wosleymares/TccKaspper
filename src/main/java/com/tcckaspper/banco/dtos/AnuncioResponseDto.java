package com.tcckaspper.banco.dtos;

import com.tcckaspper.banco.models.Anuncio;

public record AnuncioResponseDto(String image) {
	
	public AnuncioResponseDto(Anuncio anuncio) {
		this(anuncio.getImage());
	}
}