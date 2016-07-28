(ns api.routes
  (:require [compojure.core :refer [defroutes ANY]]
            [api.resources :as r]))

(defroutes product
  (ANY "/product/" [] (r/product))
  (ANY "/product/:id" [id] (r/product-handler id))
)
