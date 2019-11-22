package dhimni.could.factory;

import dhimni.cloud.entities.Machine;

public class MachineFactory {

	public Machine getInstance(String Name,String Systeme,String DiskSize,String MemorySize){
		return new Machine(Name, Systeme, DiskSize, MemorySize);
	}
	
}
