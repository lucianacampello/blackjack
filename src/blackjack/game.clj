(ns blackjack.game
  (:require [card-ascii-art.core :as card]))

(defn new-card []
  (inc (rand-int 13)))

(defn value-card-to-ten [card]
  (if (> card 9) 10 card))

(defn value-card-a-to-eleven [card]
  (if (= card 1) 11 card))

(defn points-cards [cards]
  (let [cards-updated-with-value-to-ten (map value-card-to-ten cards)
        cards-updated-with-value-to-eleven (map value-card-a-to-eleven cards-updated-with-value-to-ten)
        points-with-card-a-to-one (reduce + cards-updated-with-value-to-ten)
        ponts-with-card-a-to-eleven (reduce + cards-updated-with-value-to-eleven)]
    (if (> ponts-with-card-a-to-eleven 21) points-with-card-a-to-one ponts-with-card-a-to-eleven)))

(defn player [player-name]
  (let [cards [(new-card) (new-card)]
        points (points-cards cards)]
    {:player player-name
     :cards cards
     :points points}))

(card/print-player (player "Lu"))
(println (points-cards [1 10]))
(println (points-cards [1 5 7]))
