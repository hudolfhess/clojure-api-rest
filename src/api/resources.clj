(ns api.resources
  (:require [liberator.core :refer [resource defresource]]
            [clojure.java.jdbc :as j]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/clojure_api_rest"
               :user "root"
               :password "password"
               :serverTimezone "America/Sao_Paulo"})

(defresource product []
  :allowed-methods [:get]
  :available-media-types ["application/json"]
  :handle-ok (j/query mysql-db ["select * from product"]))

(defresource post-product []
  :allowed-methods [:post]
  :available-media-types ["application/json"]
  :post! (fn [context] (
      let [params (get-in context [:request :params])]
      (j/insert! mysql-db :product params)
    ))
  :handle-created [{:success true}])

(defresource product-handler [product-id]
  :allowed-methods [:get :put :delete]
  :available-media-types ["application/json"]
  :handle-ok (fn [_] (j/query mysql-db [(format "select * from product where id = %s" product-id)])))
