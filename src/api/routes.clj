(ns api.routes
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE]]
            [api.resources.product :as product]))

(defroutes product
  (GET "/product/" [] (product/product-list))
  (GET "/product/:id" [id] (product/product-get id))
  (POST "/product/" [] (product/product-create))
  (PUT "/product/:id" [id] (product/product-edit id))
  (DELETE "/product/:id" [id] (product/product-delete id))
)
