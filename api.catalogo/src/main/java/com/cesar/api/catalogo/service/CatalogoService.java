package com.cesar.api.catalogo.service;

import com.cesar.api.catalogo.model.Catalogo;
import com.cesar.api.catalogo.model.Produto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CatalogoService {

    public Catalogo obter() {

        return new Catalogo().setProdutos(
                Arrays.asList(
                        new Produto().setDescricao("Caneca Personalizada").setValor(15.0),
                        new Produto().setDescricao("Suporte de Celular").setValor(20.0),
                        new Produto().setDescricao("Porta retrato").setValor(10.0),
                        new Produto().setDescricao("Chaveiro").setValor(5.0)
                )
        );
    }
}
