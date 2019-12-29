package com.cesar.api.pagamento.service;

import com.cesar.api.pagamento.model.Pagamento;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PagamentoService {

    public Long registrar(Pagamento pagamento) {

        return Math.abs(new Random().nextLong());
    }
}
