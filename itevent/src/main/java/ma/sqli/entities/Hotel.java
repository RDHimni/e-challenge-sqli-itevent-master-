package ma.sqli.entities;

import java.util.HashMap;
import java.util.Map;

import ma.sqli.factory.factoryAppartement;
import ma.sqli.factory.factoryStandart;
import ma.sqli.factory.factorySuit;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class Hotel {
		private int standardRooms;
	private int suites;
	private int apparts;
	
	private int nrNoAvStandart;
	private int nrNoAvSuit;
	private int nrNoAvapparts;

	private Map<Person,Rom> mapresirvations;

	public Hotel(int standardRooms, int suites, int apparts) {
		// TODO Auto-generated constructor stub
		this.standardRooms=standardRooms;
		this.suites = suites;
		this.apparts = apparts;
		this.nrNoAvStandart = 0;
		this.nrNoAvapparts = 0;
		this.nrNoAvSuit = 0;
		
		this.setMapresirvations(new HashMap<>());
		
	}

	public String checkAvailibility() {
		// TODO Auto-generated method stub
		int nombreStandatrsAv = this.standardRooms - this.nrNoAvStandart;
		int nombreAppAv = this.apparts - this.nrNoAvapparts;
		int nombreSuitAv = this.suites - this.nrNoAvSuit;
		
//		System.out.println(nrNoAvSuit);
//		System.out.println(nombreSuitAv);
		
		
		return "Standard rooms: "+nombreStandatrsAv+"|Suites: "+nombreSuitAv+"|Aparts: "+nombreAppAv;
	}

	public String getRoomFor(String name) {
		Person p = mapresirvations.keySet()
				.stream()
				.filter(pr->pr.getNane().equalsIgnoreCase(name))
				.findAny()
				.orElse(null);
		
				
		return (p == null) ? null : mapresirvations.get(p).toString();
	}

	
	
	
	
	public int getStandardRooms() {
		return standardRooms;
	}

	public void setStandardRooms(int standardRooms) {
		this.standardRooms = standardRooms;
	}

	public int getSuites() {
		return suites;
	}

	public void setSuites(int suites) {
		this.suites = suites;
	}

	public int getApparts() {
		return apparts;
	}

	public void setApparts(int apparts) {
		this.apparts = apparts;
	}

	public int getNrNoAvStandart() {
		return nrNoAvStandart;
	}

	public void setNrNoAvStandart(int nrNoAvStandart) {
		this.nrNoAvStandart = nrNoAvStandart;
	}
	

	public void setIncrNrNoAvStandart() {
		this.nrNoAvStandart ++;
	}

	public int getNrNoAvSuit() {
		return nrNoAvSuit;
	}

	public void setNrNoAvSuit(int nrNoAvSuit) {
		this.nrNoAvSuit = nrNoAvSuit;
	}
	public void setIncrNrNoAvSuit() {
		System.out.println("han1");
		this.nrNoAvSuit ++;
		System.out.println(nrNoAvSuit);
	}

	
	public int getNrNoAvapparts() {
		return nrNoAvapparts;
	}

	public void setNrNoAvapparts(int nrNoAvapparts) {
		this.nrNoAvapparts = nrNoAvapparts;
	}
	
	public void setIncrNrNoAvapparts() {
		this.nrNoAvapparts++;
	}

	public Map<Person,Rom> getMapresirvations() {
		return mapresirvations;
	}

	public void setMapresirvations(Map<Person,Rom> mapresirvations) {
		this.mapresirvations = mapresirvations;
	}

	public int SadartAv() {
		   int av = standardRooms - nrNoAvStandart;
		
			return av > 0? nrNoAvStandart+1 : 0;
	}
	
	public int SadartAvNomre() {
		   int av = standardRooms - nrNoAvStandart;
		
			return av;
	} 
	
	
	public int SuitAv() {
		   int av = suites - nrNoAvSuit;
		
			return av > 0? nrNoAvSuit+1 : 0;
	}
	
	public int AppartAv() {
		   int av = apparts - nrNoAvapparts;
		
			return av > 0? nrNoAvapparts+1 : 0;
	}
	
	public boolean resirvation(Person person, String rom_typ) {
		
		boolean resbienpasse = false;
		
           if(rom_typ.equalsIgnoreCase("SUIT")) {
        	     Suit st = new factorySuit().getInstance(SuitAv());
        	      st.setAvailibility(false);
        	      mapresirvations.put(person, st);
        	      resbienpasse = true;
        	      setIncrNrNoAvSuit();
           }
           else {
        	   if (rom_typ.equalsIgnoreCase("STANDART")) {

        		   Standart st  = new factoryStandart().getInstance(SadartAv());
         	        st.setAvailibility(false);
         	       mapresirvations.put(person, st);
         	       resbienpasse = true;
         	       setIncrNrNoAvStandart();
         	       st.setNombrePersone();
         	       
			}else {
     		   Appartement ap  = new factoryAppartement().getInstance(AppartAv());
    	        ap.setAvailibility(false);
    	       mapresirvations.put(person, ap);
    	       resbienpasse = true;
    	        setIncrNrNoAvapparts();
    	        ap.setNomreperson();
				
			}
        	   
           }
		
		return  resbienpasse;
	}
}
