<?php

namespace AppBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class IndexController extends Controller
{
    /**
     * @Route("/")
     */
    public function indexAction(Request $request)
    {
        return $this->redirectToRoute('indexpage');
    }

    /**
     * @Route("/index", name="indexpage")
     */
    public function homepageAction(Request $request)
    {
        $session = $request->getSession();
        //$user = $this->getUser();
        //$this->
        return $this->render('index/index.html.twig');
    }
}
