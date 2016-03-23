<?php
namespace Linjun;

include_once './vendor/autoload.php'; 

class Solution
{
    public function init(){
        print "init";
    }

    public function listen(){
        $consumer = \Kafka\Consumer::getInstance('localhost:2181');

        $consumer->setGroup('testgroup');
        $consumer->setPartition('test', 0);
        #$consumer->setPartition('test6', 2, 10);
        while(true){
            $result = $consumer->fetch();
            foreach ($result as $topicName => $topic) {
                foreach ($topic as $partId => $partition) {
                    //var_dump($partition->getHighOffset());
                    foreach ($partition as $message) {
                        var_dump((string)$message);
                    }
                }
            }
        }
    }

    public function insertMongoDB(){
        $client = new \MongoDB\Client("mongodb://localhost:27017");
        // demo: the db name
        // beers: the document name
        $collection = $client->demo->beers;

        $result = $collection->insertOne( [ 'name' => 'Hinterland', 'brewery' => 'BrewDog' ] );

        echo "Inserted with Object ID '{$result->getInsertedId()}'";
    }
}

$solution = new Solution();
$solution->init();
$solution->listen();
