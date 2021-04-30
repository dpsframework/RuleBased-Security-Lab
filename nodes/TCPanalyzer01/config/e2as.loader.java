//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------



//(0) Integrated in Agent:
import com.dpsframework.core.behaviour.E2ASAsynchronousShell;

//(1) By-default: Integrated in BeanShell:
// source(   "class.E2ASAsynchronousShell.bsh"  );

mt11 = new MTRepository( myAgent ) .getName( BhConstants.E2AS_MT );
e2as = new E2ASAsynchronousShell( myAgent, mt11 );  

e2as.setBehaviourName("e2as");

return (E2ASAsynchronousShell) e2as;
