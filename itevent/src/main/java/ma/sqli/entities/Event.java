package ma.sqli.entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ma.sqli.factory.factoryAttende;
import ma.sqli.factory.factorySpeaker;
import ma.sqli.factory.factoryStaff;

/**
 * @author rout
 *
 * Nov 20, 2019
 *
 * @project itevent
 */

public class Event {

	private Hotel hotel;
	
	private Map<Person,String> evregister ;
	
	public Event(Hotel hotel) {
		// TODO Auto-generated constructor stub	
		this.setHotel(hotel);
		this.setEvregister(new HashMap<>());
	}

	public boolean register(String type_resirvation, String ...names) {
	
		Person p;
		boolean tousenregistre = true;
		boolean resirvationhotel = false;
		
		for (int i = 0; i < names.length; i++) {
			p = searchPerson(names[i]);
			
			if (p == null) {
				
				if (type_resirvation.equalsIgnoreCase("STAFF")) {
					 
					Staff st = new factoryStaff().getInstance(names[i]);
					
			    	 resirvationhotel = resirvationhotel(st,names.length);
			    	 
			    	 if (resirvationhotel == true) {
						evregister.put(st, type_resirvation);
					}else tousenregistre = false;

					
				}else {
				     if (type_resirvation.equalsIgnoreCase("SPEAKER")) {
				    	 Speaker sp = new factorySpeaker().getInstance(names[i]);
				    	  
				    	 resirvationhotel = resirvationhotel(sp,names.length);
				    	 if (resirvationhotel == true) {
								evregister.put(sp, type_resirvation);
							}else tousenregistre = false;
					
				   }else {
					   
						Attende at = new factoryAttende().getInstance(names[i]);
						
						if (type_resirvation.equalsIgnoreCase("DEEP DIVE")) {
							
							resirvationhotel=  eregistreD(at,type_resirvation);  
					    	 if (resirvationhotel == true) {
									evregister.put(at, type_resirvation);
									
								}else tousenregistre = false;
						}
						if (type_resirvation.equalsIgnoreCase("CONF")) {
							
							resirvationhotel =  eregistreC(at,type_resirvation);
							
					    	 if (resirvationhotel == true) {
									evregister.put(at, type_resirvation);
									
								}else tousenregistre = false;
						}
						if (type_resirvation.equalsIgnoreCase("TRINGA")) {
						    
				    	 resirvationhotel = resirvationhotel(at,names.length);
				    	 if (resirvationhotel == true) {
								evregister.put(at, type_resirvation);
								
							}else tousenregistre = false;
						}
					}
				}
			
			}
			else tousenregistre = false;					
		}
		
		
		return tousenregistre;
	}


	
	
	private boolean eregistreC(Attende at, String type_resirvation) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				Person pr = null;
				Rom r = null;
		   	 boolean tousenregistre = true;

				
				for (Iterator iterator = evregister.keySet().iterator(); iterator.hasNext();) {
					Person p = (Person) iterator.next();
				    if(evregister.get(p).equalsIgnoreCase("DEEP DIVE") 
				    		&& hotel.getMapresirvations().get(p).getNombrePersone() == 1)
				    	{
				    	pr=p; 
				    	r=hotel.getMapresirvations().get(p);
				    	}
					
				}
				
			     if (pr !=null && r !=null) {
				     
			    	 hotel.getMapresirvations().put(at, r);
			    	 r.setNombrePersone();   	 
		            
			    	 
			      }	
			     else {
			    	 boolean resirvationhotel = resirvationhotel(at,1);
					if (resirvationhotel == true) {
							
						}else tousenregistre = false;
			     }
			     
			     return tousenregistre;
		
	}

	private boolean eregistreD(Attende at,String type_resirvation) {
		// TODO Auto-generated method stub
		Person pr = null;
		Rom r = null;
   	 boolean tousenregistre = true;

		
		for (Iterator iterator = evregister.keySet().iterator(); iterator.hasNext();) {
			Person p = (Person) iterator.next();
		    if(evregister.get(p).equalsIgnoreCase("CONF") 
		    		&& hotel.getMapresirvations().get(p).getNombrePersone() == 1)
		    	{
		    	pr=p; 
		    	r=hotel.getMapresirvations().get(p);
		    	}
			
		}
		
	     if (pr !=null && r !=null) {
		     
	    	 hotel.getMapresirvations().put(at, r);
	    	 r.setNombrePersone();   	 
            
	    	 
	      }	
	     else {
	    	 boolean resirvationhotel = resirvationhotel(at,1);
			if (resirvationhotel == true) {
					
				}else tousenregistre = false;
	     }
	     
	     return tousenregistre;
		
		
	}

	private boolean resirvationhotel(Person person,int nombreperson) {
		
		boolean resbienpasse = false;
		
		if (person instanceof Speaker) {
			if(hotel.SuitAv() != 0) {
			  hotel.resirvation(person, "SUIT");
			  resbienpasse = true;
			}	
		}else {
			if(hotel.SadartAv()!= 0 && (hotel.SadartAvNomre() >= nombreperson)) {
                        
				  hotel.resirvation(person, "STANDART");
				  resbienpasse = true;
				}
			else {
				if(hotel.AppartAv()!= 0) {
					  hotel.resirvation(person, "APPARTEMENT");
					  resbienpasse = true;
					}
			}
			
		}
		
		
		return resbienpasse;
	}

	public Person searchPerson(String name) {
		Person p = evregister.keySet().stream()
				.filter(pr->pr.getNane().equalsIgnoreCase(name))
				.findAny().orElse(null);
		return p;
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////	
	
	public Map<Person,String> getEvregister() {
		return evregister;
	}

	public void setEvregister(Map<Person,String> evregister) {
		this.evregister = evregister;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
}
