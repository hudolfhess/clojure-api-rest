(ns api.routes
  (:require [compojure.core :refer [defroutes ANY GET POST]]
            [api.resources :as r]))

(defroutes product
  (GET "/product/" [] (r/product))
  (POST "/product/" [] (r/post-product))
  (ANY "/product/:id" [id] (r/product-handler id))
)
