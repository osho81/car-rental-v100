## Car Rental Application

Note: car-rental-v1, car-rental-v2 or this car-rental-v100 are almost identical, but:
- v1 is mainly for microservice approach, 
- v2 is for plain js frontend, while this
- v100 is for react/js frontend.

### Intro on overall car rental project

This car-rental-v100 is mainly a rest api project built on Java/SpringBoot.
From the admin-web website, registered administrators/employees can retrieve, display and edit data from the
car-rental-v100 rest api endpoints and its connected database.
From the customer-web website, enables the similar functions for customers (non-administrators). Different access rights
etc. will be described hereafter.

#### All projects belonging to the FULLSTACK car rental project can be found here:

- [car-rental-v100 (this backend rest api project)](LINK SOON)
- [admin-web (this frontend React/js project)](LINK SOON)
- [customer-web (corresponding webpage for customers)](LINK SOON)
- Or see all related projects in the [GitLab project-group](LINK SOON)

##### Corporate styleguide used for these projects:

- [TW Styleguide](https://gitlab.com/car-rental-fullstack/tw-styleguide)

##### All projects belonging to the MICROSERVICE car rental, can be found here:

- The microservice
  aligned [car-rental-v1 (the V1 backend rest api project)](https://gitlab.com/car-rental-fullstack/car-rental-v1)
- Microservice [api-gateway](https://github.com/osho81/car-rental-api-gateway)
- Microservice for [rate exchange](https://github.com/osho81/car-rental-exchange-service)
- Server [registry](https://github.com/osho81/car-rental-service-registry) for the already available and eventual more
  future microservices

### Functions and api services

- Login with Keycloak security server (via postman, browser, or other client)
- Api for storing, updating, deleting new customers, cars, orders
- Api for exchange price from SEK to EUR

### DB & Mockdata

For this project H2 database is used. There are two approaches, one in memory only, and one with enabled H2 db
connection in intelliJ as well. In both cases the MockData.java automatically creates few mockdata records to the
database.

#### H2 in memory only

- Enable spring.datasource.url=jdbc:h2:mem:carrental in application.properties file
- (Unconnect or ignore eventual intelliJ connected H2 db)
- If there is need for more mockdata records, copy sql statements from the data.sql file and run in the H2 browser
  console.

#### H2 approach for H2 console & intelliJ db connect

- Enable #spring.datasource.url=jdbc:h2:file:/data/carrental;AUTO_SERVER=TRUE in application.properties file
- (Optionally connect H2 db to intelliJ)
- If there is need for more mockdata records, execute the whole of part of the data.sql file.
    - No customized schemas are used.
    - If required, select CARRENTAL.PUBLIC as target data source/schema in data.sql run configurations.
    - Alternatively, copy sql statements from the data.sql file and run in the H2 browser console.

To see H2 data in browser console (http://localhost:9090/h2-console), be sure to select the correct JDBC url to log in
to the console (see url in spring.datasource.url in application.properties file).

### Techs & languages used

- Java, Spring, Springboot, Rest-api
- H2 (while MySQl was used in car-rental-v1)
- Keycloak & spring security
- HTTP request to external api

### Security related matters for the fullstack project

For login and access management, [Keycloak (Quarkus distribution)](https://www.keycloak.org/downloads) is employed. For
the frontend (customer-web & admin-web) a Javascript adapter from the same source have been included in the project.
Brief
configuration description:

- Realm name: car-rental-realm
- Client id: car-rental-v2
- Valid post logout redirect URIs, relevant for e.g. VS Code live server:
    - http://localhost:9090/api/v1/*
    - http://127.0.0.1:5500/*
    - http://127.0.0.1:5501/* (in case use customer & admin web simultanous)
    - During development * as uri and web origin uri is sufficient.
- Roles: admin & user

Authorization is validated using keycloak Bearer access token in the http requests.

- Users with assigned "admin" role can access the endpoints described for admins/employees
- Users with assigned "user" role can access the endpoints described for the customers
- The role restrictions can be seen in SecurityConfig.java (in its antMatchers)

### Purpose/Motivation

To test and improve skills in Springboot, security implementation, and microservice architecture.