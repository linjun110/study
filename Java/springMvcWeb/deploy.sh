#!/bin/bash

rm /usr/local/Cellar/tomcat/8.0.32/libexec/webapps/springMvcWeb.war
rm -rf /usr/local/Cellar/tomcat/8.0.32/libexec/webapps/springMvcWeb
cp /Users/linjun/study/Java/springMvcWeb/target/springMvcWeb.war /usr/local/Cellar/tomcat/8.0.32/libexec/webapps/

