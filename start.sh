#!/bin/sh
process=`ps -ef | grep -v awk | awk -e '/api.*/ { print $2 }'`
kill ${process}

mvn -f api.gateway/pom.xml spring-boot:run &
mvn -f api.pedido/pom.xml spring-boot:run &
mvn -f api.pagamento/pom.xml spring-boot:run &
mvn -f api.producao/pom.xml spring-boot:run &
mvn -f api.catalogo/pom.xml spring-boot:run &
