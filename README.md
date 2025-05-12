# Conversor de Moedas em Java

Este é um projeto simples de conversor de moedas feito em Java. Ele utiliza uma API externa para buscar a cotação atual e converter valores entre diferentes moedas. O sistema roda no terminal e foi feito com foco em praticar conceitos de orientação a objetos, consumo de APIs e uso de bibliotecas externas com Maven.

## Funcionalidades

- Conversão entre moedas com base na cotação atual
- Interface simples via terminal
- Registro de cada conversão realizada em um arquivo de log (`logs.txt`)
- Validação de códigos de moedas (como USD, BRL, EUR, etc.)
- Tratamento básico de erros (como moedas inválidas ou problemas na API)

## Tecnologias utilizadas

- Java 17
- API Exchangerate.host
- Gson (para leitura de JSON)
- Maven
- IntelliJ IDEA

## Como executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
