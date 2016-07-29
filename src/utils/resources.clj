(ns utils.resources)

(defn is-malformed-request? [validator context]
  (try
    (let [params (get-in context [:request :params])]
    (validator params)
    false)
  (catch Exception e
    true
    )))
