//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#

 
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;



//# -----------------------------------------------
//# Class
//# -----------------------------------------------
source(   "nodeRE.B2NREResponder.java"   );



//# ---------------------------------------------
//# Board-to-NodeAnalizer-Rational-Effect-Responder
//# ---------------------------------------------
nodeRE = new B2NREResponder( myAgent,  5100L);
nodeRE.setBehaviourName( "nodeRE" );

return (B2NREResponder) nodeRE;
