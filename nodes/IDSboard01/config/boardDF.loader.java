//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//# -----------------------------------------------

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

//# -----------------------------------------------
//# Class
//# -----------------------------------------------
source(   "boardDF.SDregistrator.java"   );

boardDF = new SDregistrator( myAgent,  1100L);
boardDF .setBehaviourName( "boardDF" );

return ( SDregistrator ) boardDF;
