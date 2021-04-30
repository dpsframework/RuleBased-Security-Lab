//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------


// //////////////////////////////////////
// Java Classes:
import com.dpsframework.core.behaviour.E2NRCaptorState;
import com.dpsframework.core.behaviour.E2NRProcessState;
import com.dpsframework.core.behaviour.E2NRNoticerState;
import com.dpsframework.core.behaviour.E2NRFSMBehaviour;


////////////////////////////////////////
// BeanShell Classes:
//source(   "class.E2NRCaptorState.bsh");
//source(   "class.E2NRProcessState.bsh");
//source(   "class.E2NRNoticerState.bsh");
//source(   "class.E2NRFSMBehaviour.bsh");

e2nr = new E2NRFSMBehaviour( myAgent );
e2nr.setBehaviourName("e2nr");

return (E2NRFSMBehaviour) e2nr;
