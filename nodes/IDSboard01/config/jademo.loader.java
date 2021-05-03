//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//# -----------------------------------------------

import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.content.Concept;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Done;
import jade.core.Agent;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.UnsupportedFunction;
import jade.domain.JADEAgentManagement.ShowGui;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.security.JADESecurityException;
import jade.util.Logger;

import java.text.MessageFormat;

import com.dpsframework.*;
import com.dpsframework.domain.RMNGBehaviour;
import com.dpsframework.util.*;



//# -----------------------------------------------
//# Class
//# -----------------------------------------------
public class JAMONodeManagement2 extends RMNGBehaviour {

	StringBuilder sb 	= new StringBuilder(
			"          \n"+
			"          * ---------------------------------- *\n"+
			"          * jademo (JADE Management Ontology)  *\n"+
			"          * ---------------------------------- *\n"+
			"          *  +->---(A)--->(B)--->(C)----+      *\n"+
			"          * Event   |                   |      *\n"+
			"          *         |                   |      *\n"+
			"          *         +-<---------<-------+      *\n"+
			"          *                                    *\n"+
			"          * (A) Action ShowGui received        *\n"+
			"          * (B) Callback to that Action        *\n"+
			"          * (C) Prepare and send Done() action *\n"+
			"          *                          BSh class *\n"+
			"          * ---------------------------------- *\n"
	);
	boolean  		debugMode  	= false;	
	boolean  		verboseMode = false;
	boolean  		wasInformed = false;
	PsBoardAgent 	theBoard	= null;


	/**
	 * Board Agent Management adapted to - JADE Management Ontology.
	 * 
	 * @param a PsBoardAgent.
	 * @param mt Message Template
	 */
	public JAMONodeManagement2(Agent a, MessageTemplate mt) {
		super(a, mt);
			
		if ( a instanceof PsBoardAgent ){
			verboseMode = ( (PsBoardAgent) a) .myNode().verboseMode;
			debugMode   = ( (PsBoardAgent) a) .myNode().debuggingMode;
			theBoard 	= (PsBoardAgent) a;
		}
	}
	
	
	
	

	public void onStart() {
		super.onStart();
		
		if ( !wasInformed ) {
			makeBanner();
		}
		wasInformed = true;
	}	
	
	
	
	
	
	/**
	 * Callback method inside PsNodeAgent and PsMonitors to prepare notification message.
	 * 
	 * @param slAction action object on content field.
	 * @param request msg.
	 */
	public ACLMessage performAction(Action slAction, ACLMessage request)
			throws JADESecurityException, FIPAException {
		
		Concept action = slAction.getAction();
		
		// SHOW_GUI
		outLogger(new Object[]{getBehaviourName()+"_A", theBoard.getLocalName(), 
	      "A new REQUEST message with Action ShowGui was received."});

		if (action instanceof ShowGui) {
			if ( theBoard != null)
				theBoard.showGuiAction((ShowGui) action, request.getSender());
		
		} else {
			throw new UnsupportedFunction();
		}

		
		// Prepare the notification.
		ACLMessage notification = request.createReply();
		notification.setPerformative(ACLMessage.INFORM);
		Done d = new Done(slAction);
		
		try {
			
			theBoard.getContentManager().fillContent(notification, d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		outLogger(new Object[]{getBehaviourName()+"_C", theBoard.getLocalName(), 
			      "TicketBoard did it and Behaviour sent a notification message."});
		outLogger(verboseMode, new Object[]{getBehaviourName()+"_C", theBoard.getLocalName(), 
			      "Notification message was:",
			      "\n          * /------------------------------------------------+\n\n",
			      notification,
			      "\n\n          * \\------------------------------------------------+"
		});
		
		return notification;
	}

	
	private void outLogger(Object[] o){
		if   (! debugMode   ) { return; }
		if   ( o.length == 0) { return; }
		int    n  = o.length;
		String mf = " {0}: [{1}]";    // {2} {3} {4} {5} 
		for (int i = 2; i < n; i++ ){ mf += " {" + i +"}"; }
		o[0] = (o[0]+"         ").substring(0, 9); 
		Logger.println(MessageFormat.format(mf,o));
		return;
	}
	
	private void outLogger(boolean verbose, Object[] o){
		if   ( verbose   ) { outLogger(o); }
	}
	
	private void makeBanner() {
		String diaLbl 	= "Diagram of '" + getBehaviourName() + "' Externalized Behaviour is shown below:";	
		outLogger(new Object[] { getBehaviourName(), theBoard.getLocalName(), "Initialized." });
		outLogger(verboseMode, new Object[] { getBehaviourName(), theBoard.getLocalName(), diaLbl, sb });
	}

}  // End of Basal JADE.Management Behaviour for Show GUI on PsBoardAgent hide instances.







//# ---------------------------------------------
//# JADE Agent Management Ontology (JADEMO) Loader
//# ---------------------------------------------

mt1  = null; 
mt7  = null;
jademo = null;

MessageTemplate mt1 = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
MessageTemplate mt7 = MessageTemplate.and(mt1, MessageTemplate.MatchOntology(JADEManagementOntology.NAME));

jademo = new JAMONodeManagement2( myAgent, mt7 );
jademo.setBehaviourName( "jademo" ); 

return ( JAMONodeManagement2 ) jademo; 



//# ---------------------------------------------
//# End of jademo.loader.java
//# ---------------------------------------------

