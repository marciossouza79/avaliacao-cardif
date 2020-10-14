package br.com.local.cardif.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cargo_id")
	private Integer id;

	@NotBlank(message = "Nome é obrigatório")
	@Column(name = "cargo_name")
	private String name;
	
	@Column(name = "cargo_leader", columnDefinition = "boolean default false")
	private Boolean leader;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getLeader() {
		return leader;
	}

	public void setLeader(Boolean leader) {
		this.leader = leader;
	}
	
	
	
	
}
