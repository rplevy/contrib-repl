# contrib-repl

nREPL middleware to look up the latest versions of all Clojure contrib libraries
and add them as dependencies. Can also be used manually in an already-running
REPL.

## Usage

###Option A. Use as nREPL middleware

Edit project.clj:

```clojure
  :dependencies [[contrib-repl "0.1.0"]]
  :repl-options {:nrepl-middleware [contrib-repl.middleware/add-contrib-deps]}
```

Then run ```lein repl``` to enter a repl with all contrib dependencies added.

###Option B. Invoke from an already running REPL

In a REPL session:

```clojure
(require '[cemerick.pomegranate :as pom])
(pom/add-dependencies :coordinates '[[contrib-repl "0.1.0"]]
                      :repositories {"clojars" "http://clojars.org/repo"})
(require '[contrib-repl.manually :refer [add-contrib-deps]])
(add-contrib-deps) ; add all of the contrib libraries

You can also add just a subset of the contrib libraries:

(add-contrib-deps ["tools.nrepl" "core.match"]) ; only add these libraries
```

## License

Copyright © 2012 Robert P. Levy (@rplevy)

Distributed under the Eclipse Public License, the same as Clojure.
