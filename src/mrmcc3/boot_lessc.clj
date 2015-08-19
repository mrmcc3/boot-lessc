(ns mrmcc3.boot-lessc
  (:require [boot.core :refer :all]
            [boot.util :refer [info dosh]]
            [clojure.java.io :as io]
            [clojure.string :as s]))

(deftask lessc
  "boot task for converting less to css with autoprefixes and minification."
  [c compress bool "compress with clean-css"]
  (let [tmp (tmp-dir!)]
    (with-pre-wrap fileset
      (empty-dir! tmp)
      (info "\nProcessing less files...\n")
      (let [files (by-ext [".less"] (output-files fileset))
            include-path (->> (input-dirs fileset)
                              (map #(.getPath %))
                              (s/join ":"))]
        (doseq [f files]
          (let [in-file (tmp-file f)
                in-path (tmp-path f)
                out-path (s/replace in-path #"\.less$" ".css")
                out-file (doto (io/file tmp out-path)
                           (io/make-parents))]
            (info " • %s\n" in-path)
            (dosh "lessc"
                  (str "--include-path=" include-path)
                  "--autoprefix"                            ;; TODO: allow user to pass options
                  (if compress "--clean-css")               ;; TODO: allow user to pass options
                  (.getPath in-file)
                  (.getPath out-file))))
        (-> fileset
            (add-resource tmp)
            (rm files)
            commit!)))))
