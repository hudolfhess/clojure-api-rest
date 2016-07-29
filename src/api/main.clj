(ns api.main
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer  [wrap-keyword-params]]
            [api.routes :as api-routes]))

(def handler
  (-> api-routes/product
      wrap-keyword-params
      wrap-params))
