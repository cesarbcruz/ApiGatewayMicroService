package com.cesar.api.catalogo.service;

import com.cesar.api.catalogo.model.Catalogo;
import com.cesar.api.catalogo.model.Produto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Arrays;

@Service
public class CatalogoService {

    public Catalogo obter() {

        return new Catalogo().setProdutos(
                Arrays.asList(
                        new Produto().setDescricao("Caneca Personalizada").setValor(15.0),
                        new Produto().setDescricao("Suporte de Celular").setValor(20.0),
                        new Produto().setDescricao("Porta retrato").setValor(10.0),
                        new Produto().setDescricao("Chaveiro").setValor(5.0)
                )
        );
    }

    public File criarArquivoCatalogo() throws Exception {
        String fileName = "catalogo_produtos.txt";
        String dir = "/tmp/";
        PrintWriter writer = new PrintWriter(dir + fileName, "UTF-8");
        writer.println("Catalogo de Produtos");
        for (Produto produto: obter().getProdutos()) {
            writer.println(produto.getDescricao()+" = "+produto.getValor());
        }
        writer.close();
       return new File(dir+fileName);
    }


    public File criarArquivoCatalogoProduto(Produto produto) throws Exception {
        String fileName = "catalogo_produto_"+produto.getDescricao()+".txt";
        String dir = "/tmp/";
        PrintWriter writer = new PrintWriter(dir + fileName, "UTF-8");
        writer.println("Catalogo do Produto:");
        writer.println(produto.getDescricao()+" = "+produto.getValor());
        writer.close();
        return new File(dir+fileName);
    }
}
