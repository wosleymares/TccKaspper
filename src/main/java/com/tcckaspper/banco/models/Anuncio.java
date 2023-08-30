package com.tcckaspper.banco.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "anuncios")
@Table(name = "anuncios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Anuncio {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@Column(name = "titulo", unique = true, nullable = false, length = 60)
	@NotNull(message = "Campo 'titulo' obrigatório! ")
	@Size(min = 10, max = 60, message = "O campo 'titulo' deve conter min 10 letras!")
	public String titulo;

	@Column(name = "descricao", unique = true, nullable = false, length = 500)
	@NotNull(message = "Campo 'descrição' obrigatório")
	@Size(min = 10, max = 500, message = "O campo 'descrição' minimo de 50 caractere!")
	public String descricao;

	@Column(name = "valor", unique = true, nullable = false, length = 15)
	@NotNull(message = "Campo 'valor' obrigatório! ")
	public Integer valor;

	@Column(name = "contato", unique = true, nullable = false, length = 20)
	@NotNull(message = "Campo 'contato' obrigatório! ")
	public String contato;

}
