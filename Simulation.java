package Practicas;

//the program for the Hotel class, it instantiates a Hotel and uses the member functions

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

import java.util.ResourceBundle;

import interfaces.conjunto.ConjuntoHashSet;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class Simulation {

	//variables
	String hotel;
	float prize;
	double discountedPrize;

	//constructor
	public Simulation(String Hotel, float Prize, double DiscountedPrize) {
		this.hotel = Hotel;
		this.prize = Prize;
		this.discountedPrize = DiscountedPrize;
	}
	
	// GENERICS
	public static < E > void printArray( E[] inputArray ) {
		// Display array elements
		for(E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	// CRYPTO LIBRARY
	
	private static final String UNICODE_FORMAT = "UTF-8";

	public static SecretKey generateKey(String encryptionType) {

		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(encryptionType);
			SecretKey myKey = keyGenerator.generateKey();
			return myKey;

		}catch (Exception e){
			return null;
		}
	}
	
	public static byte[] encryptString(String dataToEncrypt, SecretKey myKey, Cipher cipher) {
		
		try {
			byte [] text = dataToEncrypt.getBytes(UNICODE_FORMAT);
			cipher.init(Cipher.ENCRYPT_MODE, myKey);
			byte [] textEncrypted = cipher.doFinal(text);
			
			return textEncrypted;
			
		}catch (Exception e) {
			return null;
		}
	}
	
	public static String decryptString(byte[] dataToDecrypt, SecretKey myKey, Cipher cipher) {
		
		try {
			cipher.init(Cipher.DECRYPT_MODE, myKey);
			byte[] textDecrypted = cipher.doFinal(dataToDecrypt);
			String result = new String(textDecrypted);
			
			return result;
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}


	// readline class
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
	}

	// internationalization
	private static void i18n() throws IOException {
		ResourceBundle rb = ResourceBundle.getBundle("Practicas/resource_bundle");

		Locale.setDefault(new Locale ("es", "ES"));
		rb = ResourceBundle.getBundle("Practicas/resource_bundle");
		System.out.println(rb.getString("language"));

	}

	public String getHotel() {
		return hotel;
	}

	public float getPrize() {
		return prize;
	}

	public double getDiscountedPrize() {
		return discountedPrize;
	}


	//main function
	public static void main(String[] args) throws IOException {
		
		// USE OF THE CRYPTO LIBRARY
		
		String text = "Welcome to the hotels list reservation! Here is our information:";
		
		try {
			SecretKey key = generateKey("AES");
			Cipher chipher;
			chipher = Cipher.getInstance("AES");
			
			byte[] encryptedData = encryptString(text, key, chipher);
			String encryptedString = new String(encryptedData);
			System.out.println("ENCRYPTED --> " + encryptedString);
			String decrypted = decryptString (encryptedData, key, chipher);
			System.out.println("\nDECRYPTED --> " + decrypted);
			
		}catch (Exception e) {
			
		}
		
		// GENERICS
		
		System.out.println("\n\nUSE OF GENERICS: \n");

		// Create arrays of Integer, Double and Character
		String[] stringArray = { "The sound of the sea,", "Music time and", "Apollo." };
		Integer[] intArray = { 4, 5, 3 };
		Double[] doubleArray = { 10.0, 15.4919, 8.9442 };
		
		System.out.println("The names of our hotels are:");
		printArray(stringArray);   // pass a String array

		System.out.println("\nThe stars number of our hotels are:");
		printArray(intArray);   // pass an Integer array

		System.out.println("\nThe prizes of each room with discount are:");
		printArray(doubleArray);   // pass a Double array
	

		// LECTURA Y ESCRITURA DE FICHERO
		
		System.out.println("\n\nLECTURA Y ESCRITURA DE FICHERO:");

		// array of the hotels prices, no discount and discounted
		double[][] prices = { { 100, 240, 80},
							  { 10.0, 15.4919, 8.9442}};
		
		// escritura en el fichero de texto
		String idFichero = "numeros2.txt";
		
		PrintWriter ficheroSalida = new PrintWriter(idFichero);
		
		for (int i=0; i<prices.length; i++) {
			for (int j=0; j<prices[i].length; j++)
				ficheroSalida.print(prices[i][j] + ",");

			ficheroSalida.println("");
		}
		ficheroSalida.close();

		
		// lectura del fichero de texto "numeros2.txt"
		File ficheroEntrada = new File (idFichero);
		
		if (ficheroEntrada.exists()) {
			Scanner datosFichero = new Scanner(ficheroEntrada);
			System.out.println("\nHotels prices: \n");
			
			while (datosFichero.hasNext()) {
				String []numerosFichero = datosFichero.next().split(",");
				
				for (int i=0; i < numerosFichero.length; i++)
					System.out.print(numerosFichero[i] + "\t");
				System.out.println("");
			}
			datosFichero.close();
		}
		else
			System.out.println("The document does not exist!");




		// INTERFACE //

		ConjuntoHashSet c1 = new ConjuntoHashSet();

		c1.inserta("The sound of the sea");
		c1.inserta("Apollo");
		c1.inserta("Music time");

		System.out.println("\n\nINTERFACE OF THE HOTELS LIST:\n");

		System.out.print("Hotel Name?: ");
		System.out.flush();

		String hotelChoice = readLine();


		System.out.println("-> '" + hotelChoice + "' " + ((c1.contiene(hotelChoice)) ? "is in our list." : "is not in our list."));      // use of the ?: operator


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


				// the prize of each room
				double roomPrize = 100;

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
						roomnum = hotel1.reserveRoom(name);
					}
					//give feedback
					if (roomnum == -1) {
						System.out.println("No reservation possible!");
					} else {

						System.out.println("Are you over 70?");

						System.out.print("Age: ");
						System.out.flush();

						String age = readLine();

						if (age.equalsIgnoreCase("Yes")) {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + Math.sqrt(roomPrize));       // use of class Math

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();

						}else {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + roomPrize);

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();
						}
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

						System.out.println("Are you over 70?");

						System.out.print("Age: ");
						System.out.flush();

						String age = readLine();

						if (age.equalsIgnoreCase("Yes")) {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + Math.sqrt(roomPrize));

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();

						}else {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + roomPrize);

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();
						}
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

				// the prize of each room
				double roomPrize = 240;


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

						System.out.println("Are you over 70?");

						System.out.print("Age: ");
						System.out.flush();

						String age = readLine();

						if (age.equalsIgnoreCase("Yes")) {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + Math.sqrt(roomPrize));

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();

						}else {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + roomPrize);

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();
						}
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

						System.out.println("Are you over 70?");

						System.out.print("Age: ");
						System.out.flush();

						String age = readLine();

						if (age.equalsIgnoreCase("Yes")) {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + Math.sqrt(roomPrize));

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();

						}else {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + roomPrize);

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();
						}
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

				// the prize of each room
				double roomPrize = 80;


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

						System.out.println("Are you over 70?");

						System.out.print("Age: ");
						System.out.flush();

						String age = readLine();

						if (age.equalsIgnoreCase("Yes")) {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + Math.sqrt(roomPrize));

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();

						}else {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + roomPrize);

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();
						}
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

						System.out.println("Are you over 70?");

						System.out.print("Age: ");
						System.out.flush();

						String age = readLine();

						if (age.equalsIgnoreCase("Yes")) {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + Math.sqrt(roomPrize));

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();

						}else {

							System.out.println(name + " reserved room " + roomnum);

							System.out.println("The prize of the room is $" + roomPrize);

							System.out.println("Reservation did at " + datetimeNow);
							System.out.println();
						}
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

