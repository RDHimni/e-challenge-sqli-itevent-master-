package ma.sqli.entities;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class Standart implements Rom {

	private int Nombre;
	private boolean Availibility;
	private int nombrePersone;
	
	public Standart(int nombre) {
		// TODO Auto-generated constructor stub
		
		this.setNombre(nombre);
		this.setAvailibility(true);
		this.nombrePersone = 0;
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
		Nombre = nombre;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Standard room N°"+Nombre;
	}

	public int getNombrePersone() {
		return nombrePersone;
	}

	public void setNombrePersone() {
		this.nombrePersone ++;
	}
	
}
