//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//# ---------------------------------------------

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
import jade.core.behaviours.TickerBehaviour;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import com.dpsframework.domain;
import java.util.Date;
import java.lang.System.*;

import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.Packet;
import io.pkts.packet.TCPPacket;
import io.pkts.packet.UDPPacket;
import io.pkts.protocol.Protocol;	



import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPANames;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

import javax.swing.ImageIcon;

import org.apache.commons.codec.binary.Base64;

import bsh.EvalError;
import bsh.Interpreter;
import bsh.util.NameCompletionTable;

import com.dpsframework.core.behaviour.MIABMessageProposer;
import com.dpsframework.domain.ProblemSolversOntology;
import com.dpsframework.domain.Repl;
import com.dpsframework.util.JadeConsole;
import com.dpsframework.util.PsConstants;
import com.dpsframework.util.PsServices;



//# ---------------------------------------------
//# Class WatchdogPCAP
//#
//# @author: Aguayo,FJ. et al.  SECOMUCI.2021-04
//# ---------------------------------------------
class WatchdogPCAP  extends TickerBehaviour  {
	
	private Agent theAgent;
	private int periods; 

	
    //# Pseudo-Static final on BeanShell. 
	//# -----------------------------------------
	private String ORIGIN_DIR = myNode .frameworkVarPath + "pending/"  ;
	private String TARGET_DIR = myNode .nodeVarPath      + "processed/";
	
	
	//# -----------------------------------------
    //# Internal class behaviour Logger 
	//# -----------------------------------------
	private void outLogger(Object[] o){
		if   ( o.length == 0) 	{ return; }
		String bName = getBehaviourName();
		String aName = theAgent.getLocalName();
		String mf2 = " " + (bName + "         ").substring(0, 9) + ": ["+ aName+"]";	
		int  n = o.length;  
		for (int i = 0; i < n; i++ ){	mf2 += " {" + i +"}"; }  
		Logger.println(MessageFormat.format(mf2,o));
		return;
	}


	//# -----------------------------------------
    //# Search for new .PCAP files on ORIGIN_DIR 
	//# -----------------------------------------
	private String searchForPCAP( String onPlace ){
		pendingFile = null;
		String[] pendingFiles = new File( onPlace ).list();
		
		if( pendingFiles != null ){
			if(  pendingFiles.length >= 1 ){
				for(int i=0; i < pendingFiles.length; i++ ){
					if( pendingFiles[i].endsWith(".pcap") ){
						pendingFile =  pendingFiles[i];
						outLogger(new Object[] { 
								"It is trying to move into your workspace ", pendingFile } );
					}
				}
			}	
		}
			
		if( pendingFile != null ){
			File fileFrom = new File( onPlace    + pendingFile);
			File fileTo   = new File( TARGET_DIR + pendingFile );
			  
			if(fileFrom.renameTo(fileTo)){
				outLogger(new Object[] { "The agent just moved file : ", pendingFile } );
			    return pendingFile;			      
			} else {
				outLogger(new Object[] { "The file : ", pendingFile , " From: "+
				    onPlace , " has already been processed."} );
				return null;				
			  }			
		}			
		return null;	
	}
	
	
	//# -----------------------------------------
    //# Transform .PCAP files into FATCS files
	//# -----------------------------------------
	private String transformPCAP( String fileName ){ 
		if ( fileName == null  ) { return null; }
		file = new File(  TARGET_DIR + fileName  );		
		if ( !file.exists()  ) { return null; }
		
		
		String datagram   = "";		
		pcapfile   = Pcap.openStream(  TARGET_DIR + fileName );

	    pcapfile.loop(new PacketHandler()       {
	        	boolean nextPacket(Packet packet) throws IOException {
	
	                  if (packet.hasProtocol(Protocol.UDP)) {
	
	                        UDPPacket udpPacket = (UDPPacket) packet.getPacket(Protocol.UDP);
	                        Buffer buffer = udpPacket.getPayload();
	                        if (buffer != null) {
	                        	datagram += "[";
	                        	outLogger(new Object[] { "\nUDP: " + buffer.toString() } );
	                        	outLogger(new Object[] { "\nSeparacion por: " + buffer.toString().split(":") } );
	                        	datagram += buffer.toString() + "]\n";
	                        }
	                  }
	                  return true;
	                }
	            });	
	      
//		pcapfile.loop(new PacketHandler()       {
//	        boolean nextPacket(Packet packet) throws IOException {
//	        	if (packet.hasProtocol(Protocol.UDP)) {
//	        		
//	        		UDPPacket udpPacket = (UDPPacket) packet.getPacket(Protocol.UDP);
//	                Buffer buffer = udpPacket.getPayload();
//	                if (buffer != null) {
//	                	datagram.append( "\n[");
//	                	datagram.append( buffer .toString() );
//	                	datagram.append( "]\n";)
//	                	outLogger(new Object[] { "\nUDP: " + buffer } );
//	                }
//	            }
//	            
//	        }
//	        
//	    });
		pcapfile.close();
		outLogger(new Object[] { "UDP------------------:\n " + datagram } );
	    return datagram;
	}
	
	
	
	
	//# -----------------------------------------
    //# Make message to NIDsBoardAgent Blackboard 
	//# -----------------------------------------
	private ACLMessage makeACL_FACTS( String data ){
		if( data == null ){ return null; }
		
		bundle = new ACLMessage();
		outLogger(new Object[] { "El mensaje es: " , bundle } );
		return bundle;
	    	
	}
	
	
	
	
	
	
	//# -----------------------------------------
    //# Behaviour - Class 
	//# -----------------------------------------
	public WatchdogPCAP( Agent a,  long t, int p ) {
		super( a, (Long)t );		
		theAgent = a; 
		periods = p;
	}
	
	
	protected void onTick()  {
		if ( getTickCount() > periods ) {	
			stop();				
			
		} else {		
			outLogger(new Object[] { "Current period: " , getTickCount() });
			
			String        pendingFile    = searchForPCAP( ORIGIN_DIR );
			String        datagrams      = transformPCAP( pendingFile );
			ACLMessage    bundleOfFacts  = makeACL_FACTS( datagrams   );
			
			if ( bundleOfFacts != null )
				outLogger(new Object[] { "El mensaje es nulo: " });
				// theAgent .send( bundleOfFacts);
			
			
		}		
		return;		
	}
		
	
	public int onEnd() {
		outLogger(new Object[] { ":onEnd" } );
		return 0;
	}

}  // End of WatchdogPCAP class




//# ---------------------------------------------
//# .PCAP Reader Behaviour loader
//# ---------------------------------------------

mt1  = null; 
mt7  = null;
pcapRTS = null;



pcapRTS = new WatchdogPCAP( myAgent, 2500L, 5 );
pcapRTS.setBehaviourName( "pcapRTS" ); 

return ( WatchdogPCAP ) pcapRTS; 



//# ---------------------------------------------
//# End of .PCAP Reader Behaviour loader
//# ---------------------------------------------

