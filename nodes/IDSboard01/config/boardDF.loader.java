/** -------------------------------------------------------------------------------
 * Ph.D.Thesis    : Deposit-Number# 2012.0000.55
 * Title (en_US)  : Deploy Production Systems on Distributed Architecture 
 *                  using Multi-Agent Paradigm: applied techniques
 * Title (es_ES)  : Tecnicas para despliegue de arquitectura distribuida en sistemas
 *                  expertos basados en reglas empleando el paradigma multiagente.
 * Ph.D. Student  : Francisco J Aguayo Canela 
 * Thesis Director: Ph.D. Isaias Garcia Rodriguez 
 * Ph.D. Program  : Intelligent Systems at Engineering Science (Cod. 212)
 * -------------------------------------------------------------------------------- */

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

////////////////////////////////////////
// BeanShell Classe:
source(   "boardDF.BoardCapabilities.java"   );

boardDF = new BoardCapabilities( myAgent,  1100L);
boardDF .setBehaviourName( "boardDF" );

return ( BoardCapabilities ) boardDF;
