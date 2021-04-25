package br.com.bemolapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bemolapi.domain.entity.Usuario;

public interface ListaEnderecosRepository extends JpaRepository<Usuario, Long>{

}
