(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(println "Cleanliness is next to godliness")

(println "woot")

(def robot (atom {:x 0 :y 0 :heading :north}))

(defn report [rb] 
  (let [{x :x y :y h :heading} @rb] 
    (println x y h)))


(println "==================")
(report robot)
