package br.com.avanade.dio.apis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FieldErrorDTO {
    
    private String field;
    private String message;
    
    public FieldErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}   
    
    
}
