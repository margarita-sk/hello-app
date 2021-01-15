# hello-app

Simple template Spring boot v2 project (REST API GET /sayHello).
Every time when user triggers API he or she should recieve random message from hello message table.
Hello messages stored in database

There are three profiles in the application.

You can change profile in pom.xml

# profiles

1. local (for local deployment with h2 database)
- in pom.xml set true to local profile

(by default local deployment uses 8090 localhost, but you can change it in application-local.properties)

2. local-complete (with postgresql database)
- in pom.xml set true to local-complete profile
- in command line set (form hello-app folder): 
```
$ mvnw clean package
```
- copy compiled jar to main/src/docker folder
- in command line set (form docker folder): 
```
$ docker-compose up
```
(it composes two images: hello-app and postgresql)

3. hosted (with hana database)
- in pom.xml set true to hosted profile
in command line set (form hello-app folder): 
```
$ mvn clean install

$ cf push
```

