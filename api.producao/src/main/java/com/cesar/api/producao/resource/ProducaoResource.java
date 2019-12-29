package com.cesar.api.producao.resource;

import com.cesar.api.producao.model.Produto;
import com.cesar.api.producao.service.ProducaoService;
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
@RequestMapping(path = "/api/producao")
public class ProducaoResource {

    private static final Logger logger = LoggerFactory.getLogger(ProducaoResource.class);

    @Autowired
    ProducaoService producaoService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity registrar(@Valid @RequestBody Produto produto) {
        logger.info("Gerando ordem de produção: {}", produto);
        Long numeroOrdemProducao = producaoService.registrar(produto);
        return ResponseEntity.ok("O produto " + produto.getDescricao() + " foi enviado para a linha de produção: #" + numeroOrdemProducao);
    }

}
