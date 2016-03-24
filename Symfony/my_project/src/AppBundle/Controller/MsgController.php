<?php

namespace AppBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class MsgController extends Controller
{
    /**
     * @Route("/sendMsg")
     */
    public function sendMsgAction(Request $request)
    {
        // replace this example code with whatever you need
        $produce = \Kafka\Produce::getInstance('localhost:2181', 3000);

        $produce->setRequireAck(-1);
        $produce->setMessages('test', 0, array('linjun3'));
        $result = $produce->send();
        #var_dump($result);
        return new Response("OK");
    }
}
