package com.marciosilva.cursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marciosilva.cursomc.domain.ItemPedido;
import com.marciosilva.cursomc.domain.PagamentoComBoleto;
import com.marciosilva.cursomc.domain.Pedido;
import com.marciosilva.cursomc.domain.enumns.EstadoPagamento;
import com.marciosilva.cursomc.repositories.ClienteRepository;
import com.marciosilva.cursomc.repositories.ItemPedidoRepository;
import com.marciosilva.cursomc.repositories.PagamentoRepository;
import com.marciosilva.cursomc.repositories.PedidoRepository;
import com.marciosilva.cursomc.repositories.ProdutoRepository;
import com.marciosilva.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow( ()-> new ObjectNotFoundException("Objeto nao encontado! Id: "+ id 
				+", Tipo: "+ Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pgto =(PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherpagamentoComBoleto(pgto,obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for(ItemPedido ip: obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.buscar(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPrice());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		System.out.println(obj);
		return obj;
	}
}


