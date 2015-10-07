(ns om-tut.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [cljs.core.async :refer [put! chan <!]]))

(enable-console-print!)

(def app-state
  (atom {:contacts [
                    {:first "Ben" :last "Bitdiddle" :email "Rawr"}
                    {:first "Alyssa" :middle-initial "P" :last "Heacker" :email "woot"}
                    {:first "Eva" :middle "Lu" :last "Ator" :email "bang"}
                    {:first "Cy" :last "Reasoner" :email "mit"}
                    {:first "Louis" :middle-initial "D" :last "Effect" :email "wow"}
                    {:first "Lem" :middle-initial "E" :last "Tweakit" :email "much"}]}))

(defn middle-name [{:keys [middle middle-initial]}]
  (cond
   middle (str " " middle)
   middle-initial (str " " middle-initial ".")))

(defn display-name [{:keys [first last] :as contact}]
  (str last ", " first (middle-name contact)))

(defn contact-view [contact owner]
  (reify
    om/IRender
    (render [this]
            (dom/li nil
                    (dom/span nil (display-name contact))
                    (dom/button nil "Delete")))))

(defn contacts-view [app owner]
  (reify om/IRender
         (render [this]
            (dom/div
              nil
              (dom/h2 nil "Contact List")
              (apply dom/ul
                     nil
                     (om/build-all contact-view (:contacts app)))))))


(def woot-state (atom {:text "Hooray!!"}))

(defn wootComp [app owner] (dom/div nil (:text app)))

(om/root
  (fn [app owner] (om/component (dom/h1 nil (:text app))))
  woot-state
  {:target (. js/document (getElementById "contacts"))})

(swap! woot-state assoc :text "Boom")
(swap! woot-state assoc :text "Rawr")
(swap! woot-state assoc :text "OMG!!")



