package dhimni.cloud.entities;

import java.util.LinkedList;
import java.util.List;

public class Store {
	
	private String Name;		
	private String Size;
	private double DiskUsed ;
	
	private List<File> listfiles;

	public Store(String Name) {
		this.setName(Name);
		this.listfiles= new LinkedList<>();
		this.DiskUsed = 0.0;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}
	
	public List<File> getListfiles() {
		return this.listfiles;
	}

	public void setListfiles(List<File> Listfiles) {
		this.listfiles = Listfiles;
	}
	
	
	@Override
	public String toString() {
      String story = this.Name + ":";
          
    if(!this.listfiles.isEmpty()) {  
       for (int i= 0;i<listfiles.size();i++) {
    	   if(i<listfiles.size()-1)story = story+listfiles.get(i).toString()+", ";
    	   else story = story+listfiles.get(i).toString();
	}   
    }else {
    	story = story+"empty";
    }	
		return story;
	}

	public double getDiskUsed() {
		return DiskUsed;
	}

	public void setDiskUsed(double diskUsed) {
		this.DiskUsed += diskUsed;
	}
	

	public void clearDiskUsed() {
		this.DiskUsed = 0.0;
	}
	
	
}
