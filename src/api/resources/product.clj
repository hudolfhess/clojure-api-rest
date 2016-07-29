(ns api.resources.product
  (:require [liberator.core :refer [resource defresource]]
            [gateways.product-mysql :as product-gateway]
            [api.forms.product :as product-form]
            [utils.resources :as utils-resources]))

(defresource product-list []
  :allowed-methods [:get]
  :available-media-types ["application/json"]
  :handle-ok (product-gateway/get-all-products))

(defresource product-get [product-id]
  :allowed-methods [:get]
  :available-media-types ["application/json"]
  ;; http-status not correct when returns error message
  :handle-ok (try
    (product-gateway/get-product-by-id product-id)
  (catch Exception e {:error (.getMessage e)})))

(defresource product-create []
  :allowed-methods [:post]
  :available-media-types ["application/json"]
  :malformed? (fn [context] (utils-resources/is-malformed-request? product-form/validate-product context))
  :post! (fn [context] (
      let [params (get-in context [:request :params])]
      (product-gateway/insert-product params)))
  :handle-created [{:success true}]
  :handle-malformed [{:success false :error "Bad request"}])

(defresource product-edit [product-id]
  :allowed-methods [:put]
  :available-media-types ["application/json"]
  :malformed? (fn [context] (utils-resources/is-malformed-request? product-form/validate-product context))
  :put! (fn [context] (
      let [params (get-in context [:request :params])]
      (product-gateway/update-product product-id params)
    ))
  :handle-created [{:success true :product product-id}]
  :handle-malformed [{:success false :error "Bad request"}])

(defresource product-delete [product-id]
  :allowed-methods [:delete]
  :available-media-types ["application/json"]
  :delete! (product-gateway/delete-product product-id)
  :respond-with-entity? true
  :handle-ok [{:success true :product product-id}])
