//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------


 import com.dpsframework.core.behaviour.VisitToAgendaDaemonState;
 import com.dpsframework.core.behaviour.VisitToAgendaExecutorState;
 import com.dpsframework.core.behaviour.FSMVisitToAgenda;

// (1) By-default: Integrated in BeanShell:
// source(   "class.VisitToAgendaDaemonState.bsh"		);
// source(   "class.VisitToAgendaExecutorState.bsh"	);
// source(   "class.FSMVisitToAgenda.bsh"				);


v2ad = new FSMVisitToAgenda( myAgent );
v2ad .setBehaviourName( "v2ad");

return (FSMBehaviour) v2ad;

