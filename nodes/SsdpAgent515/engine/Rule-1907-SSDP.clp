(defrule Rule1907 "SSDP Rules"
  (packet 
     (protocol ssdp ) 
     (source_ipaddr any ) 
     (source_port any ) 
     (direction -> ) 
     (destination_ipaddr any ) 
     (destination_port 169 ) 
     (content "|00 01 75 a0 21 46 78|") 
     (ID 2023 )
     (dateID any) (recordID any)
  ) 
=>
  (assert 
    (detailed_report 
       (header         "Alert, TFTP GET filename overflow attempt")
       (datagramDate   (packet (dateID)   ))
       (datagramID     (packet (redordID) ))        
    )
  )
)
