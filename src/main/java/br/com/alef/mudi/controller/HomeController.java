package br.com.alef.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alef.mudi.model.Pedido;
import br.com.alef.mudi.model.enums.StatusPedido;
import br.com.alef.mudi.service.PedidoService;

@Controller
@RequestMapping("/home")
public class HomeController {

	
	@Autowired
	private PedidoService pedidoService;
	
	
	
	@GetMapping
	public String home(Model model, Principal principal) {
		Sort sort = Sort.by("dataEntrega").descending();
		PageRequest pageRequest = PageRequest.of(0, 10,sort);
		List<Pedido> pedidos = pedidoService.buscarPorStatus(StatusPedido.ENTREGUE,pageRequest);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}

	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
	
}
