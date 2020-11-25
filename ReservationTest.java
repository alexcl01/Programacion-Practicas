package Practicas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReservationTest {
	
	Reservation Reserve = new Reservation("Alex");
	Reservation ReserveNumber = new Reservation("Maria", 4);
	Reservation ReserveP = new Reservation("Pepe", 2, 100);

	@Test
	void test() {
		assertEquals("Alex", Reserve.getName());
		assertEquals("Maria", ReserveNumber.getName());
		assertEquals(4, ReserveNumber.getRoom());
		assertEquals(100, ReserveP.getPrize());
	}

}
