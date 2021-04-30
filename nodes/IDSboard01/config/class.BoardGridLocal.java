// Revised:   2021.04.28                               
//            [ RuleBased-Security-Lab example ]
//
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
					exitValue = 1;
				}
			};
			SwingUtilities.invokeLater(doPopulate);
			
			
		} catch (SQLException e) {
			System.err.println( " grid     : [Error] in grid data loader Behaviour...!");
		}
		return;
	}

	public int onEnd() {
		return exitValue;
	}

	
	
	
	

	
	
	
} // End of class BoardGridLocal 
