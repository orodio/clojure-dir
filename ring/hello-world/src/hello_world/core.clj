(ns hello-world.core)

(defn handler [req]
  {:status 200
   :header {"Content-Type" "text/html"}
   :body "hello world"})

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
