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
  (println (:player-name player) ": mais cartas?")
  (= (read-line) "s"))

(defn dealer-decision-continue? [player-points dealer]
  (if (> player-points 21) false (<= (:points dealer) player-points)))

(defn game [player fn-decision-continue?]
  (if (fn-decision-continue? player)
    (let [player-with-more-cards (more-card player)]
      (card/print-player player-with-more-cards)
      (recur player-with-more-cards fn-decision-continue?))
    player))

(defn end-game-message [player dealer]
  (let [player-points (:points player)
        player-name (:player-name player)
        dealer-points (:points dealer)
        dealer-name (:player-name dealer)]
    (cond
      (and (> player-points 21) (> dealer-points 21)) "Ninguém ganhou :`( "
      (= player-points dealer-points) "Empateee :| "
      (> player-points 21) (str dealer-name " ganhou!!! :`( ")
      (> dealer-points 21) (str player-name " ganhouuu !!!! :D ")
      (> player-points dealer-points) (str player-name " ganhouuu !!!! :D ")
      (> dealer-points player-points) (str dealer-name " ganhou!!! :`( "))))

(defn end-game [player dealer]
  (card/print-player player)
  (card/print-player dealer)
 (println (end-game-message player dealer)))

(defn player-name-from-prompt []
  (println "Nome do jogador:")
  (read-line))

(def player-1 (player (player-name-from-prompt)))
(card/print-player player-1)

(def dealer (player "Dealer"))
(card/print-masked-player dealer)

(def player-after-game (game player-1 player-decision-continue?))
(def partial-dealer-continue? (partial dealer-decision-continue? (:points player-after-game)))
(def dealer-after-game (game dealer partial-dealer-continue?))
(end-game player-after-game dealer-after-game)
