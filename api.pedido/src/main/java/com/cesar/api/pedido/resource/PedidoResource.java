package com.cesar.api.pedido.resource;

import com.cesar.api.pedido.model.Pedido;
import com.cesar.api.pedido.service.PedidoService;
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
@RequestMapping(path = "/api/pedido")
public class PedidoResource {

    private static final Logger logger = LoggerFactory.getLogger(PedidoResource.class);

    @Autowired
    PedidoService pedidoService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity registrar(@Valid @RequestBody Pedido pedido) {
        logger.info("Registrando Pedido: {}", pedido);
        Long numeroPedido = pedidoService.registrar(pedido);
        return ResponseEntity.ok(pedido.getCliente()+ " seu pedido foi registrado com sucesso: #" + numeroPedido);
    }

}
