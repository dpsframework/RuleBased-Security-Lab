(deffunction hanoi(?disco ?origen ?auxiliar ?destino) 
   (if (> ?disco 0) then 
       (hanoi  (- ?disco 1) ?origen ?destino ?auxiliar)
	   (printout t "Mover el disco: " ?disco " desde: " ?origen " hacia: " ?destino crlf)
	   (hanoi  (- ?disco 1) ?auxiliar ?origen ?destino)
	)
;;	(printout t "Listo !" crlf)
	(return TRUE)
)

(deffunction factorial(?n)
   (if (< ?n 2) then (return ?n)
    else (return (* (factorial (- ?n 1)) ?n))
   )
)

