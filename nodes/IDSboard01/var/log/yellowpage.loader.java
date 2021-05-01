//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;



//# -----------------------------------------------
//# Class
//# -----------------------------------------------
source(   "yellow.BoardCapabilitiesLoader2.java"   );

yellow = new BoardCapabilitiesLoader2( myAgent,  1100L);
yellow .setBehaviourName( "yellow" );

return (BoardCapabilitiesLoader2) yellow;
