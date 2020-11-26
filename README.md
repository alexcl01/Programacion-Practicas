# Programacion-Practicas

THIS PROGRAM IS AN UPDATED AND IMPROVED VERSION OF 'Programacion-Practica1'.
INCLUDES INHERITENCE , THE LOCALDATE CLASS, INTERNATIONALIZATION, A LOT MORE METHODS AND A TEST TO PROVE IF EVERYTHING IS GOING AS EXPECTED.

---> IN THIS NEW VERSION (Practica3) I INCLUDED A CLASS DIAGRAM, AN INTERFACE, A NEW OVERLOADED METHOD, THE CLASS MATH, THE ?: OPERATOR AND NEW TESTS.

**INHERITENCE**: Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another. The class which inherits the properties 
                 of other is known as subclass, and the class whose properties are inherited is known as superclass.
     
     `public class Hotel extends Reservation{`               `public class Reservation{
	                                                          //instance variables
	                                                          private String name;
	                                                          private int roomNumber;

	                                                          private ArrayList<Reservation> rooms;`
						
**LOCALDATE CLASS**: LocalDate, LocalTime and LocalDateTime classes are immutable classes that represent Date and Time 
                     with a default format of yyyy-MM-dd-HH-mm-ss.zzz in the case of LocalDateTime. 
		     
		     
      `import java.time.LocalDate;                          `// LocalDate class
       import java.time.LocalDateTime;                          LocalDate dateNow = LocalDate.now();
       import java.time.LocalTime;`	                            LocalTime timeNow = LocalTime.now();
		                                                    LocalDateTime datetimeNow = LocalDateTime.of(dateNow, timeNow);`
								  
								  
							          // On each method
								     System.out.println("Reservation did at " + datetimeNow);
								     
**INTERNATIONALIZATION**: Internationalization is the process of designing an application so that it can be adapted to various languages and 
                          regions without engineering changes. Sometimes the term internationalization is abbreviated as i18n.
			   
			  
    `// internationalization                                                                    `if(choice.equalsIgnoreCase("Change language")) {
        private static void i18n() throws IOException {                                               i18n();
	    ResourceBundle rb = ResourceBundle.getBundle("Practicas/resource_bundle");               }`
		
	    Locale.setDefault(new Locale ("es", "ES"));
        rb = ResourceBundle.getBundle("Practicas/resource_bundle");
        System.out.println(rb.getString("language"));	                                                                          
  		                                                                                      
        }`
	
**METHODS**: A method is a block of code which only runs when it is called. You can pass parameters into a method. Methods are used to perform certain actions, 
             and they are also known as functions. These are a few examples of methods in my program:
	     
	     
       ` public boolean buildRooms(int num) {      					//method to build rooms 
	     //make sure the parameter is valid
	       if (num <= 0) {
	          return false;
	       }
	       //increase the capacity of the Vector
	       rooms.ensureCapacity(rooms.size() + num);
	       for (int i = 0; i < num; i++) {
		   rooms.add(null);
	       }
	       //report success
	       return true;
	     }`  
	  
	  public boolean reserveRoom(String person, int roomNum) {	               //method to reserve room 
	        try {                                                                       //with person and room number.
			if (rooms.get(roomNum - 1) == null) {
				reserveObj = new Reservation(person,roomNum);
				rooms.set(roomNum  - 1,reserveObj);
				rnum++;
				return true;
			}
		} catch (Exception vb) {
			return false;
		}
		return false;
	  }
	
**TEST**: Unit tests are used to test individual code components and ensure that code works the way it was intended to. Unit tests are written and executed by developers. 
          They are typically written at a method level and executed via automation. These are some of my tests:
	  
    class HotelTest {
	
	// instancia de hotel 
	Hotel NYHotel = new Hotel("Alex", 5, 4, "The sound of the sea");
	Hotel WAHotel = new Hotel("Elsa", 2, 5, "Music Time");
	Hotel CHHotel = new Hotel("Laura", 3, 3, "Apollo");

	@Test
	void test() {
		// como validar el nombre del hotel (assertEquals)
		
		assertEquals("The sound of the sea", NYHotel.getHotelName());
		assertEquals(5, WAHotel.getStarsNumber());
		assertEquals("Laura", CHHotel.getName());
	}

    }`
    
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
    
    class BusquedaHashSetTest {
	
	BusquedaHashSet BHS = new BusquedaHashSet("Apollo");

	@Test
	void test() {
		assertEquals("Apollo", BHS.getHotelName());
	}
    }

	  
**MAIN MENU**: Where it all happens. These are some of the parts:
	  
	  `THE MENUS:
	  // selection menu
	     private static void selMenu() {
		System.out.println("Welcome to the hotels list, in which city do you want to reserve a hotel room?\n"
				+ "-> New York\n" 
				+ "-> Washington\n"
				+ "-> Chicago\n\n"
				+ "-> Change language - You will see the platform in both languages\n"
				+ "-> Quit\n");
	     }
	
	
	  // reservation menu
	     private static void resMenu() {
		 System.out.println("Welcome to the reservation program of the hotel, these are your options here:\n\n"
				+ "-> print - show all reservations\n"
				+ "-> reserve - reserve a room for someone\n"
				+ "-> reserveN - reserve a particular room\n"
				+ "-> cancel - cancel someone's reservations\n"
				+ "-> build - build some more rooms for the hotel\n"
				+ "-> quit - leave the reservations\n");
	     }`
	     
	     
	     `READLINE: The readLine() method is used to read a single line of text from the console. 
	     Return value: This method returns the string containing the line that is read from the console. 
	     It returns null if the stream has ended.
	     
	      private static String readLine() {
		    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		    try {
			  return stdin.readLine();
		    } catch (Exception e) {
			  System.out.println("Invalid Input");
		    }
		    return null;
	      }
	      
	      System.out.print("Command: ");
	      System.out.flush();
	      String command = readLine();`
	      
	      
	      `IMPORTS: Classes we will need all along the program.
	      
	        import java.io.BufferedReader;
		import java.io.IOException;
		import java.io.InputStreamReader;
		
		import java.time.LocalDate;
		import java.time.LocalDateTime;
		import java.time.LocalTime;
		
		import java.util.Locale;
		import java.util.ResourceBundle;`
      
                
	      `IMPLEMENTATION OF THE METHODS (some examples):
	      											//reserve some room
		if (command.equalsIgnoreCase("reserve")) {
			//prompt for name
			System.out.print("Name: ");
			System.out.flush();
			name = readLine();
			roomnum = -1;
			//if we got a good name, try to reserve a room
			if (!((name == null) || (name.equals("")))) {
				roomnum = hotel1.reserveRoom(name);
			}
			//give feedback
			if (roomnum == -1) {
				System.out.println("No reservation possible!");
			} else {
				System.out.println(name + " reserved room " + roomnum);
						
				System.out.println("Reservation did at " + datetimeNow);
				System.out.println();
			}
		}
		
		else if (command.equalsIgnoreCase("build")) {					//build some more rooms
			//prompt for the number
			System.out.print("How many: ");
			System.out.flush();
			num = readLine();
					
			//convert to an int
			roomnum = -1;
			if (num != null) {
				try {
					roomnum = Integer.parseInt(num);
				} catch (Exception e) {
					roomnum = -1;
				}
			}
			//add the rooms
			if (hotel1.buildRooms(roomnum)) {
				System.out.println("Added " + roomnum + " more rooms");
			} else {
				System.out.println("No more rooms for you");
						
				System.out.println("Construction of new rooms did at " + datetimeNow);
				System.out.println();
			}		
		}
	      `

**CLASS DIAGRAM**: A class diagram is a diagram used in designing and modeling software to describe classes and their relationships. Class diagrams enable us to model software in a high level of abstraction and without having to look at the source code.

https://github.com/alexcl01/Programacion-Practicas/issues/3#issue-751370781


**INTERFACES**: An interface in the Java programming language is an abstract type that is used to specify a behavior that classes must implement. Interfaces cannot be instantiated, but rather are implemented. A class that implements an interface must implement all of the non-default methods described in the interface, or be an abstract class.
This is the interface I implemented in my program:

**?: OPERATOR**: The ternary operator is a part of Java's conditional statements. As the name ternary suggests, it is the only operator in Java consisting of three operands. The ternary operator can be thought of as a simplified version of the if-else statement with a value to be returned.
I used this operator in the interface.

	`public interface IBusqueda {						
	     public void inserta(String clave);
	     public boolean contiene(String clave);

	}									`import java.util.HashSet;
										 import java.util.Set;
	`
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

		`// INTERFACE //
		
		ConjuntoHashSet c1 = new ConjuntoHashSet();
		
		c1.inserta("The sound of the sea");
		c1.inserta("Apollo");
		c1.inserta("Music time");
		
		System.out.println("INTERFACE OF THE HOTELS LIST:\n");
		
		System.out.print("Hotel Choice?: ");
		System.out.flush();
		
		String hotelChoice = readLine();


		System.out.println("-> '" + hotelChoice + "' " + ((c1.contiene(hotelChoice)) ? "is in our list." : "is not in our list."));      // use of the ?: operator

		
		
		
**MATH CLASS**: Class math is a class that is used to perform basic math functions. It includes methods for square and cubic roots, to perform exponents (can also be used for negative exponents and roots), compare variables, a constant for pi, etc. Beacause all of it's methods are static, people cannot create an object of this type.
I used this class here:

		`if (age.equalsIgnoreCase("Yes")) {

			System.out.println(name + " reserved room " + roomnum);

			System.out.println("The prize of the room is $" + Math.sqrt(roomPrize));       // use of class Math

			System.out.println("Reservation did at " + datetimeNow);
			System.out.println();`


**NEW OVERLOADED METHOD/CONSTRUCTOR**: Method Overloading is a feature that allows a class to have more than one method having the same name, if their argument lists are different. It is similar to constructor overloading in Java, that allows a class to have more than one constructor having different argument lists.
I did a few overlaods but this is the one I recentlty implemented:

		`public Reservation(String person, int room, float prize) {					// new overloaded method
			this.name = person;
			this.roomNumber = room;
			this.prize = prize;
		}`


**REFACTORING CODE**: The process of changing a software system in such a way that it does not alter the external behavior of the code but improves its internal structure. It is a disciplined way of cleaning up code that minimizes the chances of introducing an error. In essence, when you refactor, you are improving the design of the code after it was written.
One example in my code is when I did functions with the main menus of the simulation to not have to write them every new hotel:

	`
	OUTSIDE THE MAIN MENU:
	// selection menu
	private static void selMenu() {
		System.out.println("\n\nWelcome to the hotels list, in which city do you want to reserve a hotel room?\n"
				+ "-> New York\n" 
				+ "-> Washington\n"
				+ "-> Chicago\n\n"
				+ "-> Change language - You will see the platform in both languages\n"
				+ "-> Quit\n");
	}
	
	
	// reservation menu
	private static void resMenu() {
		System.out.println("Welcome to the reservation program of the hotel, these are your options here:\n\n"
				+ "-> print - show all reservations\n"
				+ "-> reserve - reserve a room for someone\n"
				+ "-> reserveN - reserve a particular room\n"
				+ "-> cancel - cancel someone's reservations\n"
				+ "-> build - build some more rooms for the hotel\n"
				+ "-> quit - leave the reservations\n");
	}`
	
	IN THE MAIN MENU, ON EACH HOTEL MENU:
	
	selMenu(); // selection menu
	resMenu(); // reservation menu
	
	
