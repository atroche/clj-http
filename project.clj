(defproject clj-http "4.0.0-SNAPSHOT"
  :description "A Clojure HTTP library wrapping the Apache HttpComponents client."
  :url "https://github.com/dakrone/clj-http/"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/mit-license.php"
            :distribution :repo}
  :global-vars {*warn-on-reflection* false}
  :min-lein-version "2.0.0"
  :exclusions [org.clojure/clojure]
  :dependencies [[org.apache.httpcomponents.core5/httpcore5 "5.0-beta2"]
                 [org.apache.httpcomponents.client5/httpclient5 "5.0-beta1"]
                 [org.apache.httpcomponents.client5/httpclient5-cache "5.0-beta1"]
                 [org.apache.httpcomponents/httpmime "4.5.5" :exclusions
                  [org.apache.httpcomponents/httpclient]]
                 [commons-codec "1.11"]
                 [commons-io "2.6"]
                 [potemkin "0.4.5"]]
  :resource-paths ["resources"]
  :profiles {:dev {:dependencies [;; optional deps
                                  [cheshire "5.8.0"]
                                  [crouton "0.1.2" :exclusions [[org.jsoup/jsoup]]]
                                  [org.jsoup/jsoup "1.11.3"]
                                  [org.clojure/tools.reader "1.2.2"]
                                  [com.cognitect/transit-clj "0.8.309"]
                                  [ring/ring-codec "1.1.1"]
                                  ;; other (testing) deps
                                  [org.clojure/clojure "1.9.0"]
                                  [org.clojure/tools.logging "0.4.0"]
                                  [ring/ring-jetty-adapter "1.6.3"
                                   :exclusions [[org.eclipse.jetty/jetty-server]]]
                                  [org.eclipse.jetty/jetty-server "9.4.9.v20180320"]
                                  [ring/ring-devel "1.6.3"]
                                  ;; caching example deps
                                  [org.clojure/core.cache "0.7.1"]
                                  ;; logging
                                  [org.apache.logging.log4j/log4j-api "2.11.0"]
                                  [org.apache.logging.log4j/log4j-core "2.11.0"]
                                  [org.apache.logging.log4j/log4j-1.2-api "2.11.0"]]
                   :plugins [[lein-ancient "0.6.15"]
                             [jonase/eastwood "0.2.5"]
                             [lein-kibit "0.1.5"]
                             [lein-nvd "0.5.2"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0"]]}}
  :aliases {"all" ["with-profile" "dev,1.7:dev,1.8:dev"]}
  :plugins [[codox "0.6.4"]]
  :test-selectors {:default  #(not (:integration %))
                   :integration :integration
                   :all (constantly true)})
