package com.cesar.api.pagamento.resource;

import com.cesar.api.pagamento.service.PagamentoService;
import com.cesar.api.pagamento.model.Pagamento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/pagamento")
public class PagamentoResource {

    private static final Logger logger = LoggerFactory.getLogger(PagamentoResource.class);

    @Autowired
    PagamentoService pagamentoService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity registrar(@Valid @RequestBody Pagamento pagamento) {
        logger.info("Registrando Pagamento: {}", pagamento);
        Long numeroPagamento = pagamentoService.registrar(pagamento);
        return ResponseEntity.ok("O pagamento " + pagamento.getDados() + " foi aprovado: #" + numeroPagamento);
    }

}
