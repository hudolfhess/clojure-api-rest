(ns api.main
  (:require [liberator.core :refer [resource defresource]]
          [ring.middleware.params :refer [wrap-params]]
          [compojure.core :refer [defroutes ANY]]
          [clojure.java.jdbc :as j]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/clojure_api_rest"
               :user "root"
               :password "password"
               :serverTimezone "America/Sao_Paulo"})

(defresource get-something [txt]
  :available-media-types ["text/plain"]
  :handle-ok (fn [_] (format "The text is %s" txt)))

(defresource main []
  :allowed-methods [:get]
  :available-media-types ["application/json"]
  :handle-ok (j/query mysql-db ["select * from product"]))

(defroutes app
(ANY "/" [] (main))
(ANY "/get/:id" [id] (get-something id)))

(def handler
(-> app
    wrap-params))
