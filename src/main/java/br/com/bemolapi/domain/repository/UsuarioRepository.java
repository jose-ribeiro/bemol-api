package br.com.bemolapi.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bemolapi.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findByNome(String nome);
	Usuario findByCpf(String cpf);
	Optional<Usuario> findById(Long id);
	List<Usuario> findByNomeContaining(String nome);
	Usuario findByEmail(String email);

}
