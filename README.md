# estoque
Serviço responsável por verificar se existe um produto disponível em estoque com base na quantidade solicitada e também por aplicar a reserva temporária dele até que o pagamento seja confirmado ou cancelado. A interação com o serviço se dá através de uma **api-rest** e via **mensageria via evento** (_implementação futura_) 


_**obs**:por fazer parte de um estudo de arquitetura de microserviços este projeto é bem simples. Ele também compoem um sistema ainda mais simples de e-commerce._

<br>

# api

## Produtos

| METODO | ENDPOINT | AÇÃO |
| --- | --- | --- |
| `GET` |`/produtos` | lista todos os produtos |
| `POST` |`/produtos` | adiciona novo produto |
| `PUT` |`/produtos/:id` | atualiza produto |
| `DELETE` |`/produtos/:id` | remove o produto |


## Estoque

| METODO | ENDPOINT | AÇÃO |
| --- | --- | --- |
| `GET` |`/estoque/disponivel?id=&quantidade=` | verifica se o produto está disponível e reserva temporariamente |


<br>

# Setup
Ao clonar o projeto, navegue até a pasta raiz para relizar os comandos a seguir:

## resolver dependências

``` 
mvn install 
```

## boot app

``` 
mvn spring-boot:run 
```

<br>

# Tecnologia
* java
* Spring-boot
* Maven
