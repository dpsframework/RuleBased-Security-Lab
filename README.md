# Malware-Analysis-Lab



### Abstract

> Malware Analysis Laboratory built using Agents (`Malware-Analysis-Lab`), is an example of a distributed application made up of JADE Agents[1]. This application uses three classes of agents: </br>
> - **Class-A**: Blackboard agent. Responsible for displaying analysis results and managing the flow of analyzes. It is connected to a HSQLite database[2]. It is only required to deploy a single agent of this class. </br>
> - **Class-B**: Agents with integrated expert-system. They use an inference engine with SNORT rules[3], to detect malware through datagram filtering. </br>
> - **Class-C**: Wireshark[4] file reading and conversion agents in .PCAP format. These agents transform the .PCAP datagram files into the plain text format .PCAP.facts (_facts_), which are understandable by the CLIPS[5] or Jess[6] inference engines. </br> </br> 





### 1.5. Brief description of this example
   
> This is an example of agent-oriented application deployment. It uses the JADE Framework[1] and the Middle-ware dpsFramework[7]. This example consists of three agent templates. The agents created from these templates have capabilities to: read and transform .PCAP files[4]; to analyze Malware on the .PCAP files transformed into Facts and; to storage and show functions of the results. 


> The datagram packets with protocols in their headers of UDP and SSDP types have been obtained with Wireshark [4]. This has been done like this, just to simplify this example. The SSDP protocol is characteristic of automatically initiated communications between IoT devices. SSDP is commonly used in home routers with UPnP enabled. This example has been developed for demonstration and academic purposes only.
       
           
   
#### 1.5.1. Keywords:
     
> Rule-based agent; Multi-agent Systems; Intrusion Detection System; development environment



#### 1.5.2. Meta-data:
                        
> * Objective: Annex to the Working Document (2021.03.27). </br>
> * Type of article: Standard working document. </br>
> * Department of: Electrical and Systems Engineering and Automation. University of León. </br>
> * Authors (PhD): Aguayo-Canela FJ<sup>1</sup>, Alaiz-Moretón H<sup>1</sup>, García-Ordás T<sup>1</sup>, Benítez-Andrades JA<sup>2</sup>, Benavides C<sup>1</sup>, and  García-Rodríguez I<sup>1</sup>. </br>
>   * (1) **SECOMUCI Research Group**, Escuela de Ingenierías Industrial e Informática.
>   * (2) **SALBIS Research Group**, Department of Electric, Systems and Automatics Engineering.



   
![Universidad de Leon - Spain](images/marca-logo-color.jpg)

_University of León, Campus of Vegazana s/n, León, 24071 León, Spain_ [9] 
    



----



## 1. Class-{A, B and C} Agents Screenshots (summary)



###  1.1. Class-A: Blackboard agent 

#### **Image 1.** Class-A: Blackboard agent `NIDsBoardAgent`. Responsible for displaying analysis results and managing the flow of analyzes.  

![](images/nidsBoardAgent-00.png)




#### **Image 1 (Left-side).** Class-A: Blackboard agent `NIDsBoardAgent`. Responsible for displaying analysis results and managing the flow of analyzes.  

![](images/nidsBoardAgent-01.png)







#### **Image 1 (Right-side).** Class-A: Blackboard agent `NIDsBoardAgent`. Responsible for displaying analysis results and managing the flow of analyzes. 

![](images/nidsBoardAgent-02.png)








###  1.2.  Class-B: Agents with integrated expert-system

#### **Image 2.** Class-B: Agent `SsdpAgent501` with integrated expert-system: detail file loading sequence of rules that make up the expert system called `CLISP.UDP-Loader.clp`

![](images/ssdpAgent501-00.png)




###  1.3. Class-C: Wireshark[4] .PCAP format file reading and conversion agents.


#### **Image 3.** Class-C: `WatchdogAgent201` agent: a Wireshark[4] .PCAP format file reading and conversion agent.

![](images/watchdog201-00.png)









### 1.4. JADE-RMA agent with DF services window deployed


#### **Image 4.** JADE RMA agent: detail of the distributed application `Malware-Analysis-Lab`, deployed on JADE multi-agent platform. 


![](images/rmaJade1099-00.png)









----



## 2. Screenshot gallery


----





###  2.1. Class-A: Blackboard agent `NIDsBoardAgent` detailed



#### 2.1.1. How to create a `NIDsBoardAgent` agent from scratch

#### **Image 5.** `NIDsBoardAgent`: creation from command line 



![](images/nidsBoardAgent-211-01.png)



#### 2.1.2. How to launch the blackboard agent `NIDsBoardAgent` on the JADE platform

#### **Image 6.** `NIDsBoardAgent`: launch the agent 


![](images/nidsBoardAgent-212-02.png)







#### 2.1.3. What are and how to access the variables of the board-agent `NIDsBoardAgent` at runtime

#### **Image 7.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 1). 


![](images/nidsBoardAgent-213-01.png)





| Variable     | Current value |
|:----------  |:-------  |
| frameworkConfigPath   |   ~/research/Malware-Analysis-Lab/config/    |
| NEGATIVO   |   Oops____!   |
| relativeConfigPath   |   nodes/NIDsBoardAgent/config/   |
| relativeBoardPath   |   nodes/NIDsBoardAgent/   |
| boardName   |   NIDsBoardAgent   |
| AFIRMATIVO   |   Correct !   |
| frameworkRootPath   |   ~/research/Malware-Analysis-Lab/   |
| nodeVarPath   |   ~/research/Malware-Analysis-Lab/nodes/NIDsBoardAgent/var/   |
| myGui   |   com.dpsframework.PsBoardAgentGui[frame0,223,63,1103x649,invalid,layout=java.awt.BorderLayout,title=TE.NIDsBoardAgent@127.0.0.1:1099/JADE. DataBase type: 'HSQLDB',resizable,normal,defaultCloseOperation=DO_NOTHING_ON_CLOSE,rootPane=javax.swing.JRootPane[,8,31,1087x610,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]   |
| nodeEnginePath   |   ~/research/Malware-Analysis-Lab/nodes/NIDsBoardAgent/engine/   |
| b2nr   |   B2NREResponder@17ea484   |
| NEGATIVE   |   Oops____!   |
| myAgent   |   com.dpsframework.PsBoardAgent@ce5102   |
| nodeRootPath   |   ~/research/Malware-Analysis-Lab/nodes/NIDsBoardAgent/   |
| testArea   |   {}   |
| jamo   |   JAMONodeManagement2@f7597   |
| boardVarPath   |   ~/research/Malware-Analysis-Lab/nodes/NIDsBoardAgent/var/   |
| TICKET_DB_FILE_NAME   |   ticketDB   |
| mySd   |   jade.domain.FIPAAgentManagement.ServiceDescription@ed63ba   |
| myNode   |    NLayer:com.dpsframework.PsNodeSettings@fb86c   |
| myDfd   |   jade.domain.FIPAAgentManagement.DFAgentDescription@40799e   |
| boardConfigPath   |   ~/research/Malware-Analysis-Lab/nodes/NIDsBoardAgent/config/   |
| myBOB   |   {0C:1:3:bcpb:basal:bhv.bcpb.bsh=BoardCapabilitiesLoader2@1b86575, 00:0:1:jamo:basal:bhv.jamo.bsh=JAMONodeManagement2@f7597, A0:3:5:b2nr:basal:bhv.b2nr.bsh=B2NREResponder@17ea484, 0B:3:5:grid:basal:bhv.grid.bsh=BoardGridLocal@1edf921}   |
| nodeConfigPath   |   ~/research/Malware-Analysis-Lab/nodes/NIDsBoardAgent/config/   |
| grid   |   BoardGridLocal@1edf921   |
| jconsole   |   BeanShell Console Class adapted to JADE, for Windows, GNU-Linux and OS-X operating systems.   |
| DATABASE_PASSWORD   |   password   |
| AFFIRMATIVE   |   Correct !   |
| myDB   |   org.hsqldb.jdbc.JDBCConnection@d95940   |
| dbConnection   |   jdbc:hsqldb:file:nodes/NIDsBoardAgent/var/data/ticketDB;ifexits=true   |
| nodeProp2   |   {ps.node.behaviour-grid=yes, ps.node.agent.framework-board-name=NIDsBoardAgent, ps.node.agent.verbose.mode=yes, ps.node.behaviour-b2nr=yes, //=, ps.node.agent.framework-board-service=ticket-board, ps.node.agent.framework-owner-name=UniLeon, ps.node.behaviour-jamo=yes, ps.node.behaviour-bcpb=yes, ps.node.agent.debugging.mode=yes, ps.node.agent.default-execution-level=1}   |



#### **Table 1.** Result of:  `for ( t : this .variables ) { print( t + ": ____ " + eval( t )); }` from agent JADE-Shell.



#### **Image 8.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 2). 

![](images/nidsBoardAgent-213-02.png)






#### **Image 9.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 3). 

![](images/nidsBoardAgent-213-03.png)








#### **Image 10.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 4). 

![](images/nidsBoardAgent-213-04.png)



* One of the important objects for the blackboard agent is `myDB`.
* It is always present in this class of agents and offers direct access to the database.
* Can be disassembled with `javap(myDB);` 





#### **Image 11.**  `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 5).

![](images/nidsBoardAgent-213-05.png)



```java

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
```







#### **Image 12.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 6).

![](images/nidsBoardAgent-213-06.png)




### 2.2. Class-B: `SsdpAgent501` Agent with integrated expert-system: build details



#### 2.2.1. How to create an `SsdpAgent501` agent from scratch

#### **Image 13.** `SsdpAgentXXX`: create from command line

![](images/ssdpAgent501-221-01.png)









#### 2.2.2. How behaviors are edited and expert-system is managed in each agent `SsdpAgentXXX` 

#### **Image 14.** `SsdpAgentXXX`: Incorporation of **Detailed Report ** with dates and identifiers of the datagrams that have produced the alert. 

![](images/ssdpAgent501-222-01.png)

* It incorporates a `assert` at the end of each rule you want to be part of the **Detailed Report**.

* Required values are incorporated in the so-called `detailed_report` template. This generates _facts_ in the Working-Memory that are used at the end of the analysis with the lowest priority rule `generate_inform`.





#### **Image 15.** `SsdpAgentXXX`: Editing the load behavior of the capabilities `acpb` agent expert system Integrated (part 1).

![](images/ssdpAgent501-222-02.png)









#### **Image 16.** `SsdpAgentXXX`: Editing the load behavior of the capabilities `acpb` agent expert system Integrated (part 2).

![](images/ssdpAgent501-222-03.png)





#### **Image 17.** `SsdpAgentXXX`: Activation of the `acpb` behavior aimed at initializing the Agent's Capabilities with an expert system. 

![](images/ssdpAgent501-222-04.png)





















### 2.3. Class-C: Wireshark[4] .PCAP format file reading and conversion agents: build details




#### 2.3.1. How to customize an `WatchdogAgentXXX` agent from JADE-Shell and Editor


#### **Image 18.** `WatchdogAgentXXX`: launch test to read Wireshark .pcap files.

![](images/watchdogAgent201-231-00.png)





#### **Image 19.** `WatchdogAgentXXX`: Wireshark .pcap file detailed results about datagrams.

![](images/watchdogAgent201-231-01.png)




#### **Image 20.** `WatchdogAgentXXX`: how to make a new Service inside of agents.

![](images/watchdogAgent201-231-02.png)


| Variable     | Current value |
|:----------  |:-------  |
| framework.config.path                    |  ==>  ~/research/Malware-Analysis-Lab/config/ |
| framework.root.path                      |  ==>  ~/research/Malware-Analysis-Lab/ |
| framework.name                           |  ==>  Malware-Analysis-Lab |
| framework.bin.path                       |  ==>  null |
| framework.nodes.path                     |  ==>  ~/research/Malware-Analysis-Lab/nodes/ |
| framework.log.path                       |  ==>  ~/research/Malware-Analysis-Lab/logs/ |
| framework.var.path                       |  ==>  ~/research/Malware-Analysis-Lab/var/ |
|----------  |-------  |
| node.config.path                         |  ==>  ~/research/Malware-Analysis-Lab/nodes/WatchdogAgent201/config/ |
| node.engine.path                         |  ==>  ~/research/Malware-Analysis-Lab/nodes/WatchdogAgent201/engine/ |
| node.var.path                            |  ==>  ~/research/Malware-Analysis-Lab/nodes/WatchdogAgent201/var/ |
| node.root.path                           |  ==>  ~/research/Malware-Analysis-Lab/nodes/WatchdogAgent201/ |
| node.name                                |  ==>  WatchdogAgent201 |
|----------  |-------  |
| relative.node.path                       |  ==>  nodes/WatchdogAgent201/ |
| relative.config.path                     |  ==>  nodes/WatchdogAgent201/config/ |
| relative.var.path                        |  ==>  nodes/WatchdogAgent201/var/ |
| relative.engine.path                     |  ==>  nodes/WatchdogAgent201/engine/ |
|----------  |-------  |
| engine.requested                         |  ==>  none |
| engine.selected                          |  ==>  none |
|----------  |-------  |
| agent.name                               |  ==>  WatchdogAgent201@127.0.0.1:1099/JADE |
| agent.local.name                         |  ==>  WatchdogAgent201 |
|----------  |-------  |
| ps.framework.app.author                  |  ==>  UniLeon |
| ps.framework.keypasswd                   |  ==>  password |
| ps.framework.app.created                 |  ==>  Date |
| ps.framework.app.objective               |  ==>  You can simulate multiple lines with /n symbol. |
| ps.framework.node.serie                  |  ==>  WatchdogAgent204,WatchdogAgent201,SsdpAgent515,SsdpAgent501,NIDsBoardAgent,WatchdogAgent000 |
| ps.framework.name                        |  ==>  Malware-Analysis-Lab |
| ps.framework.publickey                   |  ==>  asfjksd98843.9692adsf |
| ps.framework.app.title                   |  ==>  Malware Analysis Laboratory through JADE Agents |
| ps.framework.app.nativelib               |  ==>   |
|----------  |-------  |
| ps.node.agent.framework-board-service    |  ==>  ticket-board |
| ps.node.agent.time-to-agenda             |  ==>  180000 |
| ps.node.agent.tickets-from-phase         |  ==>  0 |
| ps.node.agent.framework-owner-name       |  ==>  SECOMUCI |
| ps.node.agent.clips-pattern-serie        |  ==>   |
| ps.node.agent.tickets-until-phase        |  ==>  -1 |
| ps.node.agent.trusted.list               |  ==>  NIDsBoardAgent,WatchdogAgent201 |
| ps.node.agent.execution-level-5-name     |  ==>  level.05.bsh |
| ps.node.agent.jess-pattern-serie         |  ==>   |
| ps.node.agent.execution-level-3-name     |  ==>  level.03.bsh |
| ps.node.agent.dewey-description-capability |  ==>  PCAP file Reader and Transformer into .facts files |
| ps.node.agent.execution-level-6-name     |  ==>  level.06.bsh |
| ps.node.agent.time-to-board              |  ==>  8405 |
| ps.node.agent.execution-level-0-name     |  ==>  level.00.bsh |
| ps.node.agent.inference-firing-mode      |  ==>  2 |
| ps.node.agent.inference-cycles           |  ==>  10000 |
| ps.node.agent.default-execution-level    |  ==>  1 |
| ps.node.agent.debugging.mode             |  ==>  1 |
| ps.node.agent.framework-board-name       |  ==>  NIDsBoardAgent |
| ps.node.agent.inference-cycles-serie     |  ==>  50,100,500,5000,10000 |
| ps.node.agent.behaviour-pattern-serie    |  ==>  3277,4033,4681,8321,15841,29341,42799,90751 |
| ps.node.agent.time-to-agenda-serie       |  ==>  5000,30000,180000 |
| ps.node.agent.time-to-board-serie        |  ==>  1107,2047,8401,23521,55969,97567 |
| ps.node.agent.dewey-code-capability      |  ==>  UDP-SSDP |
| ps.node.agent.verbose.mode               |  ==>  1 |
| ps.node.agent.execution-level-1-name     |  ==>  level.01.bsh |




#### **Table 2.** Access to `myNode` object with:  `myNode .getProperties();` from agent JADE-Shell.



#### **Image 21.** `WatchdogAgentXXX`: how develop new Behaviours on Java files.

![](images/watchdogAgent201-231-03.png)




#### **Image 22.** `WatchdogAgentXXX`: how to customize agent properties.

![](images/watchdogAgent201-231-04.png)




#### **Image 23.** `WatchdogAgentXXX`: how to build new test.

![](images/watchdogAgent201-231-05.png)













---- 






  
   
##  3. How to build an agent-development environment with `dpsFramework`


### 3.1. Download Middle-ware  dpsFramework: [dpsFrameworkBuilder-full-1.8.jar]

  * From URL Web: https://github.com/dpsframework/dpsFrameworkBuilder/releases/tag/1.8
  * Or, from command-line with:

```bash
  $ wget https://github.com/dpsframework/dpsFrameworkBuilder/releases/download/1.8/dpsFrameworkBuilder-full-1.8.jar
```




### 3.2. Set the CLASSPATH variable: 

```bash
  $ export CLASSPATH=lib/*:      (Unix / OS X)
  > set    CLASSPATH=lib/*;      (Windows OS)
```



### 3.3. Create a new agent-development environment: 

```bash
  $ java -jar dpsFrameworkBuilder-full-1.8.jar --new=My-Agent-App
  $ cd My-Agent-App
```

 


  
   
##  4. How to create this `Malware-Analysis-Lab` application example

Step-by-step installation process detail: 

### 4.1. Download Middle-ware  dpsFramework: [dpsFrameworkBuilder-full-1.8.jar]

  * From: https://github.com/dpsframework/dpsFrameworkBuilder/releases/tag/1.8
  * Or from command-line with:

```bash
  $ wget https://github.com/dpsframework/dpsFrameworkBuilder/releases/download/1.8/dpsFrameworkBuilder-full-1.8.jar
```




### 4.2. Set the CLASSPATH variable: 

```bash
  $ export CLASSPATH=lib/*:lib/pcap/*:      (Unix / OS X)
  > set    CLASSPATH=lib/*;lib/pcap/*;      (Windows OS)
```



### 4.3. Create a new JADE application: 

```bash
  $ java -jar dpsFrameworkBuilder-full-1.8.jar --new=Malware-Analysis-Lab
```




### 4.4. Prepare this new application, to incorporate the agents into it: 

```bash
  $ cd Malware-Analysis-Lab
  $ mv README.md   README.md_APP
  $ mv config      config_APP
  $ git init .
```
        
        


### 4.5. Update local Working-directory with this GitHub repository: 


```bash
  $ git branch -M master
  $ git remote add origin https://github.com/dpsframework/Malware-Analysis-Lab.git
  $ git pull origin master
```




### 4.6. (Optional) Freeing local Working-directory from GitHub's `origin`


```bash
  $ git remote remove origin
```





## 5. How to deploy this `Malware-Analysis-Lab` application example

From command-line and on the application directory `Malware-Analysis-Lab` type:


### 5.1. Launch of JADE multi-agent platform on `localhost`: 

```bash
  $      java launcher platform localhost  &        (Linux  and  OS X)
  
 > start java launcher platform localhost           (Windows OS)
```

### 5.2. Launch **Class-A**: Blackboard agent `NIDsBoardAgent`:

```bash
  $      java launcher board localhost NIDsBoardAgent  &     (Linux  and  OS X)
  
 > start ...                                                 (Windows OS)
```

### 5.3. Launch of **Class-B**: Agents with integrated expert-system: `SsdpAgentXXX`:

```bash
  $   java launcher stage-node localhost SsdpAgent501  CLIPS   &      (Linux  and  OS X)
  $   java launcher stage-node localhost SsdpAgent515   JESS   &      (Linux  and  OS X)

 > start java launcher stage-node localhost SsdpAgent501  CLIPS       (Windows OS)
 > start java launcher stage-node localhost SsdpAgent515  JESS        (Windows OS)
 
```


### 5.4. Launch of **Class-C**: Wireshark[4] file reading and conversion agents in .PCAP format. `WatchdogAgentYYY`:

```bash
  $   java launcher monitor localhost WatchdogAgent201  &     (Linux  and  OS X)


 > start ...                                                  (Windows OS)
```

 
      
 

        

      

## 6. How to put the application  `Malware-Analysis-Lab` into operation 


### 6.1. Raising the level of execution of Agents to "5": 

    * (With mouse ...) From the graphical interface of the agents, click on button [5] on the menu bar. 
                              


### 6.2. Start malware scan: 


```bash
  $ cp  pcap/examples/case01.pcap   var/pending/.     (Linux  and  OS X)
  $ cp  pcap/examples/case02.pcap   var/pending/.

 > copy ...                                           (Windows OS)
```




----



## 7. Conclusions  

* This example is currently in development process.
  * Last revision: April 2nd, 2021.


* Appendix B. GNU General Public License: NO WARRANTY
  * 11. BECAUSE THE PROGRAM IS LICENSED FREE OF CHARGE, THERE IS NO WARRANTY FOR THE PROGRAM, TO THE EXTENT PERMITTED BY APPLICABLE LAW. EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR OTHER PARTIES PROVIDE THE PROGRAM "AS IS" WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE PROGRAM IS WITH YOU. SHOULD THE PROGRAM PROVE DEFECTIVE, YOU ASSUME THE COST OF ALL NECESSARY SERVICING, REPAIR OR CORRECTION.

  * 12. IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING WILL ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY AND/OR REDISTRIBUTE THE PROGRAM AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY GENERAL, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR INABILITY TO USE THE PROGRAM (INCLUDING BUT NOT LIMITED TO LOSS OF DATA OR DATA BEING RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD PARTIES OR A FAILURE OF THE PROGRAM TO OPERATE WITH ANY OTHER PROGRAMS), EVEN IF SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.









## References





[1]: **JADE Platform**. <http://jade.tilab.com/>. CSELT, S. & TILab, S. (2017). Jade - java agent development framework. is a framework to develop multi-agent systems in compliance with the fipa specifications. jade 4.5.0 - revision 6825 of 23-05-2017 10:06:04. Open Source, under LGPL restrictions.

[2]: **HyperSQL**: HSQLDB - 100% Java Database. <http://hsqldb.org/>

[3]: **Snort** - Network Intrusion Detection & Prevention System. (n.d.). Retrieved April 1, 2021, from https://www.snort.org/


[4]: **(PDF) Network forensics analysis using Wireshark.** https://www.researchgate.net/publication/281573989_Network_forensics_analysis_using_Wireshark (accessed Mar. 23, 2021).


[5]: **CLIPS**. [**1**] Giarratano, J. C. P. (2014). CLIPS User’s Guide. Version 6.30. CLIPS.  [**2**] Riley, G. (2016). Clips rule based programming language expert system tool clips (6.31) and CLIPSJNI (0.5), clips rule based programming language web site. Available in: <https://sourceforge.net/projects/clipsrules/>.


[6]: **JESS**.  [**1**]Friedman-Hill, E.: JESS, Expert System Software Tool (8.0a1 (alfa)). Sandia National Laboratories. <https://www.jessrules.com/> (2016). [**2**] Friedman-Hill, E. (2003). JESS in Action. Manning Greenwich, CT. [**3**] Cardoso, H. L. (2007). Integrating jade and jess. available in: <https://jade.tilab.com/documentation/examples/jess/>.


[7]: **_dpsFramework_ GitHub Repositories**. <https://github.com/dpsframework>

[8]: **BeanShell**. [**1**] Niemeyer, P.: Lightweight Scripting for Java. <http://www.beanshell.org/> (2014). [**2**] Nick Lombard, BeanShell at GitHub <https://github.com/beanshell/beanshell>. 


[9]: **Leon University** (SPAIN). <http://www.unileon.es>.  **Departamento de Ingeniería Eléctrica y de Sistemas y Automática**. Universidad de León. <https://departamentos.unileon.es/ingenieria-electrica-y-de-sistemas-y-automatica/>


[10]: **RSyntaxTexArea**. A syntax highlighting, code folding text editor for Java Swing applications. . <https://github.com/bobbylight/RSyntaxTextArea/> (2017).

[11]: **Yellow pages JADE Service**. [**1**] Bellifemine, F.L., Caire, G., Greenwood, D.: Developing Multi-Agent Systems with JADE. Wiley Series in Agent Technology. (2007). [**2**] Cancedda, P. & Caire, G. (2010). JADE Tutorial Creating Ontologies by means of the Bean-Ontology Class, volume 15-April-2010 - JADE 4.0. Telecom Italia S.p.A. [**3**] Yellow Pages examples: <https://jade.tilab.com/documentation/examples/yellow-pages/>

[12]: **java - Read Packet Content using pcap4j - Stack Overflow.** https://stackoverflow.com/questions/62975959/read-packet-content-using-pcap4j (accessed Mar. 23, 2021).

[13]: **Trabajando con Sockets UDP.** http://www.it.uc3m.es/celeste/docencia/cr/2003/PracticaSocketsUDP/ (accessed Mar. 19, 2021).

[14]: **Parse PCAP files in Java.** https://www.javahelps.com/2017/08/parse-pcap-files-in-java.html (accessed Mar. 26, 2021).

[15]: **Parsing pcap taken from Wireshark file using - Java - Stack Overflow.** https://stackoverflow.com/questions/31630646/parsing-pcap-taken-from-Wireshark-file-using-java (accessed Mar. 23, 2021).


[16]: **Ransomware PCAP repository.** http://dataset.tlm.unavarra.es/ransomware/ (accessed Mar. 23, 2021).

[17]: **SSDP - The Wireshark Wiki.** https://wiki.Wireshark.org/SSDP (accessed Mar. 23, 2021).

[18]: **SQuirreL SQL Client Home Page.** http://squirrel-sql.sourceforge.net/ (accessed Mar. 30, 2021).


[19]: **Chapter 1. Running and Using HyperSQL.** http://www.hsqldb.org/doc/2.0/guide/running-chapt.html (accessed Mar. 30, 2021).

[20]: **Java Platform Standard Edition 8 Documentation.** https://docs.oracle.com/javase/8/docs/ (accessed Mar. 30, 2021).

[21]: **Java SE Development Kit 8 - Downloads.** https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html (accessed Mar. 30, 2021).


[22]: **Multi-Agent Systems**. Wooldridge, M. (2009). An Introduction to MultiAgent Systems, Second Edition. John Wiley & Sons Ltd. 

[23]: **FIPA ACL**. [FIPA00008] FIPA Agent Communication Language Specification. Foundation for Intelligent Physical Agents, 2000. http://www.fipa.org/specs/fipa00008/ 

