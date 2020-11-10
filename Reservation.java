package Practicas;

import java.util.ArrayList;

//Reservation class, stores the person and room number in the Hotel


public class Reservation{
	//instance variables
	private String name;
	private int roomNumber;

	
	private ArrayList<Reservation> rooms;

	//constructors, must supply the name, and optionally a room
	
	public Reservation() {
		
	}
	
	public Reservation(String person) {
		this.name = person;
	}

	public Reservation(String person, int room) {
		this.name = person;
		this.roomNumber = room;
	}

	//set the room number or name
	public void setRoom(int newroom) {
		roomNumber = newroom;
	}

	public void setName(String newname) {
		name = newname;
	}

	public String toString() {
		return (name + "   " + roomNumber);
	}

	//return the room number or name
	public int getRoom() {
		return roomNumber;
	}

	public String getName() {
		return name;
	}
	

	//prints out all the current reservations to the screen
	//also should display the total number of reservations and vacancies
	
	public void printReservations() {
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i) != null) {
				System.out.println(rooms.get(i));  
			} else {
				System.out.println((i + 1) + " is not reserved");
			}
		}
	}
}
