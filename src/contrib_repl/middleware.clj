(ns contrib-repl.middleware
  (:require [contrib-repl.manually :as contrib-repl]
            [clojure.tools.nrepl.middleware :refer [set-descriptor!]]))

(def add-contrib-deps-once
  (memoize
   (fn []
     (println "Adding contrib dependencies...")
     (contrib-repl/add-contrib-deps))))

(defn add-contrib-deps [h]
  (fn [{:keys [op file file-name file-path] :as msg}]
    (when (= op "clone")
      (add-contrib-deps-once))
    (h msg)))


