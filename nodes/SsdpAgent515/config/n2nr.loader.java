//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------



//(0) Integrated in Agent:  
import com.dpsframework.core.behaviour.N2NREResponder;

//(1) By-default: Integrated in BeanShell:
// source(   "class.N2NREResponder.bsh"  );


// /////////////////////////////////////////////
// Technique: Initialize n2nr instance.

mt8 	= new MTRepository( myAgent ) .getName( BhConstants.N2NRESPONDER_MT );

n2nr 	= new N2NREResponder( myAgent, mt8 );
n2nr    .setBehaviourName( "n2nr" );

return (N2NREResponder) n2nr;

