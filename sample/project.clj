(defproject sample "0.0.0"
  :description "Sample project demonstrating contrib-repl nREPL middleware"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [contrib-repl "0.0.1"]]
  :repl-options {:nrepl-middleware [contrib-repl.middleware/add-contrib-deps]})
