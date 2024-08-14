# backend-water-bucket-challenge #

This project contains a springboot application that allows you to solve the challenge of water jugs. in this exercise he asks to make a design that solves for the classic Water Jug Riddle. The task is to create an API that can compute the steps required to measure exactly Z gallons using two jugs of capacities X and Y gallons. The backend should process this problem efficiently and return the solution steps in JSON format through a RESTful API 


## Pre Requisites ##

To be able to work with this project, you must have the following tools in your team.

1. Java development kit 16 or higher: Development tools that allow the creation of applications in the Java programming language. [JDK](https://www.java.com/es/download/manual.jsp)

2. Apache Maven 3.3.2 or higher: Dependency manager that allows the management and construction of Java projects. [Maven](https://maven.apache.org/)

3. Integrated Development Environment: A tool that allows developers to produce quality code for software development. [Eclipse](https://www.eclipse.org/downloads/) [Intellij IDEA](https://www.jetbrains.com/es-es/idea/)

4. Postman: API platform for building and using APIs. Postman simplifies each step of the API lifecycle and streamlines collaboration so you can create better APIs—faster [Postman](https://www.postman.com/)


## Technologies used ##

1. Spring boot: Module that simplifies the development of applications using the Spring framework.


## repository

```
cd existing_repo
git remote add origin https://github.com/rsocorro17/water_bucket_challenge
git branch -M main
git push -uf origin main
```
## Estructura del proyecto ##

La estructura del proyecto se define de la siguiente forma:

```bash
├── src                                     # Directorio raiz de los fuentes
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │     └── challenge
│   │   │       └── springboot
│   │   │         └── api
│   │   │           └── water_bucket
│   │   │               ├── controllers # Package with controller classes
|   |   |               ├── exceptions # Package with exceptions classes
|   |   |               ├── models # Package with models classes
|   |   |               ├── services # Package with classes services
|   |   |               ├── wrappers # Package with wrappers classes
│   │   └── resources # contains configurations resources
│   └── test # contains unit test proyect
```

## Test and Deploy

The base project considers the use of [maven profiles](https://maven.apache.org/guides/introduction/introduction-to-profiles.html), which allow different configurations depending on the environment in which the deployment will be made.

The profiles considered in the project are **dev and prod**, with the **dev** profile being the default asset.

* 'dev' environment profile: Profile that allows the application to make use of resources from the development environment, which are controlled by the development team. The configurations  
  for this profile are located in the 'application.properties' file.

* 'Prod' environment profile: Profile that allows the application to make use of resources from the production environment where the application will be deployed for end customers. The configurations  
  for this profile are located in the 'application.properties' file.

To build the project you must use the command 'mvn clean package -P<ambiente>' getting as a **jar** file inside the
Target/.

***

## Name
API Water Bucket Challenge.

## Description
Overview:
In this exercise, backend candidates will design a solution for the classic Water Jug Riddle. The task is to 
create an API that can compute the steps required to measure exactly Z gallons using two jugs of 
capacities X and Y gallons. The backend should process this problem efficiently and return the solution 
steps in JSON format through a RESTful API.
Requirements:
1. RESTful API:
• Develop endpoints to accept jug capacities (X and Y) and the target volume (Z) as inputs.
• Ensure the API strictly adheres to REST principles with appropriate use of HTTP 
methods.
• Responses must be provided in JSON format detailing the sequence of actions to solve 
the riddle or indicating if no solution is possible.
2. Algorithm Implementation:
• Implement an algorithm that determines the sequence of steps needed to measure 
exactly Z gallons, if feasible.
• The solution must consider the actions: Fill, Empty, and Transfer (between the two jugs 
only).
3. Performance Considerations:
• Optimize the algorithm for quick response times, especially considering the potential for 
large input values.
4. Error Handling and Validation:
• Validate input to ensure X, Y, and Z are positive integers.
• Return meaningful error messages in JSON format if inputs are invalid or if no solution 
can be found.
5. Testing:
• Create unit tests to verify the correctness of the algorithm.
• Include integration tests to ensure the API handles requests and responses correctly.
6. Documentation:
• Provide a README.md file detailing the API endpoints, how to set up and run the 
application, and an explanation of the algorithm used.
• Include example requests and responses for clarity.
7. Scalability extra points not necessary:
• Design the API to handle a high number of requests efficiently, using techniques such as 
caching results for common requests.

## Authors and acknowledgment
This project was developed by Ronald Socorro Systems Engineer.

## Documentation Reference ##

For more information regarding the frameworks and tools used in this project, refer to the documentation at the following links:

* [Springboot](https://spring.io/projects/spring-boot)
* [Exception Handling in Spring](https://www.baeldung.com/exception-handling-for-rest-with-spring)
* [Apache Maven](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)