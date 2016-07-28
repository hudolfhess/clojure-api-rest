(defproject clojre-api-rest "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :plugins [[lein-ring "0.8.11"]]
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [liberator "0.14.1"]
                 [compojure "1.3.4"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-servlet "1.2.0-RC1"]]
  :ring {:handler api.main/handler}
)
