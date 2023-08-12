package com.tcckaspper.banco.models;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name= "clientes")
@Table(name="clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Cliente {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", unique = true, nullable = false, length = 60)
	@NotNull(message = "Campo 'nome' obrigatório! ")
	@Size(min = 5, max = 60, message = "O campo 'nome' deve conter min 5 letras!" )
	private String nome;
	
	@Column(name= "endereco", unique = true, nullable = false, length = 100)
	@NotNull(message = "Campo 'endereço' obrigatório! ")
	private String endereco;
	
	@Column(name= "email", length = 60)
	@Email(message = "Informe um email válido! ")
	private String email;
	
	@Column(name= "telefone", unique = true, nullable = false, length = 20)
	@NotNull(message= "Campo 'telefone' obrigatório! ")
	private String telefone;
	
	@Column(name= "data_nascimento")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@Column(name= "cpf", unique = true, nullable = false, length = 20)
	@NotNull(message = "Campo 'cpf' obrigatório! ")
	private String cpf;
	
	@Column(name= "login", unique = true, nullable = false, length = 20)
	@NotNull(message = "Campo 'login' obrigatório! ")
	private String login;
	
	@Column(name= "senha", unique = true, nullable = false, length = 20)
	@NotNull(message = "O campo 'senha' deve conter letras e números! ")
	private String senha;
	
	/*@Column(name= "confirmaSenha", unique = true, nullable = false, length = 20)
	@NotNull(message = "Para confirmar, as senhas devem ser iguais! ")
	private String confirmaSenha;*/
	

}
