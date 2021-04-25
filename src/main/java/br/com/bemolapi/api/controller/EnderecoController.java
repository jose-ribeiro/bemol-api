package br.com.bemolapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.bemolapi.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.bemolapi.api.service.EnderecoService;
import br.com.bemolapi.api.service.UsuarioService;
import br.com.bemolapi.domain.entity.Endereco;
import br.com.bemolapi.domain.repository.EnderecosRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public List<Endereco> listar(){
		return enderecoService.findGetAll();
	}

	@PostMapping("/usuarioId/{idUsuario}")
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco adicionar(@PathVariable Long idUsuario, @Valid @RequestBody Endereco endereco) throws Exception {
		return enderecoService.salvar(endereco, idUsuario);
//		if(usuario existe) {
//			return cadastroEndereco.salvar(endereco);			
//		} else {
//			throw new Exception("problemas ao encontrar usuário");
//		}

		
	}
	
	
	


}




