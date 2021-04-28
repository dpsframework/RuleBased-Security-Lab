
## Document title:  _Enriched multi‑agent middleware for building rule‑based distributed security solutions for IoT environments_

#### The Journal of Supercomputing

https://doi.org/10.1007/s11227-021-03797-2

Accepted: 5 April 2021.

© The Author(s), under exclusive licence to **Springer Science+Business Media**, LLC, part of **Springer Nature  2021**

Francisco José Aguayo‑Canela<sup>1</sup>  ·  Héctor Alaiz‑Moretón<sup>1</sup>  ·  María Teresa García‑Ordás<sup>1</sup>  ·  José Alberto Benítez‑Andrades<sup>2</sup>  ·  Carmen Benavides<sup>2</sup>  · Isaías García‑Rodríguez<sup>1</sup>

:email: José Alberto Benítez-Andrades. <_jbena AT  unileon  DOT es_>


<sup>(1)</sup>  _**SECOMUCI Research Group**_, School of Industrial Engineering and Informatics.<br>
<sup>(2)</sup>  _**SALBIS Research Group**_, Department of Electric, Systems and Automatics Engineering.


![Universidad de Leon - Spain](images/marca-logo-color.jpg)  
Universidad de León[9] (_Spain_) 



## 1. Example name: _Malware-Analysis-Lab_


> This _Malware Analysis Laboratory_ is an example of a distributed application made up of JADE Agents[1]. This example uses three main agent classes:


* **Blackboard-Class**: The blackboard-class agents are responsible for displaying analysis results, managing the flow of analyzes and, update lastest Malware Rules from SNORT-Community[3]. This type of agents are connected to a HSQLite database[2].


* **Analyzer-Class**: This type of agents have an integrated CLIPS[5] or Jess[6] expert-system. They use the SNORT[3] Rules inside of its Working-Memory to detect malware on TCP, IP or UDP datagrams.


* **Reader-Monitor-Class**: They are agents with reading .PCAP file format capabilities. They can to transform datagram segments in (facts) format files, which are understandable by CLIPS[5] or Jess[6] inference engines.

 
Malware Analysis Laboratory example foccuses on implementation and testing of an intrusion detection system which uses an agent-oriented distributed application deployment. It uses the JADE Framework[1] and the Middle-ware dpsFramework[7].  This example has been developed for demonstration and academic purposes only.

     

----

   
### 1.1. How to deploy this _Malware-Analysis-Lab_ 


1. Download dpsFramework[7] middleware  from:
   * https://github.com/dpsframework/dpsFrameworkBuilder/releases/download/1.8/dpsFrameworkBuilder-full-1.8.jar

1. Create a new Agent-Development Environment with: 
   * ` $ java -jar dpsFrameworkBuilder-full-1.8.jar --new=Malware-Analysis-Lab`
   * ` $ cd Malware-Analysis-Lab`

1. Adapt application skeleton to the new Agents of this example with: 
   * ` $ mv README.md   README.old`
   * ` $ mv config      config_Old`

1. Initialize the Git _Malware-Analysis-Lab_ local repository with:
   * ` $ git init . `

1. Update _Malware-Analysis-Lab_ local repository with:
   * ` $ git branch -M master`
   * ` $ git remote add origin https://github.com/dpsframework/Malware-Analysis-Lab.git`
   * ` $ git pull origin master`

1. Remove the remote-repository from _Malware-Analysis-Lab_ with:
   * ` $ git remote remove origin`


### 1.2 How to run this _Malware-Analysis-Lab_

1. Set **CLASSPATH** variable: 
   * ` $  export CLASSPATH=lib/*:lib/pcap/*:  ` (Unix / OS X)
   * ` $  set    CLASSPATH=lib/*;lib/pcap/*;  ` (Windows OS)

1. Launch the **JADE** multi-agent platform on **localhost** with: 
   * ` $ java       launcher platform localhost  & `     (Linux & OS-X)
   * ` $ start java launcher platform localhost `        (Windows)

1. Launch a Blackboard-Class Agent **NIDsBoardAgent** with:
   * ` $       java launcher board localhost NIDsBoardAgent  &`  (Linux & OS-X)
   * ` $ start java launcher board localhost NIDsBoardAgent `    (Windows)

1. Launch an Analyzer-Class Agent **SsdpAgent501** with:
   * ` $       java launcher stage-node localhost SsdpAgent501 CLIPS  &`  (Linux & OS-X)
   * ` $ start java launcher stage-node localhost SsdpAgent501 CLIPS `    (Windows)

1. Launch an Analyzer-Class Agent **SsdpAgent515** with:
   * ` $       java launcher stage-node localhost SsdpAgent515 Jess  &`  (Linux & OS-X)
   * ` $ start java launcher stage-node localhost SsdpAgent515 Jess `    (Windows)

1. Launch an Reader-Monitor-Class Agent **WatchdogAgent201** with:
   * ` $       java launcher monitor localhost WatchdogAgent201  &`  (Linux & OS-X)
   * ` $ start java launcher monitor localhost WatchdogAgent201 `    (Windows)

1. From the graphical interface of the agents, raise their execution level up to `5`  with:
   * Click on button [5] on the menu bar.

1. From command-line, start the malware scan with:
   * ` $ cp    pcap/examples/case01.pcap   var/pending/.`     (Linux & OS-X)
   * ` $ copy  pcap/examples/case01.pcap   var/pending/. `    (Windows)



### 1.3. Blackboard-Class Agents screenshot gallery





![](images/nidsBoardAgent-00.png)  
<img src="images/nidsBoardAgent-00.png" width="180">
**Image 1.** Firt tab of GUI from a Blackboard-Class Agent named `NIDsBoardAgent`. 


![](images/nidsBoardAgent-01.png)    
**Image 1 (Left-side).** The Blackboard-Class Agent named `NIDsBoardAgent`


![](images/nidsBoardAgent-02.png)    
**Image 1 (Rigth-side).** The Blackboard-Class Agent named `NIDsBoardAgent`


![](images/nidsBoardAgent-211-01.png)    
**Image 5.** `NIDsBoardAgent`: creation from command line 


![](images/nidsBoardAgent-212-02.png)    
**Image 6.** `NIDsBoardAgent`: launch the agent 


![](images/nidsBoardAgent-213-01.png)    
**Image 7.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 1). 


 
![](images/nidsBoardAgent-213-02.png)    
**Image 8.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 2). 


![](images/nidsBoardAgent-213-03.png)    
**Image 9.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 3). 



![](images/nidsBoardAgent-213-04.png)    
**Image 10.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 4). 


![](images/nidsBoardAgent-213-05.png)    
**Image 11.**  `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 5).


![](images/nidsBoardAgent-213-06.png)    
**Image 12.** `NIDsBoardAgent`: Development environment utilities incorporated into the blackboard agent (part 6).











### 1.4. Analyzer-Class Agents screenshot gallery


![](images/ssdpAgent501-00.png)    
**Image 2.** Analyzer-Class  Agent `SsdpAgent501` with integrated expert-system: detail file loading sequence of rules that make up the expert system called `CLISP.UDP-Loader.clp`



![](images/ssdpAgent501-221-01.png)    
**Image 13.** `SsdpAgentXXX`: create from command line



![](images/ssdpAgent501-222-01.png)    
**Image 14.** `SsdpAgentXXX`: Incorporation of **Detailed Report ** with dates and identifiers of the datagrams that have produced the alert. 



![](images/ssdpAgent501-222-02.png)    
**Image 15.** `SsdpAgentXXX`: Editing the load behavior of the capabilities `acpb` agent expert system Integrated (part 1).


 
![](images/ssdpAgent501-222-03.png)    
**Image 16.** `SsdpAgentXXX`: Editing the load behavior of the capabilities `acpb` agent expert system Integrated (part 2).


 
![](images/ssdpAgent501-222-04.png)    
**Image 17.** `SsdpAgentXXX`: Activation of the `acpb` behavior aimed at initializing the Agent's Capabilities with an expert system. 









### 1.5. Reader-Monitor-Class Agents screenshot gallery


![](images/watchdog201-00.png)    
**Image 3.** Analyzer-Class Agent `WatchdogAgent201` file reading and conversion agent.


![](images/rmaJade1099-00.png)    
**Image 4.** JADE RMA agent: detail of the distributed application `Malware-Analysis-Lab`, deployed on JADE multi-agent platform. 



![](images/watchdogAgent201-231-00.png)    
**Image 18.** `WatchdogAgentXXX`: launch test to read Wireshark .pcap files.



![](images/watchdogAgent201-231-01.png)    
**Image 19.** `WatchdogAgentXXX`: Wireshark .pcap file detailed results about datagrams.



![](images/watchdogAgent201-231-02.png)    
**Image 20.** `WatchdogAgentXXX`: how to make a new Service inside of agents.



![](images/watchdogAgent201-231-03.png)    
**Image 21.** `WatchdogAgentXXX`: how develop new Behaviours on Java files.



![](images/watchdogAgent201-231-04.png)    
**Image 22.** `WatchdogAgentXXX`: how to customize agent properties.


 
![](images/watchdogAgent201-231-05.png)    
**Image 23.** `WatchdogAgentXXX`: how to build new test.




---- 



## 2. References



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

