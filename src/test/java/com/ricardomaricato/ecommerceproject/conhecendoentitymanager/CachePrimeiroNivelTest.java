package com.ricardomaricato.ecommerceproject.conhecendoentitymanager;

import com.ricardomaricato.ecommerceproject.EcommerceProjectApplicationTests;
import com.ricardomaricato.ecommerceproject.model.Produto;
import org.junit.jupiter.api.Test;

public class CachePrimeiroNivelTest extends EcommerceProjectApplicationTests {

    @Test
    public void verificarCache() {
        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println(produto.getNome());

        System.out.println("------------------------------");

//        entityManager.close();
//        entityManager = entityManagerFactory.createEntityManager();

        Produto produtoResgatado = entityManager.find(Produto.class, produto.getId());
        System.out.println(produtoResgatado.getNome());
    }
}
