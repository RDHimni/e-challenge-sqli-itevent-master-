package dhimni.cloud.entities;

import java.util.Arrays;
import java.util.List;

import dhimni.cloud.state.InactiveMachine;
import dhimni.cloud.state.StateMachine;

public class Machine {

	private String Name;
	private String Systeme;
	private String DiskSize;
	private String MemorySize;
	
	private double MemoryUsed;
	private double DiskUsed;
	
	private StateMachine state;
	
	public void StartMachine() {
		this.state.startMachine();
		String[] s = this.getMemorySize().split("(?=g)");
		if (this.state.toString().equalsIgnoreCase("running"))this.MemoryUsed = Double.parseDouble(s[0]);
		
	}
	
	public void StopMachine() {
		this.state.stopMachine();
	}
	
	
	public Machine(String Name,String Systeme,String DiskSize,String MemorySize) {
     this.setName(Name);
     this.setSysteme(Systeme);
     this.setDiskSize(DiskSize);
     this.setMemorySize(MemorySize);
     
     this.state = new InactiveMachine();
     this.state.setMachine(this);
     
     this.setMemoryUsed();
     this.setDiskUsed();		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSysteme() {
		return Systeme;
	}

	public void setSysteme(String systeme) {
		Systeme = systeme;
	}

	public String getDiskSize() {
		return DiskSize;
	}

	public void setDiskSize(String diskSize) {
		DiskSize = diskSize;
	}
	
	public double getDiskUsed() {
		return this.DiskUsed;
	}

	public void setDiskUsed() {
		String[] s = this.getDiskSize().split("(?=g)");

		this.DiskUsed = Double.valueOf(s[0]);
	}
	
    
	
	
//	public double getDiskSizeDouble() {
//		String[] s = this.getDiskSize().split("(?=g)");
//		
//		return Double.valueOf(s[0]);
//	}
//	
//	
//	public int getDiskSizeInteger() {
//		String[] s = this.getDiskSize().split("(?=g)");
//		
//		return Integer.valueOf(s[0]);
//	}
//	
//	
	
	
	public String getMemorySize() {
		return MemorySize;
	}
	
	
//	public double getMemorySizeDoouble() {
//		String[] s = this.getMemorySize().split("(?=g)");
//		
//		return Double.valueOf(s[0]);
//	}
//	
//	public int getMemorySizeInteger() {
//		String[] s = this.getMemorySize().split("(?=g)");
//		
//		return Integer.valueOf(s[0]);
//	}
//	
	public void setMemorySize(String memorySize) {
		MemorySize = memorySize;
	}
	
	
	public void setMemoryUsed() {
		String[] s = this.getMemorySize().split("(?=g)");

		if (this.state.toString().equalsIgnoreCase("inactive"))this.MemoryUsed = 0.0;
		if (this.state.toString().equalsIgnoreCase("stopped"))this.MemoryUsed = 0.0;
		if (this.state.toString().equalsIgnoreCase("running"))this.MemoryUsed = Double.parseDouble(s[0]);
	}
	
	public double getMemoryUsed() {
		return this.MemoryUsed;
	}
	
	public StateMachine getState() {
		return this.state;
	}

	public void setState(StateMachine state) {
		this.state = state;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.Name+":"+this.state;
	}
	
}
