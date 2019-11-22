package ma.sqli.factory;

import ma.sqli.entities.Speaker;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class factorySpeaker {
	
	public Speaker getInstance(String name) {
		return new Speaker(name);
	}

}
