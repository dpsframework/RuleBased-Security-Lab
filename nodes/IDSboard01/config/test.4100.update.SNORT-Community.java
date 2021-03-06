// Revised:   2021.04.28                               
//            [ RuleBased-Security-Lab example ]
// 
import jade.content.*;
import jade.content.onto.basic.Action;

import jade.content.onto.BasicOntology;
import jade.content.onto.BeanOntology;
import jade.content.onto.BeanOntologyException;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyUtils;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;

import jade.core.CaseInsensitiveString;

import jade.domain.FIPANames;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import jade.util.leap.Serializable;
import jade.util.leap.ArrayList;

import jade.core.*;
import jade.core.behaviours.*;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.CyclicBehaviour;

import com.dpsframework.domain;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import javax.sql.RowSetListener;
import javax.sql.rowset.CachedRowSet;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



import java.util.Date;
import java.lang.System.*;



// ----------------------------------------------------------------------------
phaseBanner( "SSDP - Agents CLIPS/JESS INQUIRIES Test" );

	question  = "JDBCConnection class present ?"; 
	answer = (  getClass( "SQLException" ) != null )  ?  AFFIRMATIVE : NEGATIVE ;
	resultBanner( question, answer );

	
	question  = "Ontology Action class present ?"; 
	answer = (  getClass( "Action" )       != null )  ?  AFFIRMATIVE : NEGATIVE ;
	resultBanner( question, answer );

	question  = "Error class present ?"; 
	answer = (  getClass( "AAAAA" )       != null )  ?  AFFIRMATIVE : NEGATIVE ;
	resultBanner( question, answer );


// ----------------------------------------------------------------------------
phaseBanner( "ENVIRONMENT OF  [" + frameworkName + "]"  );

	
	question   = "List trusted agents on [" + frameworkName + "]" ; 
	answer = ( true  ) ?  AFFIRMATIVE : NEGATIVE ;
	resultBanner( question, answer );
	println("Trusted agents:" );
	for( c : myNode.sFrameworkNodeSerie.split(",") ){ println( "   -> " +  c ); }

	
// ----------------------------------------------------------------------------
phaseBanner( "Test set is finished."  );
