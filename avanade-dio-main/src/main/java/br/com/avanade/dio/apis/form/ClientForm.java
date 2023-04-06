package br.com.avanade.dio.apis.form;

import java.time.LocalDate;

import br.com.avanade.dio.apis.model.ClientModel;
import jakarta.validation.constraints.Email;
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

    public ClientModel toModel() {
        return new ClientModel(name, cpf, email, birthDate);
    }

}
