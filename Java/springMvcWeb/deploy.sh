#!/bin/bash

# get catalina home
# /usr/local/bin/catalina
CATALINA=`find /usr/local/Cellar -name "catalina"`
if [ -z $CATALINA ]
then
    echo "Not find catalina, deploy failed!";
    exit;
fi

CATALINA_DIR=`dirname $CATALINA`
CATALINA_HOME=`cd "$CATALINA_DIR/.." >/dev/null; pwd`
echo "CATALINA_HOME: "$CATALINA_HOME;

if [ ! -d "$CATALINA_HOME"/libexec/linjunWebapps ]
then
    mkdir "$CATALINA_HOME"/libexec/linjunWebapps
fi

# mvn install
mvn clean install

# remove old files
echo "rm "$CATALINA_HOME"/libexec/linjunWebapps/springMvcWeb.war"
rm "$CATALINA_HOME"/libexec/linjunWebapps/springMvcWeb.war
echo "rm -rf "$CATALINA_HOME"/libexec/linjunWebapps/springMvcWeb"
rm -rf "$CATALINA_HOME"/libexec/linjunWebapps/springMvcWeb
cp ./target/springMvcWeb.war "$CATALINA_HOME"/libexec/linjunWebapps/
