//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------



// (0) Integrated in Agent:
import com.dpsframework.core.behaviour.RSWMFSMBehaviour;


// (1) By-default: Integrated in BeanShell:
// source(   "class.RSWMFSMBehaviour.bsh"		);
// source(   "class.GENERICExecutorState.bsh"			);
// source(   "class.GENERICDaemonState.bsh"	);

// It's also possible: 
// FSMRestoreWorkingMemory( myAgent, 2000L, NameOfAnotherDumpFile-in-var-Directory );
rswm = new RSWMFSMBehaviour( myAgent ); 
rswm .setBehaviourName( "rswm" );

return (RSWMFSMBehaviour) rswm;

