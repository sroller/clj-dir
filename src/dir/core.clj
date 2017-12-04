(ns dir.core
  (:gen-class))

(defn directory [path]
  (clojure.java.io/file path))

(defn files [dir]
  (file-seq (directory dir)))

(defn -main
  [& dir]
  (let [dir (or (first dir) ".")]
    (printf "dir=%s\n" dir)
    (doseq [file (files dir)]
      (if (.isDirectory file)
        (print " <DIR> ")
        (print "       "))

      (println (.getPath file)))))
