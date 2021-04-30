//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//#------------------------------------------------


import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import com.dpsframework.core.behaviour.ACPBEngineLoader;


////////////////////////////////////////
// BeanShell Classe:
// source(   "class.ACPBEngineLoader.bsh"  );


// //////////////////////////////////////
// Technique: Selection of files and startup procedures
initLoad = new String[][]{};

switch (myNode.engineSelected) {
	case "CLIPS":
		// /////////////////////////////////
		// Engine CLIPS 6.31-CLIPSJNI 0.5
		initLoad = new String[][] {
				
				 { "MAKE_CLEAR"		, "null"                                        		}				
				,{ "LOAD_FILE"		, myNode .relativeEnginePath  + "sudoku.clp"     		}
				,{ "LOAD_FILE"		, myNode .relativeEnginePath  + "solve.clp"     		}
				,{ "LOAD_FILE"		, myNode .relativeEnginePath  + "output-frills.clp"     }
				,{ "MAKE_RESET"		, "null"                                      			}
				,{ "RUN_INFINITELY"	, "null"                                      			}
		};
		sdku = new ACPBEngineLoader( myAgent,  1200L, initLoad);
		break;
	
	case "JESS":
		// /////////////////////////////////
		// Engine JESS 8.01a
		initLoad = new String[][]	{			
				
				 { "MAKE_CLEAR"		, "null"                                        		}				
				,{ "LOAD_FILE"		, myNode .relativeEnginePath  + "sudoku.clp"     		}
				,{ "LOAD_FILE"		, myNode .relativeEnginePath  + "solve.clp"     		}
				,{ "LOAD_FILE"		, myNode .relativeEnginePath  + "output-frills.clp"     }
				,{ "MAKE_RESET"		, "null"                                      			}
				,{ "RUN_INFINITELY"	, "null"                                      			}
		};
		sdku = new ACPBEngineLoader( myAgent,  1200L, initLoad);
		break;
	
	default:
		sdku = new ACPBEngineLoader( myAgent,  800L);
	    break;
}

sdku .setBehaviourName( "sdku" );
return (ACPBEngineLoader) sdku;
