# boot-lessc

A boot task for processing less files. This task shells out to the official lessc compiler.
To get autoprefixes and minification the autoprefix and clean-css less plugins are used.
These all need to be installed on your system.

```bash
$ npm install -g less less-plugin-clean-css less-plugin-autoprefix
```

### Usage

in build.boot
```clj
(set-env! :dependencies '[[mrmcc3/boot-lessc "0.1.0-SNAPSHOT"]])
(require '[mrmcc3.boot-lessc :refer [lessc]])
```

the `lessc` task will convert all **output** less files to css. To keep imported less files
from themselves being processed put them under a source path. You can import relative to
input directories (source and resource). See the examples folder for a simple example.

### LICENSE

Copyright © 2015 Michael McClintock

Distributed under the Eclipse Public License, the same as Clojure.
