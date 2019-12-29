package com.cesar.api.pagamento.model;

import java.io.Serializable;

public class Pagamento implements Serializable {

    private String dados;

    public String getDados() {
        return dados;
    }

    public Pagamento setDados(String dados) {
        this.dados = dados;
        return this;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "dados='" + dados + '\'' +
                '}';
    }
}
