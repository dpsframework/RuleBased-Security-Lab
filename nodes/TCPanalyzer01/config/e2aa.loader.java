//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------



//(0) Integrated in Agent:
 import com.dpsframework.core.behaviour.E2AAEngineInterpreter;

//(1) By-default: Integrated in BeanShell:
// source(   "class.E2AAEngineInterpreter.bsh"  );


// /////////////////////////////////////////////
// Technique: 
mt09 = new MTRepository( myAgent ) .getName( BhConstants.E2AA_MT );
e2aa = new E2AAEngineInterpreter( myAgent, mt09 );  

e2aa.setBehaviourName( "e2aa" );
 
return (E2AAEngineInterpreter) e2aa;
