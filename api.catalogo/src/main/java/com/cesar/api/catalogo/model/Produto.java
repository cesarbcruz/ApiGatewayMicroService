package com.cesar.api.catalogo.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private String descricao;
    private Double valor;

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

     public Double getValor() {
        return valor;
    }

    public Produto setValor(Double valor) {
        this.valor = valor;
        return this;
    }
}
