package com.cesar.api.catalogo.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
}
