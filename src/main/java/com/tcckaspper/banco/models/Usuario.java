package com.tcckaspper.banco.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "usuarios")
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "usuario")
	private List<Reserva> reservas = new ArrayList<Reserva>();
    
    @Column(name = "nome", unique = true, nullable = false, length = 60)
    @NotNull(message = "Campo 'nome' obrigatório!")
    @Size(min = 5, max = 60, message = "O 'Nome' deve conter no mínimo 5 caracteres!")
    private String nome;

    @Column(name = "email", length = 60)
    @Email(message = "Informe um email válido!")
    private String email;

    @Column(name = "senha", length = 60)
    @NotNull(message = "Campo 'senha' obrigatório!")
    private String senha;

    @Column(name = "telefone", length = 20)
    private String telefone;

}
