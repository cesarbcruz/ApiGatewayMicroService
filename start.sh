#!/bin/sh

./stop.sh

mvn -f api.gateway/pom.xml spring-boot:run &
mvn -f api.pedido/pom.xml spring-boot:run &
mvn -f api.pagamento/pom.xml spring-boot:run &
mvn -f api.producao/pom.xml spring-boot:run &
mvn -f api.catalogo/pom.xml spring-boot:run &
