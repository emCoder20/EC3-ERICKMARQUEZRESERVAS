package com.idat.EC3ERICKMARQUEZRESERVAS.Security;

import java.util.ArrayList;
import java.util.List;
import com.idat.EC3ERICKMARQUEZRESERVAS.Model.UsuarioClientes;
import com.idat.EC3ERICKMARQUEZRESERVAS.Repository.UsuariosClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService{

    @Autowired
    private UsuariosClientesRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioClientes usuario = repository.findByUsuario(username);

        if(usuario != null){

            List<GrantedAuthority> listGranted = new ArrayList<>();
            GrantedAuthority granted = new SimpleGrantedAuthority(usuario.getRol());

            listGranted.add(granted);


            return new User(usuario.getUsuario(),new BCryptPasswordEncoder().encode(usuario.getPassword()) , listGranted);

        }else
            throw new UsernameNotFoundException("Usuario no existe " + username);
    }

}
