(ns  pycloj-torch-examples.core
  "Constrains the weights to be non-negative."
  (:require [torch]
            [libpython-clj.python :as py]))

(defonce torch (py/import-module "torch"))
(defonce np (py/import-module "numpy"))

(defmacro def+
  "binding => binding-form
  internalizes binding-forms as if by def.
  See http://clojuredocs.org/clojure.core/destructure ."
  {:added "1.9", :special-form true, :forms '[(def+ [bindings*])]}
  [& bindings]
  (let [bings (partition 2 (destructure bindings))]
    (sequence cat
              ['(do)
               (map (fn [[var value]] `(def ~var ~value)) bings)
               [(mapv (fn [[var _]] (str var)) bings)]])))



