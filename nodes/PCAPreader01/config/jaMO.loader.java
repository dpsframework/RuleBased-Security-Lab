import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//# -----------------------------------------------



//# -----------------------------------------------
//# Class
//# -----------------------------------------------
class JadeMOVisibleGUI extends RMNGBehaviour {
	private Agent theAgent;
	
	private void outLogger(Object[] o){
		if   ( o.length == 0) 	{ return; }
		int  n = o.length;  String mf2 	= " {0}: [{1}]";     
		o[0] = (o[0]+"         ").substring(0, 9); 	
		for (int i = 2; i < n; i++ ){	mf2 += " {" + i +"}"; }  
		Logger.println(MessageFormat.format(mf2,o));
		return;
	}

	
	public JadeMOVisibleGUI( Agent a, MessageTemplate mt ) {
		super( a, mt );
		theAgent = a;
	}
	
		
	public void onStart(){
		super.onStart();		
		outLogger(new String[] { getBehaviourName(),
				theAgent.getLocalName(),"Behaviour :onStart()" } );
	}	
	
		
	public ACLMessage performAction(
			jade.content.onto.basic.Action slAction, 
			ACLMessage request)		throws JADESecurityException, FIPAException {	
		
		Concept action = slAction.getAction();

		if (action instanceof jade.domain.JADEAgentManagement.ShowGui ) {
			if ( theAgent != null)
				theAgent.showGuiAction((ShowGui) action, request.getSender());
		} else {
			throw new UnsupportedFunction();
		}

		
		ACLMessage notification = request.createReply();
		notification.setPerformative(ACLMessage.INFORM);
		Done d = new Done(slAction);
		
		try {		
			theAgent .getContentManager().fillContent(notification, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		outLogger(new String[] { getBehaviourName(),theAgent.getLocalName(), 
				"ACLMessage:\n " + notification }  );
		
		return notification;
	}

} 
//# JadeMOVisibleGUI Class.



//# ---------------------------------------------
//# JADE Agent Management Ontology (JAMO) Loader
//# ---------------------------------------------

mt1  = null; 
mt7  = null;
jaMO = null;

MessageTemplate mt1 = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
MessageTemplate mt7 = MessageTemplate.and(mt1, MessageTemplate.MatchOntology(JADEManagementOntology.NAME));

jaMO = new JadeMOVisibleGUI( myAgent, mt7 );
jaMO.setBehaviourName( "jaMO" ); 

return ( JadeMOVisibleGUI ) jaMO; 



//# ---------------------------------------------
//# End of jamo.loader.java
//# ---------------------------------------------

