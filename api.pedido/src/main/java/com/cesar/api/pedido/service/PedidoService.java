package com.cesar.api.pedido.service;

import com.cesar.api.pedido.client.ProducaoClient;
import com.cesar.api.pedido.client.PagamentoClient;
import com.cesar.api.pedido.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PedidoService {

    @Autowired
    PagamentoClient pagamentoClient;
    @Autowired
    ProducaoClient producaoClient;

    public Long registrar(Pedido pedido) {

        pagamentoClient.registrarPagamento(pedido.getPagamento());
        producaoClient.registrarProducao(pedido.getProduto());

        return Math.abs(new Random().nextLong());
    }
}
