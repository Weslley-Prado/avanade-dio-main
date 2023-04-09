package br.com.avanade.dio.apis.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.avanade.dio.apis.controller.ClientController;
import lombok.AllArgsConstructor;
import lombok.Getter;

// Dto is class output, all datas that will be showed

@Getter
@AllArgsConstructor
@Relation( collectionRelation= "client")
public class ClientDTO extends RepresentationModel<ClientDTO>{

	private Integer id;
	private String name;
	private String cpf;
	private String email;
	private LocalDate birthDate;

	public ClientDTO(Integer id, String name, String cpf, String email, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.birthDate = birthDate;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public ClientDTO buildLink() {
		return	this.add(
						WebMvcLinkBuilder.linkTo(
								WebMvcLinkBuilder.methodOn(ClientController.class).getClient(id)
								).withSelfRel());

	}


}
