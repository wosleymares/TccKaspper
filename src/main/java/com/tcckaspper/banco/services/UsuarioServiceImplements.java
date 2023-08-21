package com.tcckaspper.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcckaspper.banco.models.Usuario;
import com.tcckaspper.banco.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;


@Service
public class UsuarioServiceImplements implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    // Save
    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    // Update
    @Override
    @Transactional
    public Usuario atualizar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    // List all
    @Override
    @Transactional
    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.findAll();
    }


    // List by id
    @Override
    public Usuario listarUsuarioId(Long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        return usuario.orElseThrow();
    }

    // Delete
    @Override
    public void remover(Long id) {
        this.usuarioRepository.deleteById(id);

    }

}
