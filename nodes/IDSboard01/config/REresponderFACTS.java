//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//# ------------------------------------------------
//# @author:  FJAC et al. - SECOMUCI & SALBIS Research Group - UniLeon (2021).


import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.SimpleAchieveREResponder;
import jade.util.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;

import com.dpsframework.util.PsConstants;


public class REresponseFACTS extends SimpleAchieveREResponder implements {

	StringBuilder sb = new StringBuilder("          \n"
			+ "          * ---------------------------------- *\n"
			+ "          * REresponderFACTS                   *\n"
			+ "          * ---------------------------------- *\n"
			+ "          * (A)---<-------------<------+       *\n"
			+ "          *  |                         |       *\n"
			+ "          * (B)                        |       *\n"
			+ "          *  |                         |       *\n"
			+ "          * (C)                        |       *\n"
			+ "          *  |                         |       *\n"
			+ "          * (D)--(like a Response!)    |       *\n"
			+ "          *  |                         |       *\n"
			+ "          * (E)                        |       *\n"
			+ "          *  |                         |       *\n"
			+ "          *  +--->(F)-->---(reset)-->--+       *\n"
			+ "          *                                    *\n"
			+ "          * (A) Waiting ACCEPT_PROPOSAL        *\n"
			+ "          * (B) Prepare Binary Content         *\n"
			+ "          * (C) Send ZIPfile                   *\n"
			+ "          * (D) Prepare Notification           *\n"
			+ "          * (E) Send Notification like AGREE   *\n"
			+ "          * (F) Shutdown this Node             *\n"
			+ "          *                         Java.class *\n"
			+ "          * ---------------------------------- *\n");
	boolean debugMode;
	boolean verboseMode;
	boolean wasInformed;
	DataStore miabDS;
	MessageTemplate reqMT;
	boolean finished;
	boolean isError;

	// Data from MIAB Behaviour:
	// miabDS.put("monitorNode" , (String) monitorNode);
	// miabDS.put("migrateMsg" , (ACLMessage) migrateMsg);
	// miabDS.put("anfitrionAID" , (AID) anfitrionAID);
	// miabDS.put("pathOfZipFile" , (String) pathOfZipFile);
	// miabDS.put("nameOfZipFile" , (String) nameOfZipFile);

	public N2HREResponder(Agent a, MessageTemplate mt, DataStore store) {
		super(a, mt, store);

		myAgent = a;
		reqMT = mt;
		miabDS = store;
	}

	public N2HREResponder(Agent a, MessageTemplate mt, DataStore store,
			boolean isDebuging, boolean isVerbose) {
		this(a, mt, store);
		debugMode = isDebuging;
		verboseMode = isVerbose;
	}

	public void reset() {
		super.reset();
		stepHandleBanner("Behaviour is reseting.");
		finished = true;
	}

	public void reset(ACLMessage m) {
		this.reset();
	}

	public void onStart() {
		super.onStart();
		onStartBanner();
	}

	public ACLMessage prepareResponse(ACLMessage request)
			throws NotUnderstoodException, RefuseException {

		if (request.getPerformative() == ACLMessage.FAILURE) {
			stepHandleBanner("Error from AMS:", request);
			stepHandleBanner("Migration is not available against: "
					+ miabDS.get("monitorNode"));
			reset();
			isError = true;
			return null;
		}

		// Send Binary Content with ZIP file:
		// -------------------------------------
		stepHandleBanner("Accept proposal received from MonitorNode", request);
		stepHandleBanner("[prepareResponse]");

		String nameOfFile = (String) miabDS.get("nameOfZipFile");
		File thisFrameworkDir = new File(System.getProperty("user.dir"));
		String frameworkRootPath = thisFrameworkDir.getAbsolutePath()
				+ File.separator;
		nameOfFile = frameworkRootPath + FwPATHS.root_logs + "/" + nameOfFile;
		File fff = new File(nameOfFile);
		FileInputStream fis;

		ACLMessage zipFileResponse = request.createReply();
		zipFileResponse.setPerformative(ACLMessage.AGREE);
		zipFileResponse.setSender(myAgent.getAID());
		zipFileResponse.setEncoding(FIPANames.ACLCodec.BITEFFICIENT);
		zipFileResponse.setLanguage(FIPANames.ContentLanguage.FIPA_SL);

		try {

			fis = new FileInputStream(fff);
			int byteLength = (int) fff.length();
			byte[] fileContent = new byte[byteLength];
			fis.read(fileContent, 0, byteLength);
			zipFileResponse.setByteSequenceContent(fileContent);
			fis.close();
			stepHandleBanner("File name: " + nameOfFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return zipFileResponse;
	}

	public ACLMessage prepareResultNotification(ACLMessage request,
			ACLMessage response) throws FailureException {
		stepHandleBanner("[prepareResultNotification]");

		ACLMessage prepNotification = request.createReply();
		prepNotification = (ACLMessage) response.clone();
		prepNotification.setPerformative(ACLMessage.INFORM);
		prepNotification.setSender(myAgent.getAID());
		prepNotification.setContent("Deleting agent");
		prepNotification.setLanguage(FIPANames.ACLCodec.STRING);
		prepNotification.setOntology(JADEManagementOntology.NAME);

		isError = false;
		return prepNotification;
	}

	public int onEnd() {
		stepHandleBanner("Behaviour is onEnd() and finished value is: "
				+ finished);

		if (!isError) {
			stepHandleBanner("Node is deleting from this container...");
			myAgent.doDelete();
			return 1;
		}
		if (finished) {
			stepHandleBanner("Behaviour " + getBehaviourName()
					+ " is finished.");
			return 2;
		}
		return 0;
	}

	public boolean done() {
		return finished;
	}

	// Utilities:
	// ------------------------------------
	private void outLogger(Object[] o) {
		if (!debugMode) {
			return;
		}
		if (o.length == 0) {
			return;
		}
		int n = o.length;
		String mf = " {0}: [{1}]"; // {2} {3} {4} {5}
		for (int i = 2; i < n; i++) {
			mf += " {" + i + "}";
		}
		o[0] = (o[0] + "         ").substring(0, 9);
		Logger.println(MessageFormat.format(mf, o));
		return;
	}

	private void onStartBanner() {
		if (!wasInformed) {
			String diaLbl = "Diagram of '" + getBehaviourName()
					+ "' Behaviour is shown below:";
			outLogger("'" + getBehaviourName() + "' Initialized.");
			outLogger(verboseMode,
					new Object[] { getBehaviourName(), myAgent.getLocalName(),
							diaLbl, sb });
		}
		wasInformed = true;
	}

	private void stepHandleBanner(String step) {
		outLogger(new Object[] { getBehaviourName(), myAgent.getLocalName(),
				step });
	}

	private void stepHandleBanner(String step, ACLMessage msg) {
		stepHandleBanner(step);
		outLogger(
				verboseMode,
				new Object[] {
						getBehaviourName(),
						myAgent.getLocalName(),
						"On [" + step + "] wiht message:",
						"\n          * /------------------------------------------------+"
								+ "\n          * Content:\n\n" + msg +
								// "\n          * ---------" +
								// "\n          * Envelope:\n\n" +
								// msg.getEnvelope() +
								"\n\n          * \\------------------------------------------------+" });
	}

	private void outLogger(boolean verbose, Object[] o) {
		if (verbose) {
			outLogger(o);
		}
	}

	private void outLogger(String s) {
		outLogger(new Object[] { getBehaviourName(), myAgent.getLocalName(), s });
	}

}
