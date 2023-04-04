<p align="center">
    <b>Quarkus Kafka Producer Microservice</b><br>
</p>

### Description
- This project demonstrates how Quarkus application can utilize SmallRye Reactive Messaging to interact with Kafka

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
./mvnw quarkus:add-extension -Dextension=quarkus-smallrye-reactive-messaging-kafka
```

Other dependencies
* smallrye-reactive-messaging-in-memory
 
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
|       └── quarkus-activemq-consumer
|   └── kafka
|       |── quarkus-kafka-producer <<<
|       └── quarkus-kafka-consumer
|   └── kafka
|       |── quarkus-kafka-producer
|       └── quarkus-kafka-consumer
```
### Setup
To run this project, install (Kafka Message Broker) it locally using docker compose:
```shell script
docker-compose up -d
```

### Message Broker
Accessing Confluent Control Center
```
http://localhost:9021/
```

### Getting Started
Start application:
```shell script
mvn quarkus:dev
```

Send a simple message to Kafka 
```shell script
curl http://localhost:8080/client/createMessaging
```
Send a JSon/Pojo representation to Kafka
```shell script
curl http://localhost:8080/client/createClientBody
```
Send a Person entity representation to Kafka
```shell script
curl http://localhost:8080/person/createPerson
```

This is cool!
<br> 
Start the Consumer microservice and from producer microservice, send a quote message.
```shell script
curl http://localhost:8080/quote/request
```

The Consumer microservice sends a Quote back to the Producer microservice. Additionally, users can utilize Server-sent events by creating a request in Postman that supports this feature. This can be a fun and engaging way to explore the functionality of the microservices.
```shell script
curl http://localhost:8080/quote/stream
```
 
### Consumer REST API
Where is it:
```
|── quarkus-messaging
    └── kafka
        |── quarkus-kafka-producer 
        └── quarkus-kafka-consumer <<<
```

### REST API Documentation
```
http://localhost:8080/q/swagger-ui/
```

# 🚀 Tips 
### Improve your README!
I recommend [Markdown Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
