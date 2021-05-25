package com.ricardomaricato.ecommerceproject.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@IdClass(ItemPedido.class)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ItemPedidoId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @EqualsAndHashCode.Include
    @Column(name = "produto_id")
    private Integer produtoId;
}
