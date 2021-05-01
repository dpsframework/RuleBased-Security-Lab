// Revised:   2021.04.28                               
//            [ RuleBased-Security-Lab example ]
//
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.core.AID;

import com.dpsframework.PsBoardAgent;
import com.dpsframework.util.PsConstants;
import com.dpsframework.domain.ProblemSolversOntology;

/**
 * Board To Node REResponder
 * 
 * @author Francisco J Aguayo Canela (UniLeon)
 * <p>
 * 		<small>	Department of Electric Engineering, Systems and Automatic<br>
 * 				School of Industrial Engineering and Information Technology<br>
 * 				&copy; <b>University of Leon</b> - Spain.  
 * 				<a href="http://www.unileon.es">{http://www.unileon.es}</a>
 * 		</small>
*/
class B2NREResponder extends WakerBehaviour {
	 StringBuilder sb 	= new StringBuilder(
			"         \n"+
			"          * ---------------------------------- *\n"+
			"          * Board To Node REResponder          *\n"+
			"          * ---------------------------------- *\n"+
			"          *  (A)--+------> (End)               *\n"+
			"          *       |                            *\n"+
			"          *     TimeEvent (Long)               *\n"+
			"          *                          Bsh Class *\n"+
			"          * ---------------------------------- *\n"  
	 );
	 boolean  			debugMode;	
	 boolean  			verboseMode;
	 boolean  			wasInformed;
	 int  				exitValue;
	 PsBoardAgent		theBoard	;

	
	 
	 
	public B2NREResponder(Agent a, long t) {
		super(a, t);
	
		if ( a instanceof PsBoardAgent) {
			theBoard 		= (PsBoardAgent) a;
			verboseMode		= theBoard.myNode().verboseMode;
			debugMode 		= theBoard.myNode().debuggingMode;
		}
	}

	
	public void onStart() {
		super.onStart();
		if ( ! wasInformed ) { makeBanner(); }
		wasInformed = true;
	}
	
	
	public void onWake(){
		
		if ( theBoard == null ) {
			exitValue = 0;	
			outLogger("Behaviour has returned [" +   exitValue   + "]" +
				      "Sorry but, it's only for PsBoardAgents...");
			return;
		}    
	    
	  	
	  	exitValue = 1;
	}

	
	public int onEnd() {
		if ( exitValue == 0 ){
			outLogger("Behaviour has returned [" +   exitValue   + "] Interaction Protocol is not initiated.");
		} else {
			outLogger("Behaviour has returned [" +   exitValue   + "] Interaction Protocol has been initiated.");
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
		outLogger(new Object[] { getBehaviourName() , myAgent.getLocalName(), s});
	}
	
	private void makeBanner() {
		String diaLbl = "Diagram of '" + getBehaviourName() + "' Behaviour is shown below:";	
		outLogger(new Object[] { getBehaviourName(), myAgent.getLocalName(), "Initialized." });
		outLogger(verboseMode, new Object[] { getBehaviourName(), myAgent.getLocalName(), diaLbl, sb });
	}

} // End of class B2NREResponder REResponder
