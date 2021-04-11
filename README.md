# simple-api-gateway
Simple API Gateway project with Zuul to demonstrate the pattern. 

You can read this file in portuguese by clicking [here](https://github.com/igorgonribs/simple-api-gateway/blob/master/README-pt.md).

## Getting Started
Just clone this repository and run all the three projects.
```
cd api-gateway
mvn springboot:run

cd service-one
mvn springboot:run

cd service-one
mvn springboot:run
```

Then go to the browser and access http://localhost:8080/servicetwo or http://localhost:8080/serviceone.

## Short Explanation
In this repository we have two simple services (service-one and service-two), exposed in ports 8081 and 8082 repectively.
The domains are `/serviceone` and `/servicetwo`.

So calling `localhost:8081/serviceone` we got a response from service one, and calling `localhost:8082/servicetwo` we got a response from service two.

But, with this architecture, if we have a client (an UI, for example), for each microservice running we need to set an URL in our 
client, this could bring us some coupling problems.

To solve this, another project was created, the apigateway. Here we set some declarative redirections in the application.properties file and expose 
the service in the port 8080.

Now, our client just needs to know the URL for the API Gateway, wich is the main door for our microservices architecture.

More about this pattern called API Gateway, like its pros and cons, can be found at https://microservices.io/patterns/apigateway.html.
The dependency used for redirecting was Zuul, an open source project mantained by Netflix. For more information about Zuul see https://github.com/Netflix/zuul.

# API Composition
API Composition is a pattern where a service called by the client calls others two or more services and format the response before returning it to the client. So, the client doesn't need to call several services in diferents requests to get the needed information. 

This repository has an example of this pattern and you can see it in this [branch] (https://github.com/igorgonribs/simple-api-gateway/tree/api-composition-example)

A deeper discussion about this pattern, like pros and cons, can be found in this [post](https://medium.com/p/c266f0202b8/edit) (portuguese only).
