#!/bin/bash

# get catalina home
# /usr/local/bin/catalina
CATALINA=`find /usr/local/Cellar -name "catalina"`
if [ -z "$CATALINA" ]
then
    echo "Not find catalina, deploy failed!";
    exit;
fi

CATALINA_DIR=`dirname $CATALINA`
CATALINA_HOME=`cd "$CATALINA_DIR/.." >/dev/null; pwd`
echo "=== CATALINA_HOME: "$CATALINA_HOME" ===";

if [ ! -d "$CATALINA_HOME"/libexec/linjunWebapps ]
then
    mkdir "$CATALINA_HOME"/libexec/linjunWebapps
fi

# mvn install
mvn clean install

# remove old files
echo "cmd: rm "$CATALINA_HOME"/libexec/linjunWebapps/springMvcWeb.war"
rm "$CATALINA_HOME"/libexec/linjunWebapps/springMvcWeb.war
echo "cmd: rm -rf "$CATALINA_HOME"/libexec/linjunWebapps/springMvcWeb"
rm -rf "$CATALINA_HOME"/libexec/linjunWebapps/springMvcWeb
echo "cmd: cp ./target/springMvcWeb.war "$CATALINA_HOME"/libexec/linjunWebapps/"
cp ./target/springMvcWeb.war "$CATALINA_HOME"/libexec/linjunWebapps/

# start mysql if not started
MYSQL_STARTED=`ps aux | grep mysql | grep "bin\/mysqld"`
if [ -z "$MYSQL_STARTED" ]
then
    echo "=== Mysql NOT stared, starting ... ===";
    mysql.server start
fi

# start tomcat if not started
CATALINA_STARTED=`ps aux | grep tomcat | grep "org.apache.catalina.startup.Bootstrap start"`
if [ -z "$CATALINA_STARTED" ]
then
    echo "=== Catalina NOT stared, starting ... ===";
    "$CATALINA_HOME"/libexec/bin/startup.sh
fi
