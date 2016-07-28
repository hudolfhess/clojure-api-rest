(ns api.main
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [api.routes :as api-routes]))

(def handler
  (-> api-routes/product
      wrap-params))
