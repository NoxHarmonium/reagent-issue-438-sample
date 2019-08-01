(ns ^:figwheel-no-load reagent-module.dev
  (:require
    [reagent-module.core :as core]))

(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

(enable-console-print!)

(core/init!)
