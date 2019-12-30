package com.cesar.api.catalogo.model;

import java.io.Serializable;
import java.util.List;

public class Catalogo implements Serializable {

    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Catalogo setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }
}
