//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------



////////////////////////////////////////
//Java Classes:
import com.dpsframework.core.behaviour.JAMONodeManagement;

// (1) By-default: Integrated in BeanShell:
// source(   "class.JAMONodeManagement.bsh"  );


mt7 = new MTRepository( myAgent ) .getName( BhConstants.JAMO_MT );

jamo = new JAMONodeManagement( myAgent, mt7  );
jamo.setBehaviourName( "jamo" ); 

return (JAMONodeManagement) jamo; 
