package ma.sqli.factory;

import ma.sqli.entities.Staff;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class factoryStaff {
	
	
	public Staff getInstance(String name) {
		return new Staff(name);
	}

}
