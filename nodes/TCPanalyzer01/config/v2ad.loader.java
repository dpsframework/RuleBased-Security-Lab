//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------



 import com.dpsframework.core.behaviour.V2ADAgendaDaemonState;
 import com.dpsframework.core.behaviour.V2ADAgendaExecutorState;
 import com.dpsframework.core.behaviour.V2ADFSMBehaviour;

// (1) By-default: Integrated in BeanShell:
// source(   "class.V2ADAgendaExecutorState.java"		);
// source(   "class.V2ADAgendaDaemonState.java"	        );
// source(   "class.V2ADFSMBehaviour.java"				);


v2ad = new V2ADFSMBehaviour( myAgent );
v2ad .setBehaviourName( "v2ad");

return (V2ADFSMBehaviour) v2ad;

