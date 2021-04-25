package br.com.bemolapi.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bemolapi.api.exception.NegocioExecption;
import br.com.bemolapi.domain.entity.Usuario;
import br.com.bemolapi.domain.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

		@Autowired
		private UsuarioRepository usuarioRepository;


		
		public Usuario salvar(Usuario usuario) {
			Usuario usuarioExistente = usuarioRepository.findByCpf(usuario.getCpf());
			
			if(usuarioExistente !=null && usuarioExistente.equals(usuario)) {
				throw new NegocioExecption("Ja existe um cliente cadastrado com esse cpf");
			}
				
			return usuarioRepository.save(usuario);
		}

		public Optional<Usuario> findById(Long id) {
			return usuarioRepository.findById(id);
		}

		
}
