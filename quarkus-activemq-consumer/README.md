<p align="center">
    <b>Quarkus ActiveMQ Consumer Microservice</b><br>
</p>


### Description
- This project demonstrates how Quarkus application can utilize SmallRye Reactive Messaging to interact with ActiveMQ

### Prerequisite to build e install 
- [Java 17](https://adoptopenjdk.net/index.html)
- [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- [Docker](https://docs.docker.com/engine/install/)  
- [Docker Compose](https://docs.docker.com/compose/install/)  

### Technologies
Project is created with:
* Linux: Pop!_OS 22.04 LTS
* Java: 17
* Maven: 3.9.0
* Quarkus Platform: 2.16
* Docker: 23.0.1
* Portainer: latest

### Dependencies
Extensions Quarkus Platform:
```shell script
./mvnw quarkus:add-extension -Dextension=quarkus-resteasy-reactive-jackson
./mvnw quarkus:add-extension -Dextension=quarkus-smallrye-reactive-messaging-amqp
./mvnw quarkus:add-extension -Dextension=quarkus-hibernate-orm-rest-data-panache
./mvnw quarkus:add-extension -Dextension=quarkus-jdbc-h2
./mvnw quarkus:add-extension -Dextension=quarkus-smallrye-openapi
```

Other dependencies
* quarkus-junit5-mockito
* smallrye-reactive-messaging-in-memory
* com.google.guava
* org.mapstruct

### Clone 
1. Open terminal
2. Change the current working directory to the location where you want the cloned directory
3. Type git clone as below:
```shell script
git clone https://github.com/jairoacademy/quarkus-messaging.git
```
```
|── quarkus-messaging
|   └── activemq
|       |── quarkus-activemq-producer 
|       └── quarkus-activemq-consumer <<<
|   └── rabbitmq
|       |── quarkus-rabbitmq-producer
|       └── quarkus-rabbitmq-consumer
|   └── kafka
|       |── quarkus-kafka-producer
|       └── quarkus-kafka-consumer
```
### Setup
To run this project, install (ActiveMQ Message Broker) it locally using docker compose (access the quarkus-activemq-producer):
```shell script
docker-compose up -d
```

### Message Broker
Accessing ActiveMQ Artemis Management Console
```
http://localhost:8161/console/auth/login
```

### Getting Started
Start application and observe the console log when the producer send the messages:
```shell script
mvn quarkus:dev
```

### REST API Documentation
```
http://localhost:8181/q/swagger-ui/
```

# 🚀 Tips 
### Improve your README!
I recommend [Markdown Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
