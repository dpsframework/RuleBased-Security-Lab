//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import com.dpsframework.core.behaviour.ACPBEngineLoader;

// Technique: Selection of files and startup procedures
initLoad = new String[][]{};

switch (myNode.engineSelected) {
	case "CLIPS":
		initLoad = new String[][] {
		 { "MAKE_CLEAR"	, "null"}				
		,{ "LOAD_FILE"		, myNode .relativeEnginePath  + "CLIPS.UDP-Loader.clp" }
		,{ "MAKE_RESET"	, "null"  }
		,{ "RUN_INFINITELY"	, "null" }
		};
		acpb = new ACPBEngineLoader( myAgent,  1200L, initLoad);
		break;
	
	case "JESS":
		// /////////////////////////////////
		// Engine JESS 8.01a
		initLoad = new String[][] {
		 { "MAKE_CLEAR"	, "null"}				
		,{ "LOAD_FILE"		, myNode .relativeEnginePath  + "CLIPS.UDP-Loader.clp" }
		,{ "MAKE_RESET"	, "null"  }
		,{ "RUN_INFINITELY"	, "null" }
		};
		acpb = new ACPBEngineLoader( myAgent,  1200L, initLoad);
		break;
	
	default:
		acpb = new ACPBEngineLoader( myAgent,  800L);
	    break;
}

acpb .setBehaviourName( "acpb" );
return (ACPBEngineLoader) acpb;
