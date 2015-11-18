package kops.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are reserved.
 * You are allowed to add your own member variables and private methods.
 */
public class AirplaneSeats {

	private int rows;
	private int columns;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	

	// map will hold a list of all seats and whether or not they are reserved 
	private HashMap<String, Boolean> seatReservations = new HashMap<String, Boolean>();	
	
	/**
	 * @param rows the number of rows of seats on the plane.
	 * @param columns the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		String columnName;
		
		// fill hashmap with seat names and set their reserved status to false
		for(int i = 1; i < rows+1; i++){
			for(int j = 0; j< columns; j++){
				columnName = Character.toString(alphabet.charAt(j));
				seatReservations.put((columnName+ Integer.toString(i)), false);					
			}
	
		}

	}
	
	/**
	 * @param seatName is a String in the form of "A1" where "A" is the column and 1 is the row. 
	 * 			The first row on the plane is 1.
	 * @throws AlreadyReservedException if the seat has already been reserved
	 * @throws SeatOutOfBoundsException if the seat is outside the columns and rows set in the constructor
	 */
	public void reserve( String seatName ) throws AlreadyReservedException, SeatOutOfBoundsException {
		if(!(seatReservations.containsKey(seatName))){
			throw new SeatOutOfBoundsException();
		}
		
		else if(this.seatReservations.get(seatName) == true){
			throw new AlreadyReservedException();
		}
		 
		else{
			this.seatReservations.put(seatName, true);
		}
	}
	

	/**
	 * @param seatName is a String in the form of "A1" where "A" is the column and 1 is the row. 
	 * 			The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved( String seatName ) {
		return (this.seatReservations.get(seatName));
	}
	
	
	/**
	 * Reserve all seats in the array of seatNames. This is provided here for convenience of testing. 
	 * Do not modify this method.
	 * @param seatNames is an array of seatNames
	 * @throws AlreadyReservedException if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException if one of the seats is outside the columns and rows set in the constructor
	 */
	public void reserveAll( String ... seatNames ) throws AlreadyReservedException, SeatOutOfBoundsException {
		for ( String seatName : seatNames ) {
			reserve(seatName);
		}
	}
	
	
	/**
	 * This method is worth 10 points.
	 * @return a String representation of reserved and empty seats on the plane in the form of.
	 * 
	 *   ABCD
	 * 1 #oo#\n
	 * 2 #ooo\n
	 * 3 ###o\n
	 * 4 ##oo\n
	 * 5 #ooo\n
	 * 
	 * Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		char columnLetter;
		String seatname;
		
		StringBuilder b = new StringBuilder();
		// first row
		b.append("  ");
		char letter = 'A';
		for(int i = 0; i < columns; i++){
			b.append(letter);
			letter++;
		}
		b.append("\n");
		
		// rest of the rows
		for(int i = 1; i< rows+1; i++){
			b.append(i + " ");
			for(int j = 0; j < columns; j++){
				columnLetter = this.alphabet.charAt(j);	// if j is 0, seat column will be 'A'
				Character.toString(columnLetter);
				seatname = columnLetter+Integer.toString(i);
				
				if(this.seatReservations.get(seatname) == true){
					b.append("#");
				}
				else{
					b.append("o");
				}
				
			}
		b.append("\n");		// go to next row
			
		}	
		
		return b.toString();
	}
	
	
	
	
	
	/**
	 * This method is worth 10 points
	 * Reserve a group of seats in the same row. For instance, on a 3,4 airplane whose "A1" is occupied, 
	 * calling reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * @param numberOfSeatsTogether the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException if there are not enough seats together to reserve.
	 * @throws SeatOutOfBoundsException 
	 * @throws AlreadyReservedException 
	 */

	// if want 4 in a row, will go to next row if one is taken
	public ArrayList<String> reserveGroup( int numberOfSeatsTogether ) throws NotEnoughSeatsException, AlreadyReservedException, SeatOutOfBoundsException {
		
		ArrayList<String> reservedGroup = new ArrayList<String>();		
		String seatName;
		int counter = 0;
		
		
		for(int i = 1; i < rows+1; i++){ 		//going row by row
			
			for(int j = 0; j < columns; j++){		//if this row contains enough consecutive seats, 
													//return the consecutive seats.
													// otherwise, go to the next row and check			
				//get seat name
				seatName = Character.toString(alphabet.charAt(j)) + Integer.toString(i);
				
				if(counter < numberOfSeatsTogether){
					if(isReserved(seatName) == false){
					reservedGroup.add(seatName);
					counter++;		//increment amount of consecutive seats
					}
					else{	//this reserved seat breaks up the succession, so start calculations over again
						reservedGroup.removeAll(reservedGroup);
						counter = 0;
						break;
					}
				}
				else {	//found enough consecutive seats
					for(String seat: reservedGroup){
						reserve(seat);
					}
					return reservedGroup;
				}
				
			}	
		}
		
		
		if(reservedGroup.size()==0){	//there were not enough seats together
			throw new NotEnoughSeatsException();
		}
		return reservedGroup;
		
	}
	
	
	
	
	
	
	
	
	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		
		boolean isFull = true;
		
		// Check every seat on board. If one is unreserved, isFull is false
		for(Map.Entry<String, Boolean> entry : seatReservations.entrySet()){
				if(entry.getValue() == false){		
				isFull = false;
			}
		}	
		
		return isFull;
	}
	
}
