package com.fiap.webservices.models.canonical;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Document
public class Usuario implements UserDetails {

    @Id
    private String cpf;
    private String email;
    private String nome;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;

    public Usuario(String cpf, String email, String nome, String password, String[] authorities) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
    }

    public Usuario() { }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
