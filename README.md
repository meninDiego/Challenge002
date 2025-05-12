# Conversor de Moedas em Java

Este é um projeto simples de conversor de moedas feito em Java. Ele utiliza uma API externa para buscar a cotação atual e converter valores entre diferentes moedas. O sistema roda no terminal e foi feito com foco em praticar conceitos de orientação a objetos, consumo de APIs e uso de bibliotecas externas com Maven.

## Funcionalidades

- Conversão entre moedas com base na cotação atual
- Interface simples via terminal
- Registro de cada conversão realizada em um arquivo de log (`logs.txt`)
- Validação de códigos de moedas (como USD, BRL, EUR, etc.)
- Tratamento básico de erros (como moedas inválidas ou problemas na API)

## Tecnologias utilizadas

- Java 21
- API Exchangerate.host
- Gson (para leitura de JSON)
- Maven
- IntelliJ IDEA

## Como executar

## 1. Clone o repositório:


git clone https://github.com/seu-usuario/seu-repositorio.git

## 2. Compile o projeto com Maven:


mvn compile

## 3. Execute o programa:


mvn exec:java -Dexec.mainClass="main.ConversorMonetario"

## 4. Estrutura do projeto
main/ConversorMonetario.java – Classe principal do programa

services/ApiService.java – Responsável por fazer chamadas à API

services/ConversaoLogger.java – Registra as conversões em um arquivo de log

models/Moeda.java – Representa os dados da moeda convertida

utils/ValidadorMoeda.java – Faz a validação dos códigos de moeda

logs.txt – Arquivo gerado automaticamente com o histórico das conversões

## 5. Exemplo de uso no terminal

Digite o valor que deseja converter: 100
Digite a moeda de origem (ex: USD): USD
Digite a moeda de destino (ex: BRL): BRL
Resultado da conversão: 100.0 USD = 505.23 BRL

## 6.E o log salvo será algo como:

[2025-05-12 14:23:45] Conversão realizada: 100.0 USD = 505.23 BRL

## 7. Objetivo do projeto
Este projeto foi desenvolvido como parte dos meus estudos em Java, com o objetivo de praticar:

Consumo de APIs REST em Java puro

Manipulação de JSON com Gson

Estruturação de código com orientação a objetos

Uso do Maven para gerenciamento de dependências

Escrita de logs com java.time

Autor
Feito por Diego Menin como parte da formação Java Back-End da ONE 
