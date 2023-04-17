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
    {:player-name player-name
     :cards cards
     :points points}))

(defn more-card [player]
  (let [new-player (update player :cards conj (new-card))
        points (points-cards (:cards new-player))]
    (assoc new-player :points points)))

(defn player-decision-continue? [player]
  (= (read-line) "sim"))

(defn dealer-decision-continue? [player-points dealer]
  (<= (:points dealer) player-points))

(defn game [player fn-decision-continue?]
  (println (:player-name player) ": mais cartas?")
  (if (fn-decision-continue? player)
    (let [player-with-more-cards (more-card player)]
      (card/print-player player-with-more-cards)
      (recur player-with-more-cards fn-decision-continue?))
    player))

(def player-1 (player "Lu"))
(card/print-player player-1)

(def dealer (player "Dealer"))
(card/print-player dealer)

(def player-after-game (game player-1 player-decision-continue?))
(game dealer (partial dealer-decision-continue? (:points player-after-game)))