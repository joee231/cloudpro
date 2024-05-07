FROM tomcat:9.0-jre17-temurin-focal
COPY StudentInformation.war /usr/local/tomcat/webapps/
COPY mysql-connector-j-8.1.0.jar /usr/local/tomcat/lib

EXPOSE 8080
CMD ["catalina.sh", "run"]