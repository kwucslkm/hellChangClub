FROM openjdk:17-jdk
ADD /build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]