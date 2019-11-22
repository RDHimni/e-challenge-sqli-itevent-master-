package dhimni.cloud.entities;

/**
 * @author rout
 *
 * Nov 17, 2019
 *
 * @project cloud
 */

public class File {

	private String Name;
	
	public File(String Name) {

		this.setName(Name);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	@Override
		public String toString() {
			return this.getName();
		}
}
