package br.com.avanade.dio.apis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.avanade.dio.apis.dto.ClientDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Entity
@Table(name = "clients")
@NoArgsConstructor
public class ClientModel implements UserDetails {

    private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate birthDate;

    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClientModel(
        String name,
        String cpf,
        String email,
        LocalDate birthDate

    ) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;

        var lt = LocalDateTime.now();
        createdAt = lt;
        updatedAt = lt;
    }

    public ClientModel(String email, String password) {
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public ClientDTO toDto() {
        return new ClientDTO(id, name, cpf, email, birthDate);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}