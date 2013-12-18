(ns cljblog.handler
  (:use compojure.core hiccup.core hiccup.util hiccup.page)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defn page-header
  "return html-string for header of html file
   with entered title"
  [title]
  (html
   [:head
    [:title title]
    (include-js "http://code.jquery.com/jquery-latest.min.js")
    (include-css "/blog.css")]))

(def newpost-page-body
  (html5
   [:body
    [:h2 {:class "header"} "Enter a new Post."]
    [:div {:class "wholeform"}
     [:form {:method "post"}
      [:div {:class "tinput"}
       
       [:input {:type "text" :class "tarea" :name "text"}]]
      [:div {:class "tinput"}
       [:textarea {:class "tarea" :name "tarea" :rows "30" }]]
      [:div {:class "button"}
       [:input {:type "submit" :text "submit"}]]]]]))

(def newpost-page
  (apply str (page-header "New post") newpost-page-body))

 

(defroutes app-routes
  (GET "/" [] newpost-page)
  (route/resources "/")
  (route/not-found "Not Found")
  (POST "/newpost" [] newpost-page)
  (GET "/newpost" [] newpost-page)
  (route/resources "/newpost"))

(def app
  (handler/site app-routes))








