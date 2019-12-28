package com.marciosilva.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marciosilva.cursomc.domain.Categoria;
import com.marciosilva.cursomc.domain.Cidade;
import com.marciosilva.cursomc.domain.Cliente;
import com.marciosilva.cursomc.domain.Endereco;
import com.marciosilva.cursomc.domain.Estado;
import com.marciosilva.cursomc.domain.ItemPedido;
import com.marciosilva.cursomc.domain.Pagamento;
import com.marciosilva.cursomc.domain.PagamentoComBoleto;
import com.marciosilva.cursomc.domain.PagamentoComCartao;
import com.marciosilva.cursomc.domain.Pedido;
import com.marciosilva.cursomc.domain.Produto;
import com.marciosilva.cursomc.domain.enumns.EstadoPagamento;
import com.marciosilva.cursomc.domain.enumns.TipoCliente;
import com.marciosilva.cursomc.repositories.CategoriaRepository;
import com.marciosilva.cursomc.repositories.CidadeRepository;
import com.marciosilva.cursomc.repositories.ClienteRepository;
import com.marciosilva.cursomc.repositories.EnderecoRepository;
import com.marciosilva.cursomc.repositories.EstadoRepository;
import com.marciosilva.cursomc.repositories.ItemPedidoRepository;
import com.marciosilva.cursomc.repositories.PagamentoRepository;
import com.marciosilva.cursomc.repositories.PedidoRepository;
import com.marciosilva.cursomc.repositories.ProdutoRepository;
import com.marciosilva.cursomc.services.S3Service;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private S3Service service;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.uploadFile("C:\\temp\\Marcio.jpg");
	}

}
