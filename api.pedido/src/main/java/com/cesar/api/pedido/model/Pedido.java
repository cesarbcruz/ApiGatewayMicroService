package com.cesar.api.pedido.model;

import java.io.Serializable;

public class Pedido implements Serializable {

    private String cliente;
    private Produto produto;
    private Pagamento pagamento;
    private String entrega;

    public String getCliente() {
        return cliente;
    }

    public Pedido setCliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pedido setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Pedido setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
        return this;
    }

    public String getEntrega() {
        return entrega;
    }

    public Pedido setEntrega(String entrega) {
        this.entrega = entrega;
        return this;
    }

    @Override
    public String toString() {
        return "\nPedido {" +
                "\n cliente='" + cliente + '\'' +
                "\n produto='" + produto + '\'' +
                "\n pagamento='" + pagamento + '\'' +
                "\n entrega='" + entrega + '\'' +
                "\n}";
    }
}
