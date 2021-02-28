FROM openjdk:8
ADD target/codetest-0.0.1-SNAPSHOT.jar codetest-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar" , "codetest-0.0.1-SNAPSHOT.jar"]