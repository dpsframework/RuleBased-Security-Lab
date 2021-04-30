//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------


import jade.core.Agent;

import jade.content.Concept;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Done;
import jade.domain.FIPAException;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.security.JADESecurityException;
import com.dpsframework.domain.*;

////////////////////////////////////////
// Technique: Behaviour integrated in BeanShell:
// source(   "class.N2HREResponder.bsh"  );

import com.dpsframework.core.behaviour.N2HREResponder;

mt9 = new MTRepository( myAgent ) .getName( BhConstants.N2HR_MT );

n2hr = new N2HREResponder( myAgent, mt9, new DataStore());
n2hr.setBehaviourName( "n2hr" );

return (N2HREResponder) n2hr; 

