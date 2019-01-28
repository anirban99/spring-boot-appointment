# spring-boot-appointment

**To Run as a Spring Boot application**

Using Maven plugin: 

1. mvn clean spring-boot:run

Using Jar file as a packaged applicationv: 

1. mvn clean package

2. java -jar ./target/spring-boot-appointment-0.0.1-SNAPSHOT.jar


**To Run using Docker file**

cd /<local_directory>/spring-boot-appointment

Build the Docker image : docker build -t springboot-appointment-docker .

Run the Spring Boot application : docker run -p 8080:8080 springboot-appointment-docker

**To Run using docker-compose file**

Build all the services and then run them : docker-compose up --build


**REST Endpoints**

1.**GET** request to return specific appointments - /api/v1/appointments/{appointmentId}

http://localhost:PORT/api/v1/appointments/3

2.**GET** request to return all appointments - /api/v1/appointments/

http://localhost:PORT/api/v1/appointments/

3.**GET** request to return all appointments based on a date range and ordered by price - /api/v1/appointments?startDate={start_date}&endDate={end_date}

http://localhost:PORT/api/v1/appointments?startDate=2019-01-23&endDate=2019-02-15

4.**POST** request to add new appointments - /api/v1/appointments

http://localhost:PORT/api/v1/appointments

Pass Body as JSON:

{
    "appointmentDate": "2019-02-14",
    "appointmentStartTime": "20:00:00",
    "appointmentEndTime": "21:00:00",
    "nameOfDoctor": "Raj",
    "status": "Booked",
    "price": 70
}

5.**PUT** request to update appointments - /api/v1/appointments/{appointmentId}

http://localhost:PORT/api/v1/appointments/3

Pass Body as JSON:

{
    "id": 5,    
    "appointmentDate": "2019-02-14",
    "appointmentStartTime": "20:00:00",
    "appointmentEndTime": "21:00:00",
    "nameOfDoctor": "Raj",
    "status": "Available",
    "price": 70
}

6.**PATCH** request to update status of an appointment - /api/v1/appointments/{appointmentId}

http://localhost:PORT/api/v1/appointments/3

Pass Body as JSON:

{
	"status": "Available"
}

7.**DELETE** request to delete specific appointments - /api/v1/appointments/{appointmentId}

http://localhost:PORT/api/v1/appointments/3