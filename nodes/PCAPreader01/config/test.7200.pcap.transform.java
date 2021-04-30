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





//Begin of test function:----------------------------------------------------------

/**
* Banners utilities for getting results of test.xxxxxxx.
* 
* Big-Banner: phaseBanner( "Long text" );
* Next step : question   = "Visibility of Action Class";
* Answer    : answer     = (  evaluation ) ?  AFIRMATIVO : NEGATIVO ;
* Results   : resultBanner( question, answer );
* Next step : question   = "Visibility of Action Class";
* 
* @author Francisco Jose Aguayo (SECOMUCI - UniLeon)
* 
*/


// ---------------------------------------------------------------------------------
// (First-Phase) Build a message and send it to internal Engine through agent-queue. 
// ---------------------------------------------------------------------------------
	phaseBanner( "REVIEW .PCAP Files pendings - Tests." );

// Next step..................................................:
	question   = "Visibility of Action Class"; 
	answer = (  getClass( "Action" ).getName().equals("jade.content.onto.basic.Action") ) ?  AFIRMATIVO : NEGATIVO ;
	resultBanner( question, answer );


	
	
	// Next step..................................................:
	question   = "List of trusted Agents"; 


	String streamAgentsTrusted = myNode.nodeName + " (Itself)," 
		                + myNode.sFrameworkNodeSerie + "," 
		                + myNode.sNameOfTicketBoard + " (Ticket's Service)";
	
	String[] values    = streamAgentsTrusted.split(",");  
	String itSelfAgent = values[0];
	
	answer = ( streamAgentsTrusted != null  ) ?  AFIRMATIVO : NEGATIVO ;
	resultBanner( question, answer );
	
	println(" Lista de agentes: " + streamAgentsTrusted );
	println(" Este agente: : " + itSelfAgent );
	println(" Este agente filtrado: " + itSelfAgent.split(" ")[0] );
	println();
	
	
	
	
	
	// Next step..................................................:
	question   = "Building message (1) for internal engine"; 

	question   = "Dump of message msg001 complete:"; 
	answer     = ( question != null  ) ?  AFIRMATIVO : NEGATIVO ;
	resultBanner( question, answer );
	println( question );
	println();



