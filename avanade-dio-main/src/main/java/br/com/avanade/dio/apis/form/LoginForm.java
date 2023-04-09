package br.com.avanade.dio.apis.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginForm {
    private String email, password;

	public LoginForm(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginForm() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
    
}