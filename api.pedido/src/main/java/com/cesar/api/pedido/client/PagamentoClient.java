package com.cesar.api.pedido.client;

import com.cesar.api.pedido.model.Pagamento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="api-pagamento",url="${api-pagamento.url}")
public interface PagamentoClient {

    @PostMapping("/")
    public ResponseEntity registrarPagamento(@RequestBody Pagamento pagamento);

}
