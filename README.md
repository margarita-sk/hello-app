# hello-app

Simple template Spring boot v2 project (REST API GET /sayHello).
Every time when user triggers API he or she should recieve random message from hello message table.
Hello messages stored in database

There are three profiles in the application, thus you can deploy it localy with h2 database, using docker container with postgresql database or on sap cloud foundry with hana database.

# profiles

## 1. local (for local deployment with h2 database)
```
$ mvn clean instull
$
$ java -jar hello-app-01.jar --spring.profiles.active=local
```
(by default local deployment uses 8090 localhost, but you can change it in application-local.properties)

## 2. local-complete (with postgresql database)
```
$ mvnw clean package
$
```
- copy compiled jar to main/src/docker folder
- in command line set (form docker folder): 
```
$ docker-compose up
```
(it composes two images: hello-app and postgresql)
(by default local deployment uses 8080 localhost, but you can change it in application-local.properties)

## 3. hosted (with hana database)
```
$ mvn clean install 
$
$ cf create-service  hana  hdi-shared  hana-db
$
$ cf push
$
$ cf bind-service hello-app hana-db
$
$ cf csk hana-db hanaKey
$
$ java -jar hello-app-01.jar --spring.profiles.active=hosted
$
$ cf push
```
