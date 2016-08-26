(defproject com-anahoret-bot "1.0.0-SNAPSHOT"
  :description "Demo Clojure Bot"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [ring-middleware-format "0.7.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [compojure "1.5.1"]
                 [org.clojure/tools.logging "0.3.1"]
                 [environ "1.0.0"]]
  :min-lein-version "2.0.0"
  :main com-anahoret-bot.web
  :plugins [[environ/environ.lein "0.3.1"]]
  :hooks [environ.leiningen.hooks]
  :uberjar-name "com-anahoret-bot-standalone.jar"
  :profiles {:production {:env {:production true}}})
