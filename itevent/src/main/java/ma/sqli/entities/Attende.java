package ma.sqli.entities;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class Attende implements Person{
	
	private String Name;
	
	public Attende(String name) {
		// TODO Auto-generated constructor stub
		this.setNane(name);
	}

	public String getNane() {
		return Name;
	}

	public void setNane(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Name;
	}

}
