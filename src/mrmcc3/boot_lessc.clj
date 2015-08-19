(ns mrmcc3.boot-lessc
  (:require [boot.core :refer :all]
            [boot.util :refer [info dosh]]
            [clojure.java.io :as io]
            [clojure.string :refer [replace]]))

(deftask lessc
  [c compress bool "compress with clean-css"]
  (let [tmp (tmp-dir!)]
    (with-pre-wrap fileset
      (empty-dir! tmp)
      (info "\nProcessing less files...\n")
      (let [files (by-ext [".less"] (output-files fileset))]
        (doseq [f files]
          (let [in-file (tmp-file f)
                in-path (tmp-path f)
                out-path (replace in-path #"\.less$" ".css")
                out-file (doto (io/file tmp out-path)
                           (io/make-parents))]
            (info "• %s\n" in-path)
            (dosh "lessc"
                  "--autoprefix"
                  (if compress "--clean-css")
                  (.getPath in-file)
                  (.getPath out-file))))
        (-> fileset
            (add-resource tmp)
            (rm files)
            commit!)))))
