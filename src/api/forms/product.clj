(ns api.forms.product
  (:require [schema.core :as s]))

(def product-form
  {:name s/Str
   :description s/Str})

(defn validate-product [data]
  (s/validate
    product-form
    data))
