package br.com.local.cardif.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.local.cardif.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

	@Query(value = "SELECT DISTINCT F.*, FD.* FROM FUNCIONARIO AS F INNER JOIN FUNCIONARIO_DEPARTAMENTO AS FD INNER JOIN DEPARTAMENTO AS D ON F.FUNCIONARIO_ID = FD.FUNCIONARIO_ID WHERE FD.DEPARTAMENTO_ID = ?", nativeQuery = true) 
	public List<Funcionario> findByDepartamentos(Integer departamentos);
	
}
