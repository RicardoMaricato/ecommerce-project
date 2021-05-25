package com.ricardomaricato.ecommerceproject.conhecendoentitymanager;

import com.ricardomaricato.ecommerceproject.EcommerceProjectApplicationTests;
import com.ricardomaricato.ecommerceproject.model.Cliente;
import com.ricardomaricato.ecommerceproject.model.Pedido;
import com.ricardomaricato.ecommerceproject.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

public class CallbacksTest extends EcommerceProjectApplicationTests {

    @Test
    public void acionarCallbacks() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.AGUARDANDO);

        entityManager.getTransaction().begin();

        entityManager.persist(pedido);
        entityManager.flush();

        pedido.setStatus(StatusPedido.PAGO);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getDataCriacao());
        Assert.assertNotNull(pedidoVerificacao.getDataUltimaAtualizacao());
    }
}
