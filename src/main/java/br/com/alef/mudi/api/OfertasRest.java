package br.com.alef.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alef.mudi.dto.RequisicaoNovaOferta;
import br.com.alef.mudi.model.Oferta;
import br.com.alef.mudi.model.Pedido;

import br.com.alef.mudi.service.PedidoService;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		
		Optional<Pedido> pedidoBuscado = pedidoService.buscaPorId(requisicao.getPedidoId());
		
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		
		Oferta nova = requisicao.toOferta();
		nova.setPedido(pedido);
		pedido.getOfertas().add(nova);
		pedidoService.cadastraNovoPedido(pedido);
		
		return nova;
	}
}
