# boot-lessc

Boot task for processing less files with autoprefixer and optionally clean-css

### Usage

This task shells out to the official lessc cli so make sure that is installed
on your system along with the autoprefix and clean-css plugins.

```bash
$ npm install -g lessc less-plugin-clean-css less-plugin-autoprefix
```

in build.boot
```clj
(set-env! :dependencies '[[mrmcc3/boot-lessc "0.1.0-SNAPSHOT"]])
(require '[mrmcc3.boot-lessc :refer [lessc]])

```

examples

```clj
;; convert all less input files that don't start with an undescore. autoprefix and compress
(lessc :compress true)

;; convert only the files specified
(lessc :files [#"\.less$"] :autoprefix "last 2 versions" :clean-css "--s1 --advanced --compatibility=ie8")
```

### LICENSE

Copyright © 2015 Michael McClintock

Distributed under the Eclipse Public License, the same as Clojure.
