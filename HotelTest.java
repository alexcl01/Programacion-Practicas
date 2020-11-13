package Practicas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HotelTest {
	
	Hotel NYHotel = new Hotel("Alex", 5, 4, "The sound of the sea");
	Hotel WAHotel = new Hotel("Elsa", 2, 5, "Music Time");
	Hotel CHHotel = new Hotel("Laura", 3, 3, "Apollo");

	@Test
	void test() {
		// instancia de hotel 
		// como validar el nombre del hotel
		// assertEquals
		
		assertEquals("The sound of the sea", NYHotel.getHotelName());
		assertEquals(5, WAHotel.getStarsNumber());
		assertEquals("Apollo", CHHotel.getHotelName());
	}

}
