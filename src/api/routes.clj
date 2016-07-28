(ns api.routes
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE]]
            [api.resources :as r]))

(defroutes product
  (GET "/product/" [] (r/product-list))
  (GET "/product/:id" [id] (r/product-get id))
  (POST "/product/" [] (r/product-create))
  (PUT "/product/:id" [id] (r/product-edit id))
  (DELETE "/product/:id" [id] (r/product-delete id))
)
