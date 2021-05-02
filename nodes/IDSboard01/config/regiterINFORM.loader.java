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
reINFOR = new B2NREResponder( myAgent,  5100L);
reINFOR.setBehaviourName( "reINFOR" );

return (B2NREResponder) reINFOR;
