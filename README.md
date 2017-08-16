# Prova de programação Java  - Reserva Fácil 

|Técnologias Utilizadas|
|----------------------|
|JAVA 1.8|
|Maven|
|Spring-Boot v 1.5.6|

> ## Requisitos

> - Não é necessário produzir uma aplicação completamente funcional, apenas uma implementação do problema proposto.<br />
> - Não se preocupe com interfaces gráficas nem com persistência em banco de dados. <br />
> - O código deve ser produzido em Java.<br />
> - O código deve ser submetido preferencialmente utilizando uma ferramenta de build e gestor de dependências, ou as dependências devem > estar acompanhando o projeto.<br />
> - A implementação deve atender aos casos de testes providos. <br />
> - Criação de testes unitários para validar os requisitos do problema <br />
> - A solução não pode conter arquivos de IDE. 

## Decisões arquiteturais

Optei por uma API REST, utilizando o Spring-boot onde fui capaz de desenvolver o projeto com uma maior velocidade e já possuir embedded tomcat servlet container.

## Utilização da api

Para iniciar o micro-serviço utilizar o maven no módulo “testdev-api” com o comando “mvn spring-boot:run” onde será iniciado o servidor na porta 8080

### Exemplo de requests

#### Agendando uma transferência bancária

http://localhost:8080/scheduleFinancialTransfer

```sh
POST HTTP BODY

{
	"origenAcc" : "Bill Gates",
	"destAcc" : "Felipe",
	"transfValue" : 50000,
	"scheduleDate" : "30/08/2017",
	"typeTransf" : "D"
}
```



#### Listando transferencias agendadas

http://localhost:8080/listTransfers

```sh
Response

[
    {
        "origenAcc": "Bill Gates",
        "destAcc": "Felipe",
        "transfValue": 50000,
        "tax": 8,
        "scheduleDate": 1504062000000,
        "typeTransf": "D"
    }
]
```
