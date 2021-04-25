package br.com.bemolapi.api.service;

import br.com.bemolapi.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bemolapi.domain.entity.Endereco;
import br.com.bemolapi.domain.repository.EnderecosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
	@Autowired
	private EnderecosRepository enderecoRepository;
	@Autowired
	private UsuarioService usuarioService;
	
	public Endereco salvar(Endereco endereco, Long idUsuario) throws Exception {
		Optional<Usuario> usuario = usuarioService.findById(idUsuario);

		if (usuario.isEmpty()) {
			throw new Exception("usuario não existe");
		}

		Usuario usuarioEncontrado = usuario.get();

		endereco.setUsuario(usuarioEncontrado);

		return enderecoRepository.save(endereco);
	}

	public List<Endereco> findGetAll() {
		return enderecoRepository.findAll();
	}


}
