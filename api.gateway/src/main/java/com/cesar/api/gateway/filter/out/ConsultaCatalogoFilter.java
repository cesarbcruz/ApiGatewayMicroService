package com.cesar.api.gateway.filter.out;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConsultaCatalogoFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(ConsultaCatalogoFilter.class);
    private final String uri = "/api/catalogo";

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
            final String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(responseData);
            ((ObjectNode)json).put("dataHora", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            ctx.setResponseBody(json.toString());
        } catch (IOException e) {
            logger.error("Erro ao manipular o retorno da consulta de catalogo", e);
        }

        return null;
    }

    @Override
    public boolean shouldFilter() {
        String path = RequestContext.getCurrentContext().getRequest().getRequestURI();
        String method = RequestContext.getCurrentContext().getRequest().getMethod();
        return uri.equals(path) && "GET".equals(method);
    }

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
