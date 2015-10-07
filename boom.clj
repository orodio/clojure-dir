;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.

(defn sum [nums] (apply + nums))

(defn average [nums]
  (/ (sum nums) (count nums)))

(average [60 80])

(def person {:name "Sandra Cruz"
             :city "Portland, ME"})

(:city person)
(:name person)
(person :city)
(person :name)
(:city person)

(re-seq #"(\d+)-(\d+)" "1-3")

(defn silly-adder
  [x y]
  (+ x y))

(= [1 2 3] [1, 2, 3] [1, 2, 3,] [1 2, 3])

'(a b :name 12.5)      ;; list
['a 'b :name 12.5]     ;; vector
{:name "Chas" :age 31} ;; map
#{1 2 3}               ;; Set

*ns*
(ns foo)
*ns*

(do
  (println "hi")
  (apply + [4 5 6]))

(let [a (inc (rand-int 6))
      b (inc (rand-int 6))
      c (inc (rand-int 6))]
  (println (format "You rolled a %s, %s and a %s" a b c))
  (+ a b c))

(defn hypot
  [x y]
  (let [x2 (* x x)
        y2 (* y y)]
    (Math/sqrt (+ x2 y2))))

(hypot 3 5)

(def mrVector [42 "foo" 99.2 [5 12]])
(first mrVector)
(second mrVector)
(last mrVector)
(nth mrVector 2)
(mrVector 2)
(.get mrVector 2)
(+ (first mrVector) (mrVector 2))
(+ (first mrVector) (first (last mrVector)))

(let [x (nth mrVector 0)
      y (nth mrVector 1)
      z (nth mrVector 2)]
  (+ x z))

(let [[x y z] mrVector] (+ x z))
(let [[x _ _ [y z]] mrVector] (+ x y z))
(let [[x & rest] mrVector] rest)
(let [[x _ z :as original-vector] mrVector]
  (conj original-vector (+ x z)))

(def mrMap {:a 5 :b 6
            :c [7 8 9]
            :d {:e 10 :f 11}
            "foo" 88
            42 false})

(let [{a :a b :b} mrMap] (+ a b))
(let [{f "foo"} mrMap] (+ f 12))
(let [{v 42} mrMap] (if v 1 0))
(let [{x 3 y 8} [12 0 0 -18 44 6 0 0 1]] (+ x y))
(let [{{e :e} :d} mrMap] (* 2 e))
(let [{[x _ y] :c} mrMap] (+ x y))

(def map-in-vector ["James" {:birthday (java.util.Date. 88 9 21)}])
(let [[name {bd :birthday}] map-in-vector]
  (str name " was born on " bd))

(let [{r1 :x r2 :y :as randoms}
      (zipmap [:x :y :z] (repeatedly (partial rand-int 10)))]
  (assoc randoms :sum (+ r1 r2)))

(def chas {:name "Chas" :age 31 :location "Massachusetts"})
(let ({name :name age :age location :location} chas)
  (format "%s is %s years old and lives in %s." name age location))
(let [{:keys [name age location]} chas]
  (format "%s is %s years old and lives in %s." name age location))

(def brian {"name" "brian" "age" 31 "location" "bc"})
(let [{:strs [name age location]} brian]
  (format "%s is %s years old and lives in %s" name age location))

(def user-info ["robert8990" 2011 :name "Bob" :city "Boston"])
(let [[username account-year & extra-info] user-info
      {:keys [name city]} (apply hash-map extra-info)]
  (format "%s is in %s" name city))
(let [[username account & {:keys [name city]}] user-info]
  (format "%s is in %s" name city))

((fn [x] (+ 10 x)) 12)
(let [x 12] (+ 10 x))

((fn [x y z] (+ x y z)) 3 4 12)
(let [x 3
      y 4
      z 12]
  (+ x y z))

(def strange-adder (fn adder-self-reference
                     ([x]   (adder-self-reference x 1))
                     ([x y] (+ x y))))

(strange-adder 10)
(strange-adder 10 50)

(defn strange-adder-2
  ([x]   (strange-adder-2 x 1))
  ([x y] (+ x y)))

(strange-adder-2 10)
(strange-adder-2 10 50)

(defn concat-rest
  [x & rest]
  (apply str (butlast rest)))

(concat-rest 0 1 2 3 4)

(defn make-user
  [& [user-id]]
  {:user-id (or user-id
                (str (java.util.UUID/randomUUID)))})

(make-user)
(make-user "Booby")

;; (defn make-user-2
;;   [username & {:keys [email join-date] :or {join-date (java.util.Date.)}}]
;;   {:username username
;;    :join-date join-date
;;    :email email
;;    :exp-date (java.util.Date. (long (+ 2.592e9 (.getTime join-date))))})

























