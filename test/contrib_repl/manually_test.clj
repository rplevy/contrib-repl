(ns contrib-repl.manually-test
  (:require [contrib-repl.manually :as base]
            [clj-http.client :as client]
            [midje.sweet :refer :all]))

(fact
 "about adding contrib deps"
 (base/add-contrib-deps ["data.zip"])
 => (contains {'[org.clojure/data.zip "0.1.1"] anything})
 (provided
  (client/get irrelevant {:as :json})
  =>
  {:body {:response {:docs [{:latestVersion "0.1.1"}]}}}))
