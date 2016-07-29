(ns gateways.t-product-mysql
  (:use midje.sweet)
  (:require [gateways.product-mysql :as product-gateway]
            [core.exceptions :as core-exceptions]))

; @TODO using connection in config.database, same in development
;       need config a test database with rollback.

(def valid-product-id 2)
(def invalid-product-id 99)

(facts "About get-product-by-id"
  (fact "return product when product exists"
    (product-gateway/get-product-by-id valid-product-id)
      => {:id 2, :name "TV 60", :description "A big TV"})
  (fact "thrown an exception when product does not exists"
    (product-gateway/get-product-by-id invalid-product-id)
      => (throws Exception (core-exceptions/product-does-not-exists invalid-product-id))))
