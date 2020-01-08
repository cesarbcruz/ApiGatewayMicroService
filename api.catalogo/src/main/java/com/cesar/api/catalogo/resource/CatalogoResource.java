package com.cesar.api.catalogo.resource;

import com.cesar.api.catalogo.model.Catalogo;
import com.cesar.api.catalogo.model.Produto;
import com.cesar.api.catalogo.service.CatalogoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/catalogo")
public class CatalogoResource {

    private static final Logger logger = LoggerFactory.getLogger(CatalogoResource.class);

    @Autowired
    CatalogoService catalogoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Catalogo> obter() {
        logger.info("Obtendo Catalogo:");
        Catalogo catalogo = catalogoService.obter();
        return ResponseEntity.ok(catalogo);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> download() throws Exception {
        logger.info("Download Catalogo");
        File file = catalogoService.criarArquivoCatalogo();
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getName());
        headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION);
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new FileInputStream(file)));

    }

    @RequestMapping(value = "/download/produto", method = RequestMethod.POST)
    public ResponseEntity<InputStreamResource> download(@RequestBody Produto produto) throws Exception {
        logger.info("Download Catalogo Produto: {}", produto.getDescricao());
        File file = catalogoService.criarArquivoCatalogoProduto(produto);
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getName());
        headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION);
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new FileInputStream(file)));

    }
}
