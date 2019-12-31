package com.cesar.api.catalogo.resource;

import com.cesar.api.catalogo.model.Catalogo;
import com.cesar.api.catalogo.model.Produto;
import com.cesar.api.catalogo.service.CatalogoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


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

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> download(HttpServletResponse response) throws Exception {
        logger.info("Download Catalogo:");

        String file = "catalogo.txt";
        String dir = "/tmp/";

        PrintWriter writer = new PrintWriter(dir + file, "UTF-8");
        writer.println("Catalogo de Produtos");
        for (Produto produto: catalogoService.obter().getProdutos()) {
            writer.println(produto.getDescricao()+" = "+produto.getValor());
        }
        writer.close();

        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment; filename="+file);
        return ResponseEntity.ok(new InputStreamResource(new FileInputStream(dir+file)));

    }

}
