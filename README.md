# Programacion-Practicas

THIS PROGRAM IS AN UPDATED AND IMPROVED VERSION OF 'Programacion-Practica1'.
INCLUDES INHERITENCE , THE LOCALDATE CLASS, INTERNATIONALIZATION, A LOT MORE METHODS AND A TEST TO PROVE IF EVERYTHING IS GOING AS EXPECTED.

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
          They are typically written at a method level and executed via automation. These are some of the parts of my test:
	  
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


https://github.com/alexcl01/Programacion-Practica2/issues/1#issue-749806443
