package br.com.avanade.dio.apis.form;

import java.time.LocalDate;

import br.com.avanade.dio.apis.model.ClientModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientForm {
    @NotBlank
    private String name;
    private String cpf;
    
    private String email;
    
    private LocalDate birthDate;
    
    

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



	public ClientModel toModel() {
        return new ClientModel(name, cpf, email, birthDate);
    }

}
