(defproject reagent-module "1.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.516"]
                 [reagent "0.8.1"]
                 [figwheel "0.5.18"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.18"]]

  :hooks [leiningen.cljsbuild]

  :resource-paths ["."]

  :clean-targets ^{:protect false} [:target-path "public/js" "js"]

  :profiles {:dev {:cljsbuild
                   {:builds {:client

                             {:source-paths ["src" "env/dev/cljs"]
                              :figwheel {:on-jsload "reagent-module.core/mount-root"
                                         :open-urls ["http://localhost:3449/index.html"]}
                              :compiler {:main "reagent-module.dev"
                                         :optimizations :none}}}}}

             :prod {:cljsbuild
                    {:builds {:client
                              {:source-paths ["src" "env/prod/cljs"]
                               :compiler {:main "reagent-module.prod"
                                          :optimizations :advanced
                                          :elide-asserts true
                                          :pretty-print false}}}}}}

  :figwheel {:repl false}

  :cljsbuild {:builds {:client
                       {:source-paths ["src"]
                        :compiler {:output-dir "js"
                                   :output-to "public/js/app.js"}}}})