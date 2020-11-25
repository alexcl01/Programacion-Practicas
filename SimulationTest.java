package Practicas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimulationTest {
	
	Simulation Simul1 = new Simulation("The sound of the sea", 100, 10);
	Simulation Simul2 = new Simulation("Music time", 240, 15.491933);
	Simulation Simul3 = new Simulation("Apollo", 80, 8.944271);

	@Test
	void test() {
		
		assertEquals("Apollo", Simul3.getHotel());
		assertEquals(100.0, Simul1.getPrize());
		assertEquals("Music time", Simul2.getHotel());
		assertEquals(15.491933, Simul2.getDiscountedPrize());
		
	}

}
