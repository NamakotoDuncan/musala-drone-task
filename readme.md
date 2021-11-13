# musala-soft-drone

## Prerequisites
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)


## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Maven
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)


<br/>


###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/musala-soft-drone**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory

Run jar file from below path with given command
> **```java -jar ~/path-to-musala-soft-drone/target/musala-soft-drone-0.0.1-SNAPSHOT.jar```**

Or
> run main method from `MusalaDroneMainApplication.java` as spring boot application.  


### API Endpoints
> **GET Mapping** http://localhost:8090/drone/available GET available drones
> > **GET Mapping** drone battery level http://localhost:8090/drone/AOOO-1/battery
> > **GET Mapping** loaded medication per drone  http://localhost:8090/drone/AOOO-12/load
>  > **POST Mapping**  register a drone
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8090/drone --data '{
"serialNumber": "AOOO-1s",
"model": "CRUISERWEIGHT",
"batteryCapacity":45,
"status": "IDLE"
}'
> 
>  > **POST Mapping** load a drone with medications
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8090/drone/load --data '{
"drone":{
"serialNumber": "AOOO-1s",
"model": "CRUISERWEIGHT",
"batteryCapacity":45,
"status": "IDLE"
},
"medications":[{"name":"PARACETAMOL","weight":250.0,"code":"001","imageUrl":"https://tinyurl.com/3ykwwwe4"},{"name":"INSULIN","weight":315.0,"code":"002","imageUrl":"https://tinyurl.com/3ykwwwe4"},{"name":"EYE DROP","weight":125.0,"code":"003","imageUrl":"https://tinyurl.com/3ykwwwe4"},{"name":"STEROID","weight":200.0,"code":"002","imageUrl":"https://tinyurl.com/3ykwwwe4"},{"name":"PARACETAMOLw","weight":35.0,"code":"007","imageUrl":"https://tinyurl.com/3ykwwwe4"}]
}'