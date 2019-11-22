package ma.sqli.entities;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class Suit implements Rom{
	private int Nombre;
	private boolean Availibility;
	
	public Suit(int nombre) {
		// TODO Auto-generated constructor stub
		
		this.setNombre(nombre);
		this.setAvailibility(true);
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
		Nombre = nombre+100;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Suite N°"+Nombre;
	}

	@Override
	public int getNombrePersone() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNombrePersone() {
		// TODO Auto-generated method stub
		
	}
	
}
