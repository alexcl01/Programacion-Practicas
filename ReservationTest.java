package Practicas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReservationTest {
	
	Reservation Reserve = new Reservation("Alex");
	Reservation ReserveNumber = new Reservation("Maria", 4);

	@Test
	void test() {
		assertEquals("Alex", Reserve.getName());
		assertEquals("Maria", ReserveNumber.getName());
		assertEquals(4, ReserveNumber.getRoom());
	}

}
