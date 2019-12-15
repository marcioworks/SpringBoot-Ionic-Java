package com.marciosilva.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.marciosilva.cursomc.domain.Pedido;

public interface EmailService {

	
	void senderOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
