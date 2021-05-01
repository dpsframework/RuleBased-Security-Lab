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


import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;



import com.dpsframework.PsBoardAgent;



/**
 * Board Grid Loader JTable-TableModel.
 * 
 * @author Francisco J Aguayo Canela (UniLeon)
 * <p>
 * 		<small>	Department of Electric Engineering, Systems and Automatic<br>
 * 				School of Industrial Engineering and Information Technology<br>
 * 				&copy; <b>University of Leon</b> - Spain.  
 * 				<a href="http://www.unileon.es">{http://www.unileon.es}</a>
 * 		</small>
*/
public class BoardGridLocal extends OneShotBehaviour {
	PsBoardAgent		theBoard;
	int 				exitValue;
	boolean  			debugMode;	
	boolean  			verboseMode;
	
	DefaultTableModel 	tableModel;
	ResultSet 			rs;
	ResultSetMetaData 	meta;
	int 				columnCount;

	public BoardGridLocal(Agent a, ResultSet rowSet) {
		super(a);
		rs = rowSet;

		if (a instanceof PsBoardAgent) {
			theBoard = (PsBoardAgent) a;
			verboseMode		= theBoard.myNode().verboseMode;
			debugMode 		= theBoard.myNode().debuggingMode;
			exitValue		= 0;
		}
	}

	public void action() {
		if ( theBoard == null) { return; }
		if ( !debugMode     ) { return; }
		
		tableModel = new DefaultTableModel();
		try {
			meta = rs .getMetaData();
			columnCount = meta.getColumnCount();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
	            tableModel.addColumn(meta.getColumnLabel(columnIndex));
	        }
	        Object[] row = new Object[columnCount];
	        while (rs.next()){
	            for (int i = 0; i < columnCount; i++){
	                row[i] = rs.getObject(i+1);
	            }
	            tableModel.addRow(row);
	        }
	        rs.close();
	        
	        
			Runnable doPopulate = new Runnable() {
				public void run() {
					theBoard .myGui().tTable().setModel(tableModel);
					theBoard .myGui().tTable().setRowHeight(30);
					theBoard .myGui().tTable().setRowHeight(5,50);
					// theBoard .myGui().tTable().setBackground(Color.orange);
					theBoard .myGui().tTable().setForeground(Color.blue);
					exitValue = 1;
				}
			};
			SwingUtilities.invokeLater(doPopulate);
			
			
		} catch (SQLException e) {
			System.err.println( " SQLError : [Error] in DB-Table data loader Behaviour...!");
		}
		return;
	}

	public int onEnd() {
		outLogger(true, new Object[]{getBehaviourName(), myAgent.getLocalName(), 
			      "Connected DB: ",myAgent .myDB() });
		return exitValue;
	}

	
	private void outLogger(Object[] o){
		if   (! debugMode   ) { return; }
		if   ( o.length == 0) { return; }
		int    n  = o.length;
		String mf = " {0}: [{1}]";    // {2} {3} {4} {5} 
		for (int i = 2; i < n; i++ ){ mf += " {" + i +"}"; }
		o[0] = (o[0]+"         ").substring(0, 9); 
		Logger.println(MessageFormat.format(mf,o));
		return;
	}
	
	private void outLogger(boolean verbose, Object[] o){
		if   ( verbose   ) { outLogger(o); }
	}
	
	private void makeBanner() {
		String diaLbl 	= "Diagram of '" + getBehaviourName() + "' Externalized Behaviour is shown below:";	
		outLogger(new Object[] { getBehaviourName(), myAgent.getLocalName(), "Initialized." });
		outLogger(verboseMode, new Object[] { getBehaviourName(), myAgent.getLocalName(), diaLbl, sb });
	}	
	
	

	
	
	
} // End of class BoardGridLocal 
