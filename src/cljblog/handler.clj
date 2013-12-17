(ns cljblog.handler
  (:use compojure.core hiccup.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] some-text)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(def some-text
  (hiccup.core/html [:div
         [:p "nad moo"]]))
