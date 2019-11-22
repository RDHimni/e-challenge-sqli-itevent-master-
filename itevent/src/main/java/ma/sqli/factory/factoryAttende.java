package ma.sqli.factory;

import ma.sqli.entities.Attende;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class factoryAttende {

	public Attende getInstance(String name) {
		return new Attende(name);
	}
}
