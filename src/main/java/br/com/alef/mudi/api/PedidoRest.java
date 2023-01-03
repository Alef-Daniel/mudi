package br.com.alef.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alef.mudi.model.Pedido;
import br.com.alef.mudi.model.enums.StatusPedido;
import br.com.alef.mudi.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRest {
	
	@Autowired
	PedidoService pedidoService;
	
	
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas(){
		Sort sort = Sort.by("id").descending();
		PageRequest pageRequest = PageRequest.of(0, 10,sort);
		return pedidoService.buscarPorStatus(StatusPedido.AGUARDANDO, pageRequest);
		
	}

}
