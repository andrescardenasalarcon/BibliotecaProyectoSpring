package com.edu.usta.bibliotecaproyecto.service.UserService;

import com.edu.usta.bibliotecaproyecto.entity.Usuario;
import com.edu.usta.bibliotecaproyecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(@RequestBody String username) throws UsernameNotFoundException {
        Usuario us = usuarioRepository.findByUsername(username);
        String user = us.getUsername();
        String pass = us.getPassword();

        return new User(user,pass, new ArrayList<>());
    }
}
