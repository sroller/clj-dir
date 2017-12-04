(ns dir.core
  (:gen-class))

(defn directory [path]
  (clojure.java.io/file path))

(defn files [dir]
  (file-seq (directory dir)))

(defn -main
  [& args]
  (let [dir (or (first args) ".") pattern (or (second args) ".*")]
    (printf "dir=%s\n" dir)
    (doseq [file (filter #(re-find (re-pattern pattern) (.getPath %)) (files dir))]
      (if (.isDirectory file)
        (print " <DIR> ")
        (print "       "))

      (println (.getPath file)))))
