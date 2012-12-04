(defproject rplevy/contrib-repl "0.1.0"
  :description "nREPL middleware / manual-use lib to add all contrib deps"
  :url "http://clojars.org/contrib-repl"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clj-http "0.5.8"]
                 [com.cemerick/pomegranate "0.0.13"]]
  :profiles {:dev {:dependencies [[midje "1.5-alpha2"]]}}
  :plugins [[lein-midje "2.0.3"]])
