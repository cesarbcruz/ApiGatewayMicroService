package com.cesar.api.pedido.client;

import com.cesar.api.pedido.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="api-producao",url="${api-producao.url}")
public interface ProducaoClient {

    @PostMapping("/")
    public ResponseEntity registrarProducao(@RequestBody Produto produto);

}
