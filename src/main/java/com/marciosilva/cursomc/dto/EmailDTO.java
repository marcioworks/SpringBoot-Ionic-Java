package com.marciosilva.cursomc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO {

	@NotEmpty(message = "O campo Nao pode ser vazio")
	@Email(message = "Email invalido")
	private String email;
	
	public EmailDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
