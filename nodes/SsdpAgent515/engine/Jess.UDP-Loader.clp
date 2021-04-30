(defrule Rule1802 "TFTP Rules"
     (packet (protocol udp ) 
     (source_ipaddr any ) 
     (source_port any ) 
     (direction -> ) 
     (destination_ipaddr any ) 
     (destination_port 69 ) 
     (content "|00 01|") 
     (ID 1941 )
) =>
     (printout t "Alert, TFTP GET filename overflow attempt" crlf)
)