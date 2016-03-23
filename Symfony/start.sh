#!/bin/sh
source ~/.bash_profile

# start web server
zkServer start

# start message midware
cd ~/Infrastructures/kafka_2.10-0.8.2.2
bin/kafka-server-start.sh config/server.properties
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

# start web server
cd ~/workspace/Symfony/my_project_2_8
php app/console server:run




