FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app
EXPOSE 8081

# JAR 파일 복사 (plain이 아닌 버전 사용)
COPY build/libs/hellChangClub-0.0.1-SNAPSHOT.jar app.jar

# 컨테이너 실행 시 실행될 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]