# spring-boot-appointment

/**To Run Docker file**/

cd /<local_directory>/spring-boot-appointment

Build the Docker image : docker build -t springboot-appointment-docker .

Run the Spring Boot application : docker run -p 8080:8080 springboot-appointment-docker

/**To Run docker-compose file**/

Build all the services and then run them : docker-compose up --build

