## Rinha de backend 2024 Q1

Este repositório apresenta uma solução para o problema proposto pela Rinha de backend 2024 Q1. 
O problema consiste na criação de uma API para criar transações e recuperar extratos de um determinado cliente. 
Além desses objetivos, a API deve ser preocupar em ter alta disponibilidade.

Para a solução foi construída uma API com Java Spring Boot e para atender o critério de alta disponibilidade, 
foi utilizado um balanceador de carga por meio da ferramenta NGINX que redireciona as requisições para duas replicas da API.

Mais informações sobre o problema em: https://github.com/zanfranceschi/rinha-de-backend-2024-q1

## Como rodar a aplicação?

> docker compose up --build

## Rotas

> GET /clientes/{id}/extrato
> POST /clientes/{id}/transacoes

## Documentação Swagger

http://localhost:9999/swagger-ui/index.html#/statement-routes/getStatement
