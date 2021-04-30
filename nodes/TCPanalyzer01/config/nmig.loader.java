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

import com.dpsframework.core.behaviour.BhConstants;
import com.dpsframework.core.behaviour.MTRepository;


////////////////////////////////////////
// Technique: Behaviour integrated in BeanShell:
// source(   "class.NMIGManagement.bsh"  );

import com.dpsframework.core.behaviour.H2NREInitiator;
import com.dpsframework.core.behaviour.N2HREResponder;
import com.dpsframework.core.behaviour.NMIGManagement;

mt8 = new MTRepository( myAgent ) .getName( BhConstants.NMIG_MT );

nmig = new NMIGManagement( myAgent , mt8 );
nmig.setBehaviourName( "nmig" ); 


return (NMIGManagement) nmig; 

