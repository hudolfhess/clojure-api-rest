(defproject clojre-api-rest "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :plugins [[lein-ring "0.8.11"]]
  :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                   :creds :gpg}}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [liberator "0.14.1"]
                 [compojure "1.3.4"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-servlet "1.2.0-RC1"]
                 [org.clojure/java.jdbc "0.6.2-alpha2"]
                 [mysql/mysql-connector-java "6.0.3"]
                 [com.datomic/datomic-pro "0.9.5350"]]
  :ring {:handler api.main/handler}
)
