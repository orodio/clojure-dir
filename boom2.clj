;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.

(fn [x y] (Math/pow x y))

#(Math/pow %1 %2)

(fn [x y]
   (println (str x \^ y))
   (Math/pow x y))

#(do (println (str %1 \^ %2))
     (Math/pow %1 %2))

(fn [x & rest]
  (- x (apply + rest)))

#(- % (apply + %&))

(loop [x 5]
  (if (neg? x)
      x
      (recur (dec x))))

(defn countdown [x]
  (if (zero? x)
      :blastoff!
      (do (println x)
          (recur (dec x)))))

(countdown 5)

