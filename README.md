# estoque
Serviço responsável por verificar se existe um produto disponível em estoque e por reservá-lo. A interação com o serviço se dá através de uma **api-rest** e via **mensageria via evento** (_implementação futura_) 


_**obs**:por fazer parte de um estudo de arquitetura de microserviços este projeto é bem simples. Ele também compoem um sistema ainda mais simples de e-commerce._

<br>

# api


## Estoque

| METODO | ENDPOINT | AÇÃO |
| --- | --- | --- |
| `GET` |`/estoque/disponivel?id=&quantidade=` | alterarna entre disponível e não disponível a cada chamada |


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
