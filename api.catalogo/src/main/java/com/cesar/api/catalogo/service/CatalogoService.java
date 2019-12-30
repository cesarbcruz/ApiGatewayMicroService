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
                        new Produto().setDescricao("Caneca Personalizada"),
                        new Produto().setDescricao("Suporte de Celular"),
                        new Produto().setDescricao("Porta retrato"),
                        new Produto().setDescricao("Chaveiro")
                )
        );
    }
}
