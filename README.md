# Spring Boot and Angular Example Application

Example running Spring Boot as backend and Angular as frontend. This example application use the Tour of Hero from Angular tutorial. Angular frontend is served by Spring Boot embedded container. The backend has a embedded in-memory HSQLDB for persistence.

This use `frontend-maven-plugin` that will run embedded npm installing all dependencies required by Angular and will run Angular build placing generated files on `main/resources/static` for embedded container.

For Angular route work property, the Spring is configured for redirect all 404 error to Angular's host page `/index.html` (info [here](https://angular.io/guide/deployment#basic-deployment-to-a-remote-server)).

## Run

Run `mvn spring-boot:run` and open http://localhost:8080 on your browser.
