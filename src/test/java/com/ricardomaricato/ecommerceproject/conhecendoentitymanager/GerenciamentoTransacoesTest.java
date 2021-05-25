package com.ricardomaricato.ecommerceproject.conhecendoentitymanager;

import com.ricardomaricato.ecommerceproject.EcommerceProjectApplicationTests;
import com.ricardomaricato.ecommerceproject.model.Pedido;
import com.ricardomaricato.ecommerceproject.model.StatusPedido;
import org.junit.Test;

public class GerenciamentoTransacoesTest extends EcommerceProjectApplicationTests {

    @Test(expected = Exception.class)
    public void abrirFecharCancelarTransacao() {
        try {
            entityManager.getTransaction().begin();
            metodoDeNegocio();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    private void metodoDeNegocio() {
        Pedido pedido = entityManager.find(Pedido.class, 1);
        pedido.setStatus(StatusPedido.PAGO);

        if (pedido.getPagamento() == null) {
            throw new RuntimeException("Pedido ainda não foi pago.");
        }
    }
}
