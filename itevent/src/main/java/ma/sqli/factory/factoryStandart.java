package ma.sqli.factory;

import ma.sqli.entities.Appartement;
import ma.sqli.entities.Standart;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class factoryStandart {
	
	public Standart getInstance(int nombre) {
		return new Standart(nombre);
	}

}
