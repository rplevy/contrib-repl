(ns contrib-repl.manually
  (:require [clj-http.client :as client]
            [cemerick.pomegranate :as pom]))

;; contrib project names from https://github.com/clojure
(def contrib-libraries
  ["tools.nrepl" "tools.trace" "tools.namespace" "tools.macro"
   "test.generative" "math.numeric-tower" "core.match" "core.logic"
   "data.priority-map" "core.contracts" "tools.cli" "java.jmx"
   "java.jdbc" "java.classpath" "data.xml" "data.json" "core.unify"
   "core.incubator" "core.cache" "algo.monads" "data.generators"
   "core.memoize" "math.combinatorics" "java.data" "tools.logging"
   "data.zip" "data.csv" "algo.generic" "data.codec"
   "data.finger-tree"])

(defn latest-version
  "use the Maven Central REST API to determine latest version of a library."
  [proj]
  (Thread/sleep 100)
  (-> "http://search.maven.org/solrsearch/select?q=%s&rows=1&wt=json"
      (format proj)
      (client/get {:as :json})
      :body :response :docs first :latestVersion))

(defn add-contrib-deps
  "look up the latest version of every contrib project in maven central,
   and add them as dependencies using pomegranate."
  ([] (add-contrib-deps contrib-libraries))
  ([project-names]
     (let []
       (pom/add-dependencies
        :coordinates (map (juxt (comp symbol (partial format "org.clojure/%s"))
                                latest-version)
                          project-names)))))
