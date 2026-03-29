# Estágio 1: Build com Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Deploy no Tomcat
FROM tomcat:11.0-jdk17
# Copia as apps padrão do Tomcat (ROOT, manager, docs, etc.) para webapps
RUN cp -r /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps/
# Copia o WAR gerado
COPY --from=build /app/target/to-learn-java-web-docker.war /usr/local/tomcat/webapps/to-learn-java-web-docker.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
