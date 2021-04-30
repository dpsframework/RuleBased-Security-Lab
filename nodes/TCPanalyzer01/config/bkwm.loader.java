//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------



// //////////////////////////////////////
// Java Classes:
import com.dpsframework.core.behaviour.BKWMFSMBehaviour;


// Example of: 
// bkwm = new FSMBackupWorkingMemory( myAgent  ); // Without second parameter, by default = 15 minutes
bkwm 	= new BKWMFSMBehaviour( myAgent, 60L );    
bkwm 	.setBehaviourName( "bkwm");

return (BKWMFSMBehaviour) bkwm;

