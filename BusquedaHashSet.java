package Practicas;

import java.util.HashSet;
import java.util.Set;

public class BusquedaHashSet {

	private Set<String> conjunto;
	private String HotelName;

	public BusquedaHashSet(String hotelName) {
		this.HotelName = hotelName;
	}

	public String getHotelName() {
		return HotelName;
	}
	
	

	public BusquedaHashSet() {
		this.conjunto = new HashSet<String>();
	}

	public void inserta(String clave) {
		this.conjunto.add(clave);
	}

	public boolean contiene(String clave) {
		return this.conjunto.contains(clave);
	}

}
