// Revised:   2021.04.28                               
//            [ RuleBased-Security-Lab example ]
// 

import jade.content.*;
import jade.content.onto.basic.Action;

import jade.content.onto.BasicOntology;
import jade.content.onto.BeanOntology;
import jade.content.onto.BeanOntologyException;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyUtils;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;

import jade.core.CaseInsensitiveString;

import jade.domain.FIPANames;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import jade.util.leap.Serializable;
import jade.util.leap.ArrayList;

import jade.core.*;
import jade.core.behaviours.*;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.CyclicBehaviour;

import com.dpsframework.domain;

import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.Router;
import com.dpsframework.core.engines.*;
import java.util.Date;
import java.lang.System.*;



/**
* How to use this:
* 
* Big-Banner: phaseBanner( "Long text" );
* Next step : question   = "Visibility of Action Class";
* Answer    : answer     = (  evaluation ) ?  AFIRMATIVO : NEGATIVO ;
* Results   : resultBanner( question, answer );
* Next step : question   = "Visibility of Action Class";
* 
* @author faguayo (UniLeon)
* 
*/

phaseBanner( "Class visibility ...Pcap Buffer TCPPacket UDPPacket Protocol." );

  import io.pkts.PacketHandler;
  import io.pkts.Pcap;
  import io.pkts.buffer.Buffer;
  import io.pkts.packet.Packet;
  import io.pkts.packet.TCPPacket;
  import io.pkts.packet.UDPPacket;
  import io.pkts.protocol.Protocol;	

  question  = ".PCAP - PacketHandler  Class"; 
  answer 	= (  getClass( "PacketHandler" ).getName().equals("io.pkts.PacketHandler") ) ?  AFIRMATIVO : NEGATIVO ;
  resultBanner( question, answer );

  question  = ".PCAP - Reader .pcap Class"; 
  answer 	= (  getClass( "Pcap" ).getName().equals("io.pkts.Pcap") ) ?  AFIRMATIVO : NEGATIVO ;
  resultBanner( question, answer );


  question  = "Apertura de atHome.pcap"; 
	private String ORIGIN_DIR = myNode .frameworkVarPath + "pending/";
	private String TARGET_DIR = myNode .nodeVarPath      + "processed/";
	//pcap    = Pcap.openStream( frameworkVarPath + "repo/" + "atHome.pcap");
	pcap    = Pcap.openStream( frameworkVarPath + "repo/" + "chargen-udp.pcap");
    answer  = (  pcap != null ) ?  AFIRMATIVO : NEGATIVO ;
    resultBanner( question, answer );

  
  
    //  f = new File(relativeConfigPath + "solo-pcap.pcap"); 
    //   <nodes\WatchdogAgent201\config\solo-pcap.pcap>

	// pcap = Pcap.openStream(relativeConfigPath + "solo-pcap.pcap");
	
	if (answer == AFIRMATIVO){
		  question  = "Filtrado por protocolo UDP del archivo .pcap"; 
		  resultBanner( question, answer );


//  		if (packet.hasProtocol(Protocol.TCP))	{
//			TCPPacket tcpPacket = (TCPPacket) packet.getPacket(Protocol.TCP);
//           Buffer buffer = tcpPacket.getPayload();
//              if (buffer != null) 
//              {
//                  System.out.println("TCP: " + buffer);
//              }
//        } else 		  
		  
		  
	      pcap.loop(new PacketHandler()       {
	        	boolean nextPacket(Packet packet) throws IOException {

	                  if (packet.hasProtocol(Protocol.UDP)) {

	                        UDPPacket udpPacket = (UDPPacket) packet.getPacket(Protocol.UDP);
	                        Buffer buffer = udpPacket.getPayload();
	                        if (buffer != null) {
	                        	bb = buffer.getArray();
	                        	System.out.println("\nUDP_________________:\n" + buffer +"\n");
	                        	for( b : bb){
	                        		System.out.print( b + " ");
	                        	}
	                        	
	                        	// jconsole.print("\nUDP: " + buffer);
	                        	// jconsole.print("\n");
	                        }
	                  }
	                  return true;
	                }
	            });		
		
	}
	
	pcap.close();




	question = "Defining the Function transformPCAP... ";
    answer  =   AFIRMATIVO  ;
    resultBanner( question, answer );
	datagram = null;
	
	String ORIGIN_DIR = myNode .frameworkVarPath + "pending/";
	String TARGET_DIR = myNode .nodeVarPath      + "processed/";
	//# -----------------------------------------
    //# Transform .PCAP files into FATCS files
	//# -----------------------------------------
	String transformPCAP( String fileName ){ 
		datagram   = new StringBuilder();
		file = new File(  TARGET_DIR + fileName  );

		if ( fileName == null  ) { return null;  };
		if ( !file.exists()    ) {  return null; };
		
		
		pcapfile   = Pcap.openStream( file );

		pcapfile.loop(new PacketHandler()       {
	        boolean nextPacket(Packet packet) throws IOException {
	        	if (packet.hasProtocol(Protocol.UDP)) {
	        		
	        		UDPPacket udpPacket = (UDPPacket) packet.getPacket(Protocol.UDP);
	                Buffer buffer = udpPacket.getPayload();
	                if (buffer != null) {
	                	//datagram.append( "\n[");
	                	datagram.append( buffer .toString() );
	                	//datagram.append( "]\n";)
	                	outLogger(new Object[] { "\nUDP: " + buffer } );
	                }
	            }
	            
	        }
	        
	    });
		pcapfile.close();
	    return datagram;
	}
//	
//	question = "Function transformPCAP defined";
//    answer  =   AFIRMATIVO  ;
//    resultBanner( question, answer );
//
//    sb = transformPCAP( 	"atHome.pcap"  );

    question = "Function transformPCAP called";
    answer  =   AFIRMATIVO  ;
    resultBanner( question, answer );
	jconsole.print( datagram );
	
	
	
	
	
	
	phaseBanner( "Agents of DpsFramework - RuleBased-Security-Lab" );
	
	// Next step..................................................:
	question   = "List of trusted Agents"; 
	resultBanner( question, answer );


	String streamAgentsTrusted = myNode.nodeName + " (Itself)," 
		                + myNode.sFrameworkNodeSerie + "," 
		                + myNode.sNameOfTicketBoard + " (Ticket's Service)";
	
	String[] values    = streamAgentsTrusted.split(",");  
	String itSelfAgent = values[0];
	
	answer = ( streamAgentsTrusted != null  ) ?  AFIRMATIVO : NEGATIVO ;
	resultBanner( question, answer );
	
	question   = "List of trusted Agents"; 
	resultBanner( question, answer );
	println(" Lista de agentes: " + streamAgentsTrusted );

	question   = "List of trusted Agents"; 
	resultBanner( question, answer );
	println(" Este agente: : " + itSelfAgent );

	question   = "List of trusted Agents"; 
	resultBanner( question, answer );
	println(" Este agente filtrado: " + itSelfAgent.split(" ")[0] );

	println();
	print(values);
	
	
	

