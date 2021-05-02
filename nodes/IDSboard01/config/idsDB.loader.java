//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//# -----------------------------------------------

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

import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.content.Concept;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Done;

import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.UnsupportedFunction;
import jade.domain.JADEAgentManagement.ShowGui;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.security.JADESecurityException;
import jade.util.Logger;

import java.text.MessageFormat;

import com.dpsframework.*;
import com.dpsframework.domain.RMNGBehaviour;
import com.dpsframework.util.*;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;





//# -----------------------------------------------
//# Class
//# -----------------------------------------------
source( "idsDB.ShowGrid.java" );




//# ---------------------------------------------
//# Grid DB refresh/show Behaviour Loader (showdb)
//# ---------------------------------------------
stmt = myAgent .myDB() .createStatement();
qu = "select TIMEMILLIS, FILENAME, AGENTNAME, CONVERSATION, " +
	     "FRAMEWORK,PROTOCOL,PROCESS, CURRENTSTATE, FILELOCATION, METHOD, PROGRAM " +
	     " from PUBLIC.TICKETNIDS; ";
	     
qu = "select   AGENTNAME, FILENAME,  " +
	     " PROTOCOL,PROCESS, CURRENTSTATE, FILELOCATION, METHOD, PROGRAM " +
	     " from PUBLIC.TICKETNIDS; ";
	     

	     
rs = stmt .executeQuery( qu );

idsDBMgt = new ShowGrid( myAgent, rs );
idsDBMgt.setBehaviourName( "idsDBMgt" ); 



return ( ShowGrid ) idsDBMgt; 

