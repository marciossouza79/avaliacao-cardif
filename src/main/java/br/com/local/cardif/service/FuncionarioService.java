package br.com.local.cardif.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.local.cardif.entity.Funcionario;
import br.com.local.cardif.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> findAll(){
		return funcionarioRepository.findAll();
	}
	
	public List<Funcionario> findFuncionarios(Integer departamentoId){
		return funcionarioRepository.findByDepartamentos(departamentoId);
	}
	
	
	public void atualizarFuncionario(@Valid Funcionario funcionario) {
		Funcionario newFuncionario = find(funcionario.getId());
		updateData(newFuncionario,funcionario);
		funcionarioRepository.save(funcionario);
	}
	
	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = funcionarioRepository.findById(id.intValue());
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName(), null));
	}
	
	public Funcionario cadastrarFuncionarioRest(@Valid Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario atualizarFuncionarioRest(@Valid Funcionario funcionario) {
		Funcionario newFuncionario = find(funcionario.getId());
		updateData(newFuncionario,funcionario);
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario updateData(Funcionario newFuncionario, Funcionario funcionario) {
		newFuncionario.setName(funcionario.getName());
		newFuncionario.setAge(funcionario.getAge());
		newFuncionario.setBirthDay(funcionario.getBirthDay());
		newFuncionario.setDocument(funcionario.getDocument());
		newFuncionario.setDepartamentos(funcionario.getDepartamentos());
		return newFuncionario;
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			funcionarioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir o funcionario");
		}
	}
}
