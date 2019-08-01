(ns reagent-module.core
  (:require
   [reagent.core :as r]))

;; -------------------------
;; Views

(defn home-page [counter]
  [:div
   [:h2 "Welcome to Reagent"]
   [:p "The counter below should be incrementing every 100ms."]
   [:p @counter]
   [:p "If loaded as part of a Firefox browser extension it will not work"]
   [:div
    [:p "See: "]
    [:a {:href "https://github.com/reagent-project/reagent/issues/438"} 
     "https://github.com/reagent-project/reagent/issues/438"]]])

;; -------------------------
;; Initialize app

(defn ^:export mount-root [element]
  (let [counter (r/atom -1)]
    (js/setInterval #(reset! counter (.getTime (js/Date.))) 100)
    (r/render [home-page counter] element)))

; Should only run in dev builds
(defn init! []
  (mount-root (.getElementById js/document "app")))

; Should only run in dev builds
(defn init-prod! []
  (let [body-el (.querySelector js/document "body")
        first-child (aget body-el "firstElementChild")]
    (println "Mounting to first child of body")
    (js/console.dir first-child)
    (mount-root first-child)))

