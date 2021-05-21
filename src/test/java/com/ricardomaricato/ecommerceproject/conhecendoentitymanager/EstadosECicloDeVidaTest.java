package com.ricardomaricato.ecommerceproject.conhecendoentitymanager;

import com.ricardomaricato.ecommerceproject.EcommerceProjectApplicationTests;
import com.ricardomaricato.ecommerceproject.model.Categoria;
import org.junit.jupiter.api.Test;

public class EstadosECicloDeVidaTest extends EcommerceProjectApplicationTests {

    @Test
    public void analisarEstados() {
        Categoria categoriaNovo = new Categoria();

        Categoria categoriaGerenciadaMerge = entityManager.merge(categoriaNovo);

        Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1);

        entityManager.remove(categoriaGerenciada);
        entityManager.persist(categoriaGerenciada);

        entityManager.detach(categoriaGerenciada);
    }

}
