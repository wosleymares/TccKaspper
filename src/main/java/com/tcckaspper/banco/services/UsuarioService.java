package com.tcckaspper.banco.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcckaspper.banco.models.Usuario;

@Service
public interface UsuarioService {

        //Create
        Usuario salvar (Usuario usuario);

        //Update
        Usuario atualizar(Usuario usuario);

        // List
        List<Usuario> listarUsuarios();

        Usuario listarUsuarioId(Long id);

        // Delete
        void remover (Long id);
    }