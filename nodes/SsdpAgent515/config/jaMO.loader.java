//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------



////////////////////////////////////////
//Java Classes:
import com.dpsframework.core.behaviour.JAMONodeManagement;

// (1) By-default: Integrated in BeanShell:
// source(   "class.JAMONodeManagement.bsh"  );


mt1  = null; 
mt7  = null;
jaMO = null;


mt7 = new MTRepository( myAgent ) .getName( BhConstants.JAMO_MT );


jaMO = new JAMONodeManagement( myAgent, mt7  );
jaMO.setBehaviourName( "jaMO" ); 

return (JAMONodeManagement) jaMO; 
