package br.com.alef.mudi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alef.mudi.model.Pedido;
import br.com.alef.mudi.model.User;
import br.com.alef.mudi.model.enums.StatusPedido;
import br.com.alef.mudi.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public Optional<Pedido> buscaPorId(Long id){
		return pedidoRepository.findById(id);
	}
	
	
	public List<Pedido> buscaTodosPedidos(){
		return pedidoRepository.findAll();
	}
	
	public void cadastraNovoPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public List<Pedido> buscarPorStatus(StatusPedido statusPedido,  Pageable sort){
		return pedidoRepository.findByStatusPedido(statusPedido,sort);
	}

	public List<Pedido> buscaTodosPedidosPorUsuario(String username) {
		return pedidoRepository.findAllByUser(username);
	}
	
	public List<Pedido> buscarPorStatusEUsuarios(StatusPedido statusPedido, String username){
		return pedidoRepository.findAllByUserAndStatus(username, statusPedido);
	}
	
	
	
	
	
}
