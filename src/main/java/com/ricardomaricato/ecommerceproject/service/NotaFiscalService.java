package com.ricardomaricato.ecommerceproject.service;

import com.ricardomaricato.ecommerceproject.model.Pedido;

public class NotaFiscalService {

    public void gerar(Pedido pedido) {
        System.out.println("Gerando nota para o pedido " + pedido.getId() + ".");
    }
}
