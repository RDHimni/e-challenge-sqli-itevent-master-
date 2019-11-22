package dhimni.cloud;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dhimni.cloud.entities.Machine;
import dhimni.cloud.entities.Store;
import dhimni.cloud.exceptions.CreateStoreException;
import dhimni.cloud.state.StopedMachine;
import dhimni.could.factory.FileFactory;
import dhimni.could.factory.MachineFactory;
import dhimni.could.factory.StoreFactory;

public class CloudInfrastructure {
	
	private List<Machine> listmachine ;
	private List<Store> liststores;
	private FileFactory ff;
	private MachineFactory mf;
	private StoreFactory sf;
	
	public CloudInfrastructure() {
      this.listmachine = new LinkedList<>();
      this.liststores = new LinkedList<>();
      
        this.ff=new FileFactory();
        this.mf= new MachineFactory();
        this.sf = new StoreFactory();
		
	}

	public void createStore(String storename) {
       Store storexist = liststores.stream().filter(s->s.getName().equalsIgnoreCase(storename)).findAny().orElse(null);
       if(storexist !=null) throw new CreateStoreException();
       else {
    	   
    	   this.liststores.add(this.sf.getInstance(storename));
       }
	}

	public void uploadDocument(String storename, String ...filename) {
	       Store storexist = liststores.stream().filter(s->s.getName().equalsIgnoreCase(storename)).findAny().orElse(null);

	       if(storexist ==null) throw new CreateStoreException();
	       else {
	    	   Arrays.stream(filename).forEach(f->{
	    	        storexist.getListfiles().add(ff.getInstance(f));
	    	        storexist.setDiskUsed(0.100);
	    	        });	 
	    	   
	       }
	}

	public String listStores() {
	    String Sliststore ="";
		
	if(! this.liststores.isEmpty()) {    
	    for (Store store : liststores) {
	    	if(!Sliststore.contentEquals("")) {
			Sliststore = Sliststore + "||" + store.toString() ;
	    	}else {
				Sliststore = Sliststore + store.toString() ;
	    	}
		}
	}
	    
		return Sliststore;
	}


	public void deleteStore(String storename) {
	       Store storexist = liststores.stream().filter(s->s.getName().equalsIgnoreCase(storename)).findAny().orElse(null);

	       if(storexist != null)this.liststores.remove(storexist);
	       
	       
	}

	public void emptyStore(String storename) {
	       Store storexist = liststores.stream().filter(s->s.getName().equalsIgnoreCase(storename)).findAny().orElse(null);

	       if(storexist != null) {
	    	     storexist.getListfiles().clear();
	  	         storexist.clearDiskUsed();

	       }
	       
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////:://///////////////////////////////:/:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	
	public void createMachine(String machinename, String systeme, String disksize, String ramsize) {
		
	       Machine storexist = listmachine.stream().filter(s->s.getName().equalsIgnoreCase(machinename)).findAny().orElse(null);
	       if(storexist !=null) throw new CreateStoreException();
	       else {
	    	   
	    	   this.listmachine.add(this.mf.getInstance(machinename, systeme, disksize, ramsize));
	       }
		
	}

	public String listMachines() {
      String SlistMachines = "";
		
      if(! this.listmachine.isEmpty()) {
    	  for (int i = 0; i < this.listmachine.size(); i++) {
    		  
    		  
			if(!SlistMachines.equals(""))SlistMachines=SlistMachines +"||" + this.listmachine.get(i);
			else SlistMachines=SlistMachines + this.listmachine.get(i);
    		  
    		  
		}
    	  
      }
      
      
		
		return SlistMachines;
	}

	public void startMachine(String namemachine) {
        Machine machine = listmachine.stream()
        		.filter(m->m.getName().equalsIgnoreCase(namemachine))
        		.findAny()
        		.orElse(null);
        
        if(machine != null)machine.StartMachine();
		
	}

	public void stopMachine(String namemachine) {
        Machine machine = listmachine.stream()
        		.filter(m->m.getName().equalsIgnoreCase(namemachine))
        		.findAny()
        		.orElse(null);
        
        if(machine != null)machine.setState(new StopedMachine());
		String[] s = machine.getMemorySize().split("(?=g)");

		if (machine.getState().toString().equalsIgnoreCase("stopped"))machine.setMemoryUsed();
		
		
		
	}

	
	public double usedMemory(String namemachine) {
		// TODO Auto-generated method stub
		double usedMemory = 0;
        Machine machine = listmachine.stream()
        		.filter(m->m.getName().equalsIgnoreCase(namemachine))
        		.findAny()
        		.orElse(null);
       if (machine != null) usedMemory = machine.getMemoryUsed();
		
		return usedMemory;
	}

	public double usedDisk(String name) {
		// TODO Auto-generated method stub
		double usedDisk = 0;
        Machine machine = listmachine.stream()
        		.filter(m->m.getName().equalsIgnoreCase(name))
        		.findAny()
        		.orElse(null);
        Store store =  liststores.stream()
        		.filter(s->s.getName().equalsIgnoreCase(name))
        		.findAny()
        		.orElse(null);
       if (machine != null) usedDisk = machine.getDiskUsed();
       if (store != null) usedDisk = store.getDiskUsed();

		
		return usedDisk;
	}

	public double globalUsedDisk() {
		// TODO Auto-generated method stub
	   double globalUsedDisk = 0;

	    for (Iterator iterator = listmachine.iterator(); iterator.hasNext();) {
			Machine machine = (Machine) iterator.next();
			globalUsedDisk += machine.getDiskUsed();
		}
	   
		for (Iterator iterator = liststores.iterator(); iterator.hasNext();) {
			Store store = (Store) iterator.next();
			globalUsedDisk += store.getDiskUsed();

		}
	    
		return globalUsedDisk;
	}

	public double globalUsedMemory() {
		// TODO Auto-generated method stub
		   double globalUsedMemory = 0;

		    for (Iterator iterator = listmachine.iterator(); iterator.hasNext();) {
				Machine machine = (Machine) iterator.next();
				globalUsedMemory += machine.getMemoryUsed();
			}
		   
		    
			return globalUsedMemory;
	}

	
	
	

}
