
FROM tomcat:8.0.21-jre8
COPY target/*.war /usr/local/tomcat/webapps/*.war
