;; Least Common Multiple - Easy
;; Write a function which calculates the <a href="http://en.wikipedia.org/wiki/Least_common_multiple">least common multiple</a>.  Your function should accept a variable number of positive integers or ratios. 
;; tags - math
;; restricted - 
(ns offline-4clojure.p100
  (:use clojure.test)
  (:require [clojure.set :refer :all]))

; (let [divisors (fn [n]
;                  (for [x (range 1 (inc n)) :while (<= x n) :when (= 0 (mod n x))] x))
;       gcd (fn [& args]
;             (apply max (apply intersection (map (comp set divisors) args)))          ) 
;       ]
;   (divisors 1/3))


; (take 5 (rest (map (partial * 3) (iterate inc 0))))

; (take 5 (map #(* 2) (iterate 1)))

(let [multiples (fn [x]
                      (map (partial * x) (iterate inc 2)))]
  (take 4 (multiples 4))
  )


(def __
;; your solution here
  (fn [& args]
    (let [multiples (fn [x]
                      (map (partial * x) (iterate inc 1)))]
      (loop [i 1]
        (let [multiple-sets (map #(set (take i (multiples %))) args)
              lcm (apply intersection multiple-sets)]
          (if (not-empty lcm)
            (first  lcm)
            (recur (inc i))))))))

(defn -main []
  (are [soln] soln
(== (__ 2 3) 6)
(== (__ 5 3 7) 105)
(== (__ 1/3 2/5) 2)
; (== (__ 3/4 1/6) 3/2)
; (== (__ 7 5/7 2 3/5) 210)
))
