package br.com.alef.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alef.mudi.model.Pedido;
import br.com.alef.mudi.model.enums.StatusPedido;

public class RequisicaoNovoPedido {
	
	@NotBlank
	private String nomeProduto;
	@NotBlank
	private String urlImagem;
	@NotBlank
	private String urlProduto;
	
	private String descricao;
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlPedido) {
		this.urlProduto = urlPedido;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNome(nomeProduto);
		pedido.setDescricao(descricao);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		pedido.setStatusPedido(StatusPedido.AGUARDANDO);
		return pedido;
		
	}
	
	

}
