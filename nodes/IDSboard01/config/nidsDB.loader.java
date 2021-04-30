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





public void shutdown(org.hsqldb.jdbc.JDBCConnection conn) throws SQLException {
    Statement st = conn.createStatement();
    st.execute("SHUTDOWN");
    conn.close(); 
}


//# /////////////////////////////////////////////
//# Technique: close and flush ddbb.
//Class.forName("org.hsqldb.jdbcDriver");
//Statement st = myAgent .myDB .createStatement();
//st.execute("SHUTDOWN");
//myAgent .myDB .close(); 
//this .myDB .close();
//shutdown( this.myDB );
//shutdown( myAgent.myDB );




//# /////////////////////////////////////////
//# Connection (myDB) only for IDS-Board-Agents

String TICKET_DB_FILE_NAME = "nidsDB";
String DATABASE_USER_ID ="sa";
String DATABASE_PASSWORD = "password";


//# Technique: HyperSonicSQL only for IDS-Board-Agents
dbFile =  myNode.relativeVarPath +  "data/" + TICKET_DB_FILE_NAME;



try {
	Class.forName("org.hsqldb.jdbc.JDBCDriver");			
	// Don't overwrite IF-EXISTS:
	dbConnection = "jdbc:hsqldb:file:" + dbFile	+ ";ifexits=true";
	myAgent .myDB = DriverManager.getConnection(dbConnection, DATABASE_USER_ID, DATABASE_PASSWORD);		
	outLogger(new Object[] {"setup", myNode.nodeName,
			"Connected with:\n setup    : " + dbConnection });
	myDB = myAgent.myDB;
	
} catch (SQLException e1) {
	outLogger(new Object[] {"setup", myNode.nodeName,
			"Can't connect to: " + dbConnection 	});
	
} catch (ClassNotFoundException e) {
	System.err.println(" Error    : JDBCDriver from hsqldb Library is not accessible!");
}


myDB() { return myAgent .myDB; }
getDB(){ return myAgent .myDB; }







//# -----------------------------------------------
//# Class
//# -----------------------------------------------
source( "nidsDB.BoardGridLocal.java" );




//# ---------------------------------------------
//# Grid DB refresh/show Behaviour Loader (showdb)
//# ---------------------------------------------
stmt = myDB .createStatement();
rs = stmt .executeQuery( "select * from ticketnids" );

nidsDB = new BoardGridLocal( myAgent, rs );
nidsDB.setBehaviourName( "nidsDB" ); 



return (BoardGridLocal) nidsDB; 

