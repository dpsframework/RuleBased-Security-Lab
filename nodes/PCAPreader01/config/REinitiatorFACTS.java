//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//# ------------------------------------------------
//# @author:  FJAC et al. - SECOMUCI & SALBIS Research Group - UniLeon (2021).

import jade.core.*;
import jade.core.behaviours.*;
import jade.domain.FIPANames;
import jade.lang.acl.*;
import jade.proto.states.MsgReceiver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Vector;
import java.util.Enumeration;

import com.dpsframework.domain.ProblemSolversOntology;
import com.dpsframework.util.PsServices;
import com.dpsframework.util.PsConstants.FwPATHS;
import com.dpsframework.util.PsServices;

import jade.util.Logger;
import jade.util.leap.Iterator;
import jade.util.leap.Map;
import jade.util.leap.HashMap;
import jade.util.leap.List;
import jade.util.leap.ArrayList;
import jade.util.leap.Serializable;
import jade.proto.*;


import jade.lang.acl.ACLMessage;
import jade.proto.SimpleAchieveREInitiator;
import jade.util.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;


/**
 * FROM jade.proto.AchieveREInitiator.java:
 * 
 * 
 * This is a single homogeneous and effective implementation of all the
 * FIPA-Request-like interaction protocols defined by FIPA, that is all those
 * protocols where the initiator sends a single message (i.e. it performs a
 * single communicative act) within the scope of an interaction protocol in
 * order to verify if the RE (Rational Effect) of the communicative act has been
 * achieved or not. This implementation works both for 1:1 and 1:N conversation.
 * <p>
 * FIPA has already specified a number of these interaction protocols, like
 * FIPA-Request, FIPA-query, FIPA-Request-When, FIPA-recruiting, FIPA-brokering,
 * that allows the initiator to verify if the expected rational effect of a
 * single communicative act has been achieved.
 * <p>
 * The structure of these protocols is equal. The initiator sends a message (in
 * general it performs a communicative act).
 * <p>
 * The responder can then reply by sending a <code>not-understood</code>, or a
 * <code>refuse</code> to achieve the rational effect of the communicative act,
 * or also an <code>agree</code> message to communicate the agreement to perform
 * (possibly in the future) the communicative act. This first category of reply
 * messages has been here identified as a response.
 * <p>
 * The responder performs the action and, finally, must respond with an
 * <code>inform</code> of the result of the action (eventually just that the
 * action has been done) or with a <code>failure</code> if anything went wrong.
 * This second category of reply messages has been here identified as a result
 * notification.
 * <p>
 * Notice that we have extended the protocol to make optional the transmission
 * of the agree message. Infact, in most cases performing the action takes so
 * short time that sending the agree message is just an useless and uneffective
 * overhead; in such cases, the agree to perform the communicative act is
 * subsumed by the reception of the following message in the protocol.
 * <p>
 * Read carefully the section of the <a href="..\..\..\programmersguide.pdf">
 * JADE programmer's guide </a> that describes the usage of this class.
 * <p>
 * <b>Known bugs:</b> <i> The handler <code>handleAllResponses</code> is not
 * called if the <code>
 * agree</code> message is skipped and the <code>inform</code> message is
 * received instead. <br>
 * One message for every receiver is sent instead of a single message for all
 * the receivers. </i>
 * 
 * @author Giovanni Caire - TILab
 * @author Fabio Bellifemine - TILab
 * @author Tiziana Trucco - TILab
 * @version $Date: 2005-12-01 14:09:42 +0100 (gio, 01 dic 2005) $ $Revision:
 *          5839 $
 **/

public class REinitiatorFACTS extends AchieveREInitiator {
	
	boolean verboseMode;
	boolean debugMode;
	boolean finished;
	PsMonitorAgent theReader;

	StringBuilder sb = new StringBuilder("          \n"
			+ "          * ---------------------------------- *\n"
			+ "          * FIPA-Request-When REInitiator      *\n"
			+ "          * ---------------------------------- *\n"
			+ "          * (event) msg from REinitiatorFACTS  *\n"
			+ "          *  |                                 *\n"
			+ "          * (B)--(msg==null)--> done()         *\n"
			+ "          *  |                                 *\n"
			+ "          * (C)-1--(handleAgree)--------->--+  *\n"
			+ "          *  |--14-(handleRefuse)-------->--|  *\n"
			+ "          *  +--10-(handleNotUnderstood)->-(D) *\n"
			+ "          *                                 |  *\n"
			+ "          *  +--<-(handleInform)<------7---(E) *\n"
			+ "          *  |--<-(handleFailure)<-----6----+  *\n"
			+ "          *  |                                 *\n"
			+ "          *  +--->(F)--> done()                *\n"
			+ "          * ---------------------------------- *\n"
			+ "          * (A) Revise PCAP.facts files        *\n"
			+ "          * (B) Send Message                   *\n"
			+ "          * (C) Receive the 1st Reply (ZIPfile)*\n"
			+ "          * (D) All Reply Received             *\n"
			+ "          * (E) Receive the 2nd Reply (OK)    *\n"
			+ "          * (F) All Results Received (Restart) *\n"
			+ "          * ---------------------------------- *\n");

	public REinitiatorFACTS(Agent a, ACLMessage msg, DataStore store) {
		super(a, msg, store);
		finished = false;
		verboseMode = (boolean) store.get("debugMode");
		debugMode = (boolean) store.get("verboseMode");
	}

	public void onStart() {
		super.onStart();
		onStartBanner();
	}

	protected ACLMessage prepareRequest(ACLMessage msg) {
		ACLMessage mMessage = msg;
		mMessage.setSender(theReader.getAID());
		mMessage.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
		mMessage.setConversationId(null);
		mMessage.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST_WHEN);
		mMessage.setOntology(ProblemSolversOntology.NAME);

		stepHandleBanner("prepareRequest", mMessage);
		return mMessage;
	}

	protected void handleAgree(ACLMessage msg) {
		stepHandleBanner("handleAgree", msg);

		//# /////////////////////////////
		//# Look for PCAP.facts files and compress them."
		String nameOutZipFile = (String) getDataStore().get("nameOfPCAP") + "To"
				+ (String) getDataStore().get("dateConversion") + ".zip";
		File thisFrameworkDir = new File(System.getProperty("user.dir"));
		String frameworkRootPath = thisFrameworkDir.getAbsolutePath()
				+ File.separator;
		String frameworkLogPath = frameworkRootPath + FwPATHS.root_logs
				+ File.separator;
		File theZIP = new File(frameworkLogPath + nameOutZipFile);
		getDataStore().put("nameOutZipFile", nameOutZipFile);
		getDataStore().put("frameworkRootPath", frameworkRootPath);
		getDataStore().put("frameworkLogPath", frameworkLogPath);

		outLogger("is writing message content as a new File: " + nameOutZipFile);

		try {
			FileOutputStream fos = new FileOutputStream(theZIP);
			byte[] fileContent = msg.getByteSequenceContent();
			int byteLength = (int) fileContent.length;
			fos.write(fileContent, 0, byteLength);
			fos.flush();
			fos.close();
			theZIP = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void handleInform(ACLMessage msg) {
		stepHandleBanner("handleInform", msg);
		outLogger("is unzipping "
				+ (String) getDataStore().get("nameOutZipFile")
				+ " on /nodes/.");

		try {
			PsServices.unzipFolder(
					(String) getDataStore().get("frameworkLogPath")
							+ (String) getDataStore().get("nameOutZipFile"),
					(String) getDataStore().get("frameworkRootPath"));
			outLogger((String) getDataStore().get("nameOutZipFile")
					+ "was unzipped.");

		} catch (Throwable e) {
			outLogger((String) getDataStore().get("nameOutZipFile")
					+ "Error!! was not unzipped.");
			e.printStackTrace();
		}
		finished = true;
	}

	protected void handleRefuse(ACLMessage msg) {
		stepHandleBanner("handleRefuse", msg);
		finished = true;
	}

	protected void handleNotUnderstood(ACLMessage msg) {
		stepHandleBanner("handleNotUnderstood", msg);
		finished = true;
	}

	protected void handleFailure(ACLMessage msg) {
		stepHandleBanner("handleFailure", msg);
		finished = true;
	}

	protected void handleOutOfSequence(ACLMessage msg) {
		stepHandleBanner("handleOutOfSecuence", msg);
		finished = true;
	}

	public boolean done() {
		return finished;
	}

	public void reset() {
		finished = true;
		super.reset();
	}

	public int onEnd() {
		return 0;
	}

	// Private utilities:
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

	private void outLogger(String s) {
		outLogger(new Object[] { getBehaviourName(), theReader.getLocalName(), s });
	}

	private void onStartBanner() {
		if (!debugMode) {
			return;
		}
		String diaLbl = "Diagram of '" + getBehaviourName()
				+ "' Behaviour is shown below:";
		outLogger("Initialized.");
		outLogger(diaLbl + "\n" + sb);

	}

	private void stepHandleBanner(String step, ACLMessage msg) {
		outLogger(new Object[] { getBehaviourName(), theReader.getLocalName(),
				"On [" + step + "] with convID: " + msg.getConversationId() });
		outLogger(
				verboseMode,
				new Object[] {
						getBehaviourName(),
						theReader.getLocalName(),
						"On [" + step + "] with full message description:",
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

}
