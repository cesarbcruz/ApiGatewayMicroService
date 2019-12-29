package com.cesar.api.pedido.model;

public class Produto {

    private String descricao;
    private Integer quantidade;

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Produto setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "\n descricao='" + descricao + '\''+
                "\n quantidade=" + quantidade +
                "\n }";
    }
}
