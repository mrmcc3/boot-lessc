(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[mrmcc3/boot-lessc "0.1.0-SNAPSHOT"]])

(require '[mrmcc3.boot-lessc :refer [lessc]])
