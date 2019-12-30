package com.cesar.api.catalogo.resource;

import com.cesar.api.catalogo.model.Catalogo;
import com.cesar.api.catalogo.service.CatalogoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/catalogo")
public class CatalogoResource {

    private static final Logger logger = LoggerFactory.getLogger(CatalogoResource.class);

    @Autowired
    CatalogoService catalogoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Catalogo> obter() {
        logger.info("Obtendo Catalogo:");
        Catalogo catalogo = catalogoService.obter();
        return ResponseEntity.ok(catalogo);
    }

}
