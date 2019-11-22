package ma.sqli.entities;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class Appartement implements Rom {
	private int Nombre;
	private boolean Availibility;
	private int nomreperson;
	
	public Appartement(int nombre) {
		// TODO Auto-generated constructor stub
		
		this.setNombre(nombre);
		this.setAvailibility(true);
		this.nomreperson =0;
	}

	public boolean isAvailibility() {
		return Availibility;
	}

	public void setAvailibility(boolean availibility) {
		Availibility = availibility;
	}

	public int getNombre() {
		return Nombre;
	}

	public void setNombre(int nombre) {
		Nombre = nombre+200;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Apart N°"+Nombre;
	}

	public int getNomreperson() {
		return nomreperson;
	}

	public void setNomreperson() {
		this.nomreperson = nomreperson;
	}
}
