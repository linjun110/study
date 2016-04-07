#!/bin/bash

echo $0
echo $1
echo $@
echo $*
echo $#

# /usr/local/bin/catalina
CATALINA_PATH=`which catalina`;

# lrwxr-xr-x 1 linjun admin 36 4 7 12:55 /usr/local/bin/catalina -> ../Cellar/tomcat/8.0.32/bin/catalina
lsStr=`ls -ld "$CATALINA_PATH"`

# ../Cellar/tomcat/8.0.32/bin/catalina
lastPart=`expr "$lsStr" : '.*-> \(.*\)$'`

# lrwxr-xr-x 1 linjun admin 36 4 7 12:55 /usr/local/bin/catalina
firstPart=`expr "$lsStr" : '\(.*\) -> .*$'`

arr=(${firstPart// / })
arrLen=${#arr[@]}  

# /usr/local/bin/catalina
linkedPath=${arr[$arrLen-1]} 

linkedDir=`dirname "$linkedPath"`

# /usr/local/bin/../Cellar/tomcat/8.0.32/bin/catalina
finalPath=$linkedDir"/"$lastPart
finalPath=`dirname $finalPath`

CATALINA_HOME=`cd "$finalPath/.." >/dev/null; pwd`
echo $CATALINA_HOME;
