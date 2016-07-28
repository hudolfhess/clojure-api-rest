(ns api.resources
  (:require [liberator.core :refer [resource defresource]]
            [clojure.java.jdbc :as j]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/clojure_api_rest"
               :user "root"
               :password "password"
               :serverTimezone "America/Sao_Paulo"})

(defresource product-list []
  :allowed-methods [:get]
  :available-media-types ["application/json"]
  :handle-ok (j/query mysql-db ["select * from product"]))

(defresource product-get [product-id]
  :allowed-methods [:get]
  :available-media-types ["application/json"]
  :handle-ok (fn [_] (j/query mysql-db [(format "select * from product where id = %s" product-id)])))

(defresource product-create []
  :allowed-methods [:post]
  :available-media-types ["application/json"]
  :post! (fn [context] (
      let [params (get-in context [:request :params])]
      (j/insert! mysql-db :product params)
    ))
  :handle-created [{:success true}])

(defresource product-edit [product-id]
  :allowed-methods [:put]
  :available-media-types ["application/json"]
  :put! (fn [context] (
      let [params (get-in context [:request :params])]
      (j/update! mysql-db :product params ["id = ?" product-id])
    ))
  :handle-created [{:success true :product product-id}])
