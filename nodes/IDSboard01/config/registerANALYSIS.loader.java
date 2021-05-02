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
//# REresponder
//# ---------------------------------------------
reANALY = new B2NREResponder( myAgent,  5100L);
reANALY.setBehaviourName( "reANALY" );

return (B2NREResponder) reANALY;
