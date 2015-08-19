(def +project+ 'mrmcc3/boot-lessc)
(def +version+ "0.1.0-SNAPSHOT")

(set-env!
  :project +project+
  :version +version+
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.7.0" :scope "provided"]
                  [boot/core "2.2.0" :scope "provided"]
                  [adzerk/bootlaces "0.1.11" :scope "test"]])

(require '[adzerk.bootlaces :refer :all])

(bootlaces! +version+)

(task-options!
  pom {:project     +project+
       :version     +version+
       :description "Boot task for converting less files to css with autoprefixes and minification"
       :url         "https://github.com/mrmcc3/boot-lessc"
       :scm         {:url "https://github.com/mrmcc3/boot-lessc"}
       :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})
