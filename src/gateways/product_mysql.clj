(ns gateways.product-mysql
  (:require [clojure.java.jdbc :as j]
            [config.database :as database]
            [core.exceptions :as core-exceptions]))

(defn get-product-by-id [product-id]
  (let [product (j/query database/mysql [(format "select * from product where id = %s" product-id)])]
  (if (= product [])
  (throw (Exception. (core-exceptions/product-does-not-exists product-id)))
  (first product))))

(defn get-all-products []
  (j/query database/mysql ["select * from product"]))

(defn insert-product [product]
  (j/insert! database/mysql :product product))

(defn update-product [product-id product]
  (j/update! database/mysql :product product ["id = ?" product-id]))

(defn delete-product [product-id]
  (j/delete! database/mysql :product ["id = ?" product-id]))
