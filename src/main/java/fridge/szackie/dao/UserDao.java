package fridge.szackie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public interface UserDao extends JpaRepository<User, Integer> {

    // Metoda do wyszukiwania użytkownika po adresie e-mail
    User findByEmail(String email);

}
