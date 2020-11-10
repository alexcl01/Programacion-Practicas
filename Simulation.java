package Practicas;

/*a driver/test program for the Hotel class
it instantiates a Hotel and uses the member functions*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class Simulation {

	private static String readLine() {
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try {
			return stdin.readLine();
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
		return null;
	}
	
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
	}
	
	// internationalization
	private static void i18n() throws IOException {
		ResourceBundle rb = ResourceBundle.getBundle("Practicas/resource_bundle");
		
		Locale.setDefault(new Locale ("es", "ES"));
		rb = ResourceBundle.getBundle("Practicas/resource_bundle_es_ES");
		System.out.println(rb.getString("language"));

	}
	
	
	//main function
	public static void main(String[] args) throws IOException {
		
		//instantiate the hotels
		Hotel hotel1 = new Hotel(4, "The sound of the sea");
		Hotel hotel2 = new Hotel(5, "Music time");
		Hotel hotel3 = new Hotel(3, "Apollo");
		
		// variables
		String name;
		String num;
		int roomnum;

		// LocalDate class
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        LocalDateTime datetimeNow = LocalDateTime.of(dateNow, timeNow);

        
		//main loop
		while (true) {
			
			selMenu(); // selection menu
			
			System.out.print("Choice: ");
			System.out.flush();
			
			String choice = readLine();
			
			if(choice.equalsIgnoreCase("Change language")) {
				i18n();
			}
			
			if ((choice == null) || choice.equalsIgnoreCase("Quit")) {
				System.out.println("Good bye");
				break;
			}
			
			
			if(choice.equalsIgnoreCase("New York")) {
				
				System.out.println("The hotel's name is " + hotel1.getHotelName() + " and its stars number is: " + hotel1.getStarsNumber());
				
				resMenu(); // reservation menu
				
				
				System.out.print("Command: ");
				System.out.flush();
				
				String command = readLine();
				
				/*if(command.equalsIgnoreCase("Language")) {
					i18nNY();
					resMenu();
					
				}*/
				
				
				//if user want to quit
				if ((command == null) || command.equalsIgnoreCase("quit")) {
					System.out.println("Good bye");
					break;
				}
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
				//reserve a particular room
				if (command.equalsIgnoreCase("reserveN")) {
					//prompt for name and room
					System.out.print("Name: ");
					System.out.flush();
					name = readLine();
					System.out.print("Room number: ");
					System.out.flush();
					num = readLine();
					//if we got a bad input, report failure
					if ((name == null) || (name.equals("")) || (num == null)) {
						roomnum = -1;
					} else {
						//convert the String to an int
						try {
							roomnum = Integer.parseInt(num);
						} catch (Exception e)  {
							roomnum = -1;
						}
					}
					//give feedback
					if (!hotel1.reserveRoom(name, roomnum)) {
						System.out.println("No reservation possible!");
					} else {
						System.out.println(name + " reserved room " + roomnum);
						
						System.out.println("Number reservation did at " + datetimeNow);
						System.out.println();
					}
					
				} else if (command.equalsIgnoreCase("cancel")) {
					//prompt for name
					System.out.print("Name: ");
					System.out.flush();
					name = readLine();
					
					//if we got a good name, cancel their reservations
					if (!((name == null) || (name.equals("")))) {
						hotel1.cancelReservations(name);
						System.out.println(name + " now has no reservations.");
						System.out.println();
					} else {
						System.out.println("That person has no reservation here");
						
						System.out.println("Cancelation did at " + datetimeNow);
						System.out.println();
					}
					
				} else if (command.equalsIgnoreCase("print")) {
					hotel1.printReservations();
					System.out.println("All reservations printed at " + datetimeNow);
					System.out.println();
					
				} else if (command.equalsIgnoreCase("build")) {
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
				
			}
			
			if(choice.equalsIgnoreCase("Washington")) {
				System.out.println("The hotel's name is " + hotel2.getHotelName() + " and its stars number is: " + hotel2.getStarsNumber());
				
				resMenu(); // reservation menu
				
				
				System.out.print("Command: ");
				System.out.flush();
				
				String command = readLine();
				//if user want to quit
				if ((command == null) || command.equalsIgnoreCase("quit")) {
					System.out.println("Good bye");
					break;
				}
				//reserve some room
				if (command.equalsIgnoreCase("reserve")) {
					//prompt for name
					System.out.print("Name: ");
					System.out.flush();
					name = readLine();
					roomnum = -1;
					//if we got a good name, try to reserve a room
					if (!((name == null) || (name.equals("")))) {
						roomnum = hotel2.reserveRoom(name);
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
				//reserve a particular room
				if (command.equalsIgnoreCase("reserveN")) {
					//prompt for name and room
					System.out.print("Name: ");
					System.out.flush();
					name = readLine();
					System.out.print("Room number: ");
					System.out.flush();
					num = readLine();
					//if we got a bad input, report failure
					if ((name == null) || (name.equals("")) || (num == null)) {
						roomnum = -1;
					} else {
						//convert the String to an int
						try {
							roomnum = Integer.parseInt(num);
						} catch (Exception e)  {
							roomnum = -1;
						}
					}
					//give feedback
					if (!hotel2.reserveRoom(name, roomnum)) {
						System.out.println("No reservation possible!");
					} else {
						System.out.println(name + " reserved room " + roomnum);
						
						System.out.println("Number reservation did at " + datetimeNow);
						System.out.println();
					}
					
				} else if (command.equalsIgnoreCase("cancel")) {
					//prompt for name
					System.out.print("Name: ");
					System.out.flush();
					name = readLine();
					
					//if we got a good name, cancel their reservations
					if (!((name == null) || (name.equals("")))) {
						hotel2.cancelReservations(name);
						System.out.println(name + " now has no reservations.");
						System.out.println();
					} else {
						System.out.println("That person has no reservation here");
						
						System.out.println("Cancelation did at " + datetimeNow);
						System.out.println();
					}
					
				} else if (command.equalsIgnoreCase("print")) {
					hotel2.printReservations();
					System.out.println("All reservations printed at " + datetimeNow);
					System.out.println();
					
				} else if (command.equalsIgnoreCase("build")) {
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
					if (hotel2.buildRooms(roomnum)) {
						System.out.println("Added " + roomnum + " more rooms");
					} else {
						System.out.println("No more rooms for you");
						
						System.out.println("Construction of new rooms did at " + datetimeNow);
						System.out.println();
					}
				
				}
				
			}
			
			if(choice.equalsIgnoreCase("Chicago")) {
				System.out.println("The hotel's name is " + hotel3.getHotelName() + " and its stars number is: " + hotel3.getStarsNumber());
				
				resMenu(); // reservation menu
				
				
				System.out.print("Command: ");
				System.out.flush();
				
				String command = readLine();
				//if user want to quit
				if ((command == null) || command.equalsIgnoreCase("quit")) {
					System.out.println("Good bye");
					break;
				}
				//reserve some room
				if (command.equalsIgnoreCase("reserve")) {
					//prompt for name
					System.out.print("Name: ");
					System.out.flush();
					name = readLine();
					roomnum = -1;
					//if we got a good name, try to reserve a room
					if (!((name == null) || (name.equals("")))) {
						roomnum = hotel3.reserveRoom(name);
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
				//reserve a particular room
				if (command.equalsIgnoreCase("reserveN")) {
					//prompt for name and room
					System.out.print("Name: ");
					System.out.flush();
					name = readLine();
					System.out.print("Room number: ");
					System.out.flush();
					num = readLine();
					//if we got a bad input, report failure
					if ((name == null) || (name.equals("")) || (num == null)) {
						roomnum = -1;
					} else {
						//convert the String to an int
						try {
							roomnum = Integer.parseInt(num);
						} catch (Exception e)  {
							roomnum = -1;
						}
					}
					//give feedback
					if (!hotel3.reserveRoom(name, roomnum)) {
						System.out.println("No reservation possible!");
					} else {
						System.out.println(name + " reserved room " + roomnum);
						
						System.out.println("Number reservation did at " + datetimeNow);
						System.out.println();
					}
					
				} else if (command.equalsIgnoreCase("cancel")) {
					//prompt for name
					System.out.print("Name: ");
					System.out.flush();
					name = readLine();
					
					//if we got a good name, cancel their reservations
					if (!((name == null) || (name.equals("")))) {
						hotel3.cancelReservations(name);
						System.out.println(name + " now has no reservations.");
						System.out.println();
					} else {
						System.out.println("That person has no reservation here");
						
						System.out.println("Cancelation did at " + datetimeNow);
						System.out.println();
					}
					
				} else if (command.equalsIgnoreCase("print")) {
					hotel3.printReservations();
					System.out.println("All reservations printed at " + datetimeNow);
					System.out.println();
					
				} else if (command.equalsIgnoreCase("build")) {
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
					if (hotel3.buildRooms(roomnum)) {
						System.out.println("Added " + roomnum + " more rooms");
					} else {
						System.out.println("No more rooms for you");
						
						System.out.println("Construction of new rooms did at " + datetimeNow);
						System.out.println();
					}
				}
			}
		}
	}
}

