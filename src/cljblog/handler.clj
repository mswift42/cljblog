(ns cljblog.handler
  (:use compojure.core hiccup.core hiccup.util)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(def page-header
  (html
   [:head [:title "this is the title"]]
   [:body
    [:p "some Text"]]))

(defroutes app-routes
  (GET "/" [] page-header)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))








