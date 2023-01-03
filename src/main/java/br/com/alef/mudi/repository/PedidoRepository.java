package br.com.alef.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alef.mudi.model.Pedido;
import br.com.alef.mudi.model.enums.StatusPedido;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>{
	
	@Cacheable("status")
	List<Pedido>findByStatusPedido(StatusPedido statusPedido, Pageable sort);
	
	
	@Query("select p from Pedido p join p.user where p.user.username = :username")
	List<Pedido>findAllByUser(@Param("username") String  username);
	
	@Query("select p from Pedido p join p.user where p.user.username = :username and p.statusPedido = :status")
	List<Pedido>findAllByUserAndStatus(@Param("username") String  username,@Param("status")StatusPedido statusPedido);

}
