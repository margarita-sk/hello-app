# hello-app

Simple template Spring boot v2 project (REST API GET /sayHello).
Every time when user triggers API he or she should recieve random message from hello message table.
Hello messages stored in database

There are three profiles in the application, thus you can deploy it localy with h2 database, using docker container with postgresql database or on sap cloud foundry with hana database.

## Requirements:
- Apache Maven 3.6.3
- Java version: 11.0.9
### For docker container deploynment:
- Docker version 20.10.2
### For cloud foundry deploynment:
- Apache Maven 3.6.3 
- Java version: 11.0.9
### For docker container deploynment: 
- Docker version 20.10.2 
### For cloud foundry deploynment: 
- Cloud foundry client version 7.2.0
- Node.js 6.14.10
- Also you need to have SAP Cloud Platform account with subaccount and space on it (it may be trial)


# profiles

## 1. local (for local deployment with h2 database)
```
$ mvn clean package
$ cd target
$ java -jar hello-app-01.jar --spring.profiles.active=local
```
(by default local deployment uses 8090 localhost, but you can change it in application-local.properties)

## 2. local-complete (with postgresql database)

Requirements
```
$ mvnw clean package
```
- copy compiled jar to main/src/docker folder
- in command line set (form docker folder):
```
$ docker-compose up
```
(by default local deployment uses 8080 localhost, but you can change it in application-local.properties)

## 3. hosted (with hana database)
```
$ cf create-service  hana  hdi-shared  hana-db
$ cf csk hana-db hanaKey
$ cf service-key hana-db hanaKey

$ mbt build
$ cd mta_archives
$ cf deploy spring-boot-hana-db-app_1.3.10.mtar
```
