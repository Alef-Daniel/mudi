package br.com.alef.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alef.mudi.dto.RequisicaoNovoPedido;
import br.com.alef.mudi.model.Pedido;
import br.com.alef.mudi.model.User;
import br.com.alef.mudi.service.PedidoService;
import br.com.alef.mudi.service.UserService;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicaoNovoPedido) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		
		String username= SecurityContextHolder.getContext().getAuthentication().getName();
		User user= userService.buscaTodosUsers(username);
		Pedido pedido = requisicaoNovoPedido.toPedido();
		pedido.setUser(user);
		pedidoService.cadastraNovoPedido(pedido);
		return "redirect:/home";
	}
	
	
	
	
}
