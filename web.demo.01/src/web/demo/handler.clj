(ns web.demo.handler
  (:use [web.demo.views])
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [hiccup.middleware :as hiccup]
            [ring.util.response :as ring]))

(defroutes app-routes
  (GET "/" [] "Hello World こんにちは 世界")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (hiccup/wrap-base-url)))
