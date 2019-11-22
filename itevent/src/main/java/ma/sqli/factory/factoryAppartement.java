package ma.sqli.factory;

import ma.sqli.entities.Appartement;
import ma.sqli.entities.Suit;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class factoryAppartement {
	public Appartement getInstance(int nombre) {
		return new Appartement(nombre);
	}
}
