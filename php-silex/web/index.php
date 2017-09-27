<?php

  require_once __DIR__.'/../vendor/autoload.php';

  use Symfony\Component\HttpFoundation\Request;

  $app = new Silex\Application();

  $app->before(function (Request $request) {
      if (0 === strpos($request->headers->get('Content-Type'), 'application/json')) {
          $data = json_decode($request->getContent(), true);
          $request->request->replace(is_array($data) ? $data : array());
      }
  });

  $app->post('/games', function (Silex\Application $app, Request $request) {
    $data = $request->request;
    error_log(print_r($data, true));
    return $app->json(array('status' => 'ok'));
  });

  $app->get('/games/{id}', function (Silex\Application $app, Request $request, $id) {
    $data = $request->query;
    error_log(print_r($id, true));
    error_log(print_r($data, true));
    return $app->json(array('status' => 'ok', 'move_from' => [0,2], 'move_to' => [0,3]));
  });

  $app->put('/games/{id}', function (Silex\Application $app, Request $request, $id) {
    $data = $request->request;
    error_log(print_r($id, true));
    error_log(print_r($data, true));
    return $app->json(array('status' => 'ok'));
  });

  $app->delete('/games/{id}', function (Silex\Application $app, $id) {
    error_log(print_r($id, true));
    return $app->json(array('status' => 'ok'));
  });

  $app->run();
