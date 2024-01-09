# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

#Define environment variables
ENV JAVA_HOME=/usr/local/openjdk-17 \
    MAVEN_HOME=/usr/share/maven

# Add Maven to the path
ENV PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH

# Run Maven clean install to build your project
RUN mvn clean install -e

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define command to run your application
CMD ["java", "-jar", "springboot-rest-demo-ws/target/springboot-rest-demo-ws-1.0.0-SNAPSHOT.jar"]