FROM tomcat:9.0.87-jdk11

WORKDIR /usr/local/tomcat/webapps/

COPY ./target/DAAPP01Practica03-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["catalina.sh", "jpda", "run"]