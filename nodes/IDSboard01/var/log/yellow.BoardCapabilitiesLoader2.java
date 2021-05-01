//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.FIPAManagementOntology;
import jade.domain.FIPAAgentManagement.Property;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.util.Logger;
import java.text.MessageFormat;

import jade.core.AID;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.Property;


import com.dpsframework.PsBoardAgent;
import com.dpsframework.util.PsConstants;
import com.dpsframework.domain.ProblemSolversOntology;

/**
 * Board Capabilities Loader: Yellow Pages Service Activation.
 * 
 * @author Francisco J Aguayo Canela (UniLeon)
 * <p>
 * 		<small>	Department of Electric Engineering, Systems and Automatic<br>
 * 				School of Industrial Engineering and Information Technology<br>
 * 				&copy; <b>University of Leon</b> - Spain.  
 * 				<a href="http://www.unileon.es">{http://www.unileon.es}</a>
 * 		</small>
*/
class BoardCapabilitiesLoader2 extends WakerBehaviour {
	 StringBuilder sb 	= new StringBuilder(
			"         \n"+
			"          * ---------------------------------- *\n"+
			"          * Board Capabilities Loader         *\n"+
			"          * ---------------------------------- *\n"+
			"          *  (A)--+------> (End)               *\n"+
			"          *       |                            *\n"+
			"          *     TimeEvent (Long)               *\n"+
			"          *                          BSh Class *\n"+
			"          * ---------------------------------- *\n"  
	 );
	 boolean  			debugMode;	
	 boolean  			verboseMode;
	 boolean  			wasInformed;
	 int  				exitValue;
	 PsBoardAgent		theNode	;
	 DFAgentDescription myDfd;
	 ServiceDescription mySd;
	
	 
	 
	public BoardCapabilitiesLoader2(Agent a, long t) {
		super(a, t);
	
		if ( a instanceof PsBoardAgent) {
			theNode 		= (PsBoardAgent) a;
			verboseMode		= theNode.myNode().verboseMode;
			debugMode 		= theNode.myNode().debuggingMode;
		}
	}

	
	public void onStart() {
		super.onStart();
		if ( ! wasInformed ) { makeBanner(); }
		wasInformed = true;
	}
	
	
	public void onWake(){
		
		if ( theNode == null ) {
			exitValue = 0;	
			outLogger("Behaviour has returned [" +   exitValue   + "]" +
				      "Sorry but, it's only for PsBoardAgents...");
			return;
		}    
	    
		mySd  = new ServiceDescription();
 		
 		mySd.setName(theNode.myNode().nameOfBoardService);
 		mySd.setType(PsConstants.BoardPKEYS.service_name);
 		mySd.addProperties(	new Property("framework", theNode.myNode().frameworkName));
 		mySd.addOntologies(JADEManagementOntology.NAME);
 		mySd.addOntologies(ProblemSolversOntology.NAME);
 		mySd.addOntologies(FIPAManagementOntology.NAME);
		mySd.setOwnership(theNode.myNode().frameworkName);
		 	
 		myDfd = new DFAgentDescription();
 		
 		myDfd.setName(theNode.getAID());	  		
 		myDfd.addOntologies(JADEManagementOntology.NAME);
 		myDfd.addOntologies(ProblemSolversOntology.NAME);
 		myDfd.addOntologies(FIPAManagementOntology.NAME);
 		myDfd.addLanguages(FIPANames.ContentLanguage.FIPA_SL);
 		myDfd.addProtocols(FIPANames.InteractionProtocol.FIPA_REQUEST); 		
 		
 		myDfd.addServices(mySd);

	  	try {
	  		DFService.register(theNode, myDfd);
		  	theNode.setDfd( myDfd );
		  	theNode.setSd( mySd );
			exitValue = 1;
	  	}
	  	catch (FIPAException fe) {
	  		exitValue = 0;		
	  	}
	}

	
	public int onEnd() {
		if ( exitValue == 0 ){
			outLogger("Behaviour has returned [" +   exitValue   + "] Board has been not registered in DF.Agent");
		} else {
			outLogger("Behaviour has returned [" +   exitValue   + "] Board has been registered in DF.Agent");
		}
		return exitValue;
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

	private void outLogger(String s){
		outLogger(new Object[] {"bcpb", myAgent.getLocalName(), s});
	}
	
	private void makeBanner() {
		String diaLbl = "Diagram of '" + getBehaviourName() + "' Behaviour is shown below:";	
		outLogger(new Object[] { getBehaviourName(), myAgent.getLocalName(), "Initialized." });
		outLogger(verboseMode, new Object[] { getBehaviourName(), myAgent.getLocalName(), diaLbl, sb });
	}

} // End of class BoardCapabilitiesLoader Service definition.