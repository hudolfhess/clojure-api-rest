(ns core.exceptions)


(defn product-does-not-exists [product-id]
  (str "Product #" product-id " does not exists."))
