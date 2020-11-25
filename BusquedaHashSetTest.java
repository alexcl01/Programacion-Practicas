package Practicas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusquedaHashSetTest {
	
	BusquedaHashSet BHS = new BusquedaHashSet("Apollo");

	@Test
	void test() {
		assertEquals("Apollo", BHS.getHotelName());
	}

}
