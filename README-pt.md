# simple-api-gateway
Um simples projeto usando o Zuul para demonstrar o padrão API Gateway.

## Getting Started
Basta clonar o repositório e rodar os três projetos.
```
cd api-gateway
mvn springboot:run

cd service-one
mvn springboot:run

cd service-one
mvn springboot:run
```

Com os serviços rodando, vá até o browser e chame as URLs http://localhost:8080/servicetwo e http://localhost:8080/serviceone.

## Explicação Rápida
Foram criados dois serviços simples (service-one and service-two), os quais foram expostos nas portas 8081 e 8082 respectivamente.
Seus domínios são `/serviceone` e `/servicetwo`.

Assim, podemos acessá-los individualmente chamando `localhost:8081/serviceone` ou `localhost:8082/servicetwo`.
mas essa arquitetura pode trazer algumas complicações de acoplamento caso tenhamos uma cliente, pois cada serviço disponível para 
a aplicação terá uma URL diferente.

Para resolver esse problema criamos um terceiro projeto (api-gateway), onde fazemos redirecionamentos de acordo com o domínio especificado na URL. 
Esses redirecionamentos, graças à dependência Zuul, são feitos declarativamente no arquivo `application.properties` do projeto api-gateway.

Dessa forma, nossos clientes só precisam conhecer a URL do serviço api-gateway, que passa a ser a porta de entrada da nossa aplicação.

Para saber mais sobre o padrão API Gateway, veja https://microservices.io/patterns/apigateway.html.
Para saber mais sobre o Zuul veja https://github.com/Netflix/zuul.

# API Composition
API Composition (composição de APIs) é um padrão no qual um serviço chamado pela aplicação cliente chama outros dois ou mais serviços e formata a resposta antes de enviá-la de volta ao cliente. Dessa forma, o cliente não precisa executar várias chamadas aos vários serviços disponíveis para recuperar a informação necessária. 

Este repositório tem um exemplo de composição de APIs disponível na [branch] (https://github.com/igorgonribs/simple-api-gateway/tree/api-composition-example)

Uma discussão mais profunda sobre esse padrão pode ser encontrada nesse [post](https://medium.com/p/c266f0202b8/edit).