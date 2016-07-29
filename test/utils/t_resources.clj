(ns utils.t-resources
  (:use midje.sweet)
  (:require [utils.resources :as utils-resources]
            [api.forms.product :as product-form]))

(def valid-context-with-product {:request {:params {:name "Teste" :description "Teste"}}})
(def invalid-context {})

(facts "Verify if is malformed request"
  (fact "Return false when params in context is valid"
    (utils-resources/is-malformed-request?
      product-form/validate-product valid-context-with-product) => false)
  (fact "Return true when invalid context"
    (utils-resources/is-malformed-request?
      product-form/validate-product invalid-context) => true))
