package br.com.local.cardif.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.local.cardif.entity.Funcionario;
import br.com.local.cardif.service.FuncionarioService;


@RestController
@RequestMapping(value="/api/funcionarios")
public class FuncionarioRestController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping(value = "/lista" ,method = RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> findAll() {
		List<Funcionario> list = funcionarioService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Funcionario funcionario){
		funcionario = funcionarioService.cadastrarFuncionarioRest(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId()).toUri();			
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid  @RequestBody Funcionario funcionario, @PathVariable Integer id){
		funcionarioService.atualizarFuncionario(funcionario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		funcionarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{departamentoId}/lista", method=RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> findFuncionarios(@PathVariable Integer departamentoId) {
	 List<Funcionario> funcionarios = funcionarioService.findFuncionarios(departamentoId);
		return ResponseEntity.ok().body(funcionarios);
	}
}
