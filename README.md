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

# Water Bucket API

This API solves the water jug problem using Spring Boot and Java.

### API Routes

The only route exposed by this API is:

```bash

POST /api/waterjug

```

This route accepts POST requests with application/json content type.

### Request Payload

The expected payload for the POST request has the following structure:

```bash

JSON

{"xCapacity": <int>, "yCapacity": <int>, "zAmountWanted": <int>}

```


Where:
- `xCapacity`: Capacity of the first jug
- `yCapacity`: Capacity of the second jug
- `zAmountWanted`: Target volume

Example of a valid payload:

```bash

JSON

{ "xCapacity": 5, "yCapacity": 3, "zAmountWanted": 4 }

```

### Response Output

The response will be a JSON object with the following structure:

```bash

JSON

{ "solution": [ { "x": <int>, "y": <int>, "steps": [<array>] } ] }

```

Where:
- `x`: Amount of water in the first jug
- `y`: Amount of water in the second jug
- `steps`: Array of steps to reach the solution

### Port Configuration

To assign a specific port to the API on localhost, modify the `application.properties` file:

properties server.port=<your-preferred-port>

For example, to use port 8081:

properties server.port=8081

### Build Commands

To compile and run the API, follow these steps:

1. Build the application:

```bash

./mvnw clean package

[INFO] Scanning for projects...
[INFO] 
[INFO] -------------< com.challenge.springboot.api:water_bucket >--------------
[INFO] Building water_bucket 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.3.2:clean (default-clean) @ water_bucket ---
[INFO] Deleting c:\Desarrollo\water_bucket_challenge\target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.945 s
[INFO] Finished at: 2024-08-30T18:35:46-04:00
[INFO] ------------------------------------------------------------------------

```

2. Run the application:

```bash

java -jar target/water-bucket.jar

c:; cd 'c:\Desarrollo\water_bucket_challenge'; & 'C:\Program Files\Java\jdk-17\bin\java.exe' '-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:64927' '@C:\Users\dudle\AppData\Local\Temp\cp_smrxjugj2axv8pfcx0reat5d.argfile' 'com.challenge.springboot.api.water_bucket.WaterBucketApplication'
emp\x5ccp_smrxjugj2axv8pfcx0reat5d.argfile' 'com.challenge.springboot.api.water_bucket.WaterBucketApplication' ;e2031475-9fb3-449b-8cb5-c278a80754ff
  .   ____          _            __ _ _   
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \  
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \ 
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / / 
 =========|_|==============|___/=/_/_/_/  
 :: Spring Boot ::                (v3.3.2)

2024-08-30T18:38:28.402-04:00  INFO 3524 --- [water_bucket] [  restartedMain] c.c.s.a.w.WaterBucketApplication         : Starting WaterBucketApplication using Java 17.0.8 with PID 3524 (C:\Desarrollo\water_bucket_challenge\target\classes started by dudle in C:\Desarrollo\water_bucket_challenge)
2024-08-30T18:38:28.410-04:00  INFO 3524 --- [water_bucket] [  restartedMain] c.c.s.a.w.WaterBucketApplication         : No active profile set, falling back to 1 default profile: "default"
2024-08-30T18:38:29.251-04:00  INFO 3524 --- [water_bucket] [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable    
2024-08-30T18:38:29.518-04:00  INFO 3524 --- [water_bucket] [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'  
2024-08-30T18:38:39.106-04:00  INFO 3524 --- [water_bucket] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-08-30T18:38:39.233-04:00  INFO 3524 --- [water_bucket] [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-08-30T18:38:39.244-04:00  INFO 3524 --- [water_bucket] [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.26]
2024-08-30T18:38:39.669-04:00  INFO 3524 --- [water_bucket] [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-08-30T18:38:39.767-04:00  INFO 3524 --- [water_bucket] [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 10168 ms
2024-08-30T18:38:48.339-04:00 DEBUG 3524 --- [water_bucket] [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : 3 mappings in 'requestMappingHandlerMapping'
2024-08-30T18:38:48.845-04:00 DEBUG 3524 --- [water_bucket] [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Patterns [/webjars/**, /**] in 'resourceHandlerMapping'
2024-08-30T18:38:49.278-04:00 DEBUG 3524 --- [water_bucket] [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerAdapter : ControllerAdvice beans: 0 @ModelAttribute, 0 @InitBinder, 1 RequestBodyAdvice, 1 ResponseBodyAdvice
2024-08-30T18:38:49.930-04:00 DEBUG 3524 --- [water_bucket] [  restartedMain] .m.m.a.ExceptionHandlerExceptionResolver : ControllerAdvice beans: 1 @ExceptionHandler, 1 ResponseBodyAdvice
2024-08-30T18:38:50.770-04:00  INFO 3524 --- [water_bucket] [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-08-30T18:38:51.591-04:00  INFO 3524 --- [water_bucket] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-08-30T18:38:51.862-04:00  INFO 3524 --- [water_bucket] [  restartedMain] c.c.s.a.w.WaterBucketApplication         : Started WaterBucketApplication in 26.123 seconds (process running for 28.732)

```

### Main Endpoint

```bash

@RestController 
@RequestMapping("/api/waterjug") public class WaterJugController {}

```

### Service Implementation

```bash

@Service 
public class WaterJugService {}

```

### Request Model

```bash

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class WaterJugRequest { private int xCapacity; private int yCapacity; private int zAmountWanted; }

```

### Solution Model

```bash

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class SolutionWrapper { private List<SolutionStep> solution; }

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class SolutionStep { private int x; private int y; private List<Step> steps; }

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Step { private String action; private int amount; }

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