package br.com.bemolapi.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bemolapi.domain.entity.Endereco;

@Repository
public interface EnderecosRepository extends JpaRepository<Endereco, Long> {
	
	//List<Endereco> findByEnderecos(String nome);

}
