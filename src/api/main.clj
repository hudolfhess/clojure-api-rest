(ns api.main
  (:require [liberator.core :refer [resource defresource]]
          [ring.middleware.params :refer [wrap-params]]
          [compojure.core :refer [defroutes ANY]]))

(defresource get-something [txt]
  :available-media-types ["text/plain"]
  :handle-ok (fn [_] (format "The text is %s" txt)))

(defresource main []
  :allowed-methods [:get]
  :available-media-types ["text/plain"]
  :handle-ok "Clojure API Rest")

(defroutes app
(ANY "/" [] (main))
(ANY "/get/:id" [id] (get-something id)))

(def handler
(-> app
    wrap-params))
