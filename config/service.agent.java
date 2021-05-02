//# Revised:   2021.04.28                               
//#            [ RuleBased-Security-Lab example ]
//# ------------------------------------------------



//# /////////////////////////////////////////////
//# Technique: myBOBActivated JADE-HashMap
myBOBActivated  = new jade.util.leap.HashMap();
nodeProp2 		= new jade.util.leap.Properties();
nodeProp2.load( nodeConfigPath + "node.properties" );

myBOB.clear();


//An emulate version of {service and systemctl} from Centos 7 - RHEL 
//@author:  fjac et al. - SECOMUCI Research Group - UniLeon (2021).

//------------------------------------------
//service() A Java Scripted Object (Closure)
//------------------------------------------
service(){
	// ------------------------------------------
	SERVICE = ".service";
	LOADER  = ".loader.java";
	// ------------------------------------------
	public  boolean serviceExists( String nameService ){
    sExists = false;
		for( sn : this.list() ){
			if( sn.equals( nameService ) ){
				sExists = true;
			}
		}
		return sExists;
	}
	
	
	
	// ------------------------------------------
	public  boolean serviceExists(){
    sExists = false;
		return sExists;
	}

	
	
	// ------------------------------------------
	public  boolean enable(String  nameService ) {
		if ( this.serviceExists(nameService) ){
			serviceProp = new jade.util.leap.Properties();
			serviceProp.load( myNode .nodeConfigPath + nameService + this.SERVICE );
			serviceProp .setProperty( "service.enable", "1");	
			serviceProp.store( myNode .nodeConfigPath + nameService + this.SERVICE );
			return true;
			
		} else {
			print(  "Usage: service().enable( nameOfService );");
			return false;
		}
		
	}
	
	
	// ------------------------------------------
	public  boolean disable(String  nameService ) {
		if ( this.serviceExists(nameService) ){
			serviceProp = new jade.util.leap.Properties();
			serviceProp.load( myNode .nodeConfigPath + nameService + this.SERVICE );
			serviceProp .setProperty( "service.enable", "0");	
			serviceProp.store( myNode .nodeConfigPath + nameService + this.SERVICE );
			return true;
			
		} else {
			print(  "Usage: service().disble( nameOfService );");
			return false;
		}
		
	}
	
	
	// ------------------------------------------
	public  boolean enable( ) {
		print(  "Usage: service().enable( nameOfService );");
		return false;
	}
	
	
	
	public  boolean disable( ) {
		print(  "Usage: service().disable( nameOfService );");
		return false;
	}
	
	
	
	
	// ------------------------------------------
	public String[]  BOB() {	
		
		String   summaryTest   = "";
		String[] sTest;
		String[] sfNames       = this.listFS();	
		String   sName         = "";
		String   firstColon    = "";
		
		for ( sfn : sfNames ) {	
			
			sName = sfn.split(this.SERVICE)[0];
			serviceProp = new jade.util.leap.Properties();
			serviceProp.load( myNode .nodeConfigPath + sfn );
						
			summaryTest = 
					serviceProp .getProperty( "service.order",            "UU") + ":" +
					serviceProp .getProperty( "init.level" ,               "7") + ":" +
					serviceProp .getProperty( "run.level",                 "0") + ":" +
					serviceProp .getProperty( "service.name",          "noName") + ":" +
					serviceProp .getProperty( "service.group",         "group") + ":" +
					serviceProp .getProperty( "service.launcher", sName+this.LOADER ) + ":" +
					serviceProp .getProperty( "service.enable",            "0") + ":" +
					serviceProp .getProperty( "service.description", "Service") +
					firstColon + summaryTest;
			firstColon = "@@";
		}
		sTest = summaryTest.split("@@");
		return sTest;
	}
	

	public String status(){
		return myBOB() .perspective();
	}
	
	// ------------------------------------------
	public String BOB( String serviceName ){
		
		String sBOB = "";	sExists = false;
		
		for( sn : this.list() ){
			if( sn.equals(serviceName)){
				sExists = true;
			}
		}
		
		if( !sExists ) { return "Usage: service() .BOB( serviceName ); ";}
		
		
		for( sb : this.BOB()  ){
			if( sb.split(":")[3].equals(serviceName)){
				sBOB = sb;
			}
		}
		return sBOB;
		
	}
	
	

	public String status( String sN ){
		return this.BOB( sN );
	}
	
	
	
	// ------------------------------------------
	public  String[] list(){
		String[]    fs = this.listFS();
		String[]    sNames;
		String      sRaw   = ""; 
    String      fColon = "";
		
		for( sn : fs){
			sRaw = sn.split(this.SERVICE)[0] + fColon + sRaw;
			fColon = ",";
		}
		// print("sRaw="+sRaw);
		sNames = sRaw.split(",");
		return sNames;
	}
	
	
	
	
	// ------------------------------------------
	public  String[] listFS(){
		File 		dirConfig = new File ( myNode.nodeConfigPath);
		String[]    fileNames = dirConfig.list();
		String      sfileRaw = "";
		String[]    sfileNames;
		String      firstColon = "";

		for (int i = 0; i < fileNames.length ; i++) {
			File serviceFile = new File(myNode.nodeConfigPath+fileNames[i]);
			if ( serviceFile.isFile()) {
				if ( fileNames[i].endsWith(this.SERVICE) ) {
						sfileRaw = fileNames[i] + firstColon + sfileRaw ;
						firstColon="@@";
				}
			}
		}	
		sfileNames = sfileRaw.split("@@");
		return sfileNames;
	}
	
	return this;
}


