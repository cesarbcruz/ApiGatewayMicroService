package com.cesar.api.producao.service;

import com.cesar.api.producao.model.Produto;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProducaoService {

    public Long registrar(Produto produto) {

        return Math.abs(new Random().nextLong());
    }
}
