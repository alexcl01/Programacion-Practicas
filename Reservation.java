package Practicas;

//Reservation class, stores the person and room number in the Hotel


public class Reservation{
	//instance variables
	private String name;
	private int roomNumber;
	private float prize;


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
	
	
	public Reservation(String person, int room, float prize) {					// new overloaded method
		this.name = person;
		this.roomNumber = room;
		this.prize = prize;
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
	
	
	// return the prize of the room
	public float getPrize() {
		return prize;
	}
	
}
