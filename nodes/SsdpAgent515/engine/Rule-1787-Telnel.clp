(defrule Rule1787 "TELNET Rules" 
   (packet 
          (protocol tcp ) 
          (source_ipaddr $EXTERNAL_NET ) 
          (source_port any ) 
          (direction -> ) 
          (destination_ipaddr $TELNET_SERVERS ) 
          (destination_port 23 ) 
          (content "|A0 23 A0 10 AE 23 80 10 EE 23 BF EC 82 05 E0 D6 90|%|E0|") 
          (ID 1430 )
     ) 
   => 
     (printout t "Alert, TELNET Solaris memory mismanagement exploit attempt" crlf) 
) 
