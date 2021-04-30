//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import com.dpsframework.core.behaviour.ACPBEngineLoader;

//# Agent with Engine JESS 8.01a only
//# /////////////////////////////////

initLoad = new String[][]{
	 { "MAKE_CLEAR"	    , "null"}				
	,{ "LOAD_FILE"      , myNode .relativeEnginePath  + "Jess.UDP-Loader.clp" }
	,{ "MAKE_RESET"     , "null"  }
	,{ "RUN_INFINITELY"	, "null" }
	};

switch (myNode.engineSelected) {
	case "CLIPS":
		acpb = null;
		break;
	
	case "JESS":

		acpb = new ACPBEngineLoader( myAgent,  1200L, initLoad);
		break;
	
	default:
		acpb = new ACPBEngineLoader( myAgent,  800L);
	    break;
}

acpb .setBehaviourName( "acpb" );
return (ACPBEngineLoader) acpb;
