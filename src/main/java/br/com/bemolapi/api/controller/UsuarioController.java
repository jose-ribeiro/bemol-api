package br.com.bemolapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bemolapi.api.service.UsuarioService;
import br.com.bemolapi.domain.entity.Usuario;
import br.com.bemolapi.domain.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	public UsuarioRepository userRepository;
	
	@Autowired
	public UsuarioService cadastroUsuario;
	
	@GetMapping
	//fazendo a busca de todos os cliente
	public List<Usuario> listar(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{usuarioId}")
	//Retornando um cliente espesifico
	public ResponseEntity<Usuario> buscar (@PathVariable Long usuarioId) {
		Optional<Usuario> usuario = userRepository.findById(usuarioId);

		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}
		return ResponseEntity.notFound().build();
	}
	//cadastro de usuario
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar (@Valid @RequestBody Usuario usuario) {//Resquest transformar o json do corpo da quequisição em objeto cliente
		return cadastroUsuario.salvar(usuario);
	}
	
	
}
