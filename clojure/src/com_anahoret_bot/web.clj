(ns com-anahoret-bot.web
  (:gen-class)
  (:use ring.util.response)
  (:require [compojure.core :refer [GET POST PUT DELETE ANY context defroutes]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            
            [clojure.java.io :as io]
            [clojure.string :refer [upper-case]]
            [clojure.tools.logging :as log]
            
            [ring.adapter.jetty :as jetty]
            [ring.middleware.json :refer [wrap-json-body]]
            [ring.util.response :refer [response status]]
            [ring.middleware.format-response :refer [wrap-restful-response]]
            
            [environ.core :refer [env]]))

(defroutes app-routes
  (context "/games" []
    (POST "/" [:as req]
      (response {:status "ok"}))
    (context "/:id" [id]
      (GET "/" [:as req]
        (response {:status "ok"
                   :figure 0}))
      (PUT "/" [:as req]
        (response {:status "ok"}))
      (DELETE "/" [:as req]
        (response {:status "ok"}))))
  (ANY "*" []
    (route/not-found (slurp (io/resource "404.html")))))

(defn wrap-request-logger
  [handler]
  (fn [req]
    (let [{remote-addr :remote-addr request-method :request-method uri :uri} req
          body (slurp (req :body))]
      (log/info remote-addr (upper-case (name request-method)) uri "->" body)
      (handler req))))

(defn wrap-response-logger
  [handler]
  (fn [req]
    (let [response (handler req)
          {remote-addr :remote-addr request-method :request-method uri :uri} req
          {status :status body :body} response]
        (log/info remote-addr (upper-case (name request-method)) uri "->" status body) response)))

(def app
  (-> app-routes
      (wrap-json-body)
      (wrap-request-logger)
      (wrap-response-logger)
      (wrap-restful-response)))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))

