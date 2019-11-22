package ma.sqli.factory;

import ma.sqli.entities.Suit;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class factorySuit {

	public Suit getInstance(int nombre) {
		return new Suit(nombre);
	}
}
