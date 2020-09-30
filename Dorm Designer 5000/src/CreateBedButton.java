////////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
////
//// Title:           Dorm Designer 4000
//// Files:           Main.java, Furniture.java, CreateSofaButton.java, CreateBedButton.java
////					SaveButton.java, LoadButton.java, and RoomData.ddd
//// Course:          CS 300, Spring, 2018
////
//// Author:          Huzaifa Sohail
//// Email:           hsohail@wisc.edu
//// Lecturer's Name: Gary Dahl
////
////////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
////
//// Partner Name:    Sasha Arkhagha
//// Partner Email:   arkhagha@wisc.edu
//// Lecturer's Name: Mouna Kacem
//// 
//// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
////   _X__ Write-up states that pair programming is allowed for this assignment.
////   _X__ We have both read and understand the course Pair Programming Policy.
////   _X__ We have registered our team prior to the team registration deadline.
////
/////////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
////
//// Students who get help from sources other than their partner must fully 
//// acknowledge and credit those sources of help here.  Instructors and TAs do 
//// not need to be credited here, but tutors, friends, relatives, room mates 
//// strangers, etc do.  If you received no outside help from either type of 
//// source, then please explicitly indicate NONE.
////
//// Persons:         NONE
//// Online Sources:  NONE
////
///////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
//public class CreateBedButton extends Button implements DormGUI {
//
//	
//	private static final int WIDTH = 96; //width constant for bed button
//	private static final int HEIGHT = 32; //height constant for bed button
//
//	private PApplet processing;
//	private float[] position;
//	private String label;
//
//	/**
//	 * this is the constructor for CreateBedButton class which will initialize all
//	 * the fields to be used in later methods
//	 * 
//	 * @param x
//	 * @param y
//	 * @param processing
//	 */
//	
//	public CreateBedButton(float x, float y, PApplet processing) {
//		
//		super(x, y, processing);
//		this.position = new float[2]; // creates a float array of length 2
//		this.position[0] = x; //assigns xPosition to first index of position
//		this.position[1] = y; //assigns yPosition to second index of position
//		this.processing = processing; //assigns argument processing to private field processing
//		this.label = "Create Bed";
//
//	}
//
//	/**
//	 * this method creates the Bed Button and allows for the color of the button to
//	 * change when the mouse is over the button will turn a dark grey color and when
//	 * the mouse is not over the button, the color should be just like the other
//	 * buttons
//	 */
//	public void update() {
//
//		if (isMouseOver()) { // if mouse is over the bed button use dark grey
//			this.processing.fill(100);
//		} else {
//			this.processing.fill(200); // else use a lighter grey
//		}
//		float upX = this.position[0] - (WIDTH / 2); // creating a rectangle (topleft x corner)
//		float upY = this.position[1] - (HEIGHT / 2); // creating a rectangle (topleft y corner)
//		float downX = this.position[0] + (WIDTH / 2); // creating a rectangle (bottomright x corner)
//		float downY = this.position[1] + (HEIGHT / 2); // creating a rectangle (bottomright y
//		// corner)
//		this.processing.rect(upX, upY, downX, downY); // draws rectangle
//
//		this.processing.fill(0); //sets text drawing color to black
//		this.processing.text(this.label, this.position[0], this.position[1]); // centers around the
//		// position
//
//	}
//
//	/**
//	 * this method checks if the mouse is over the bed button and if so, when the
//	 * button is clicked this method should create a new furniture of type bed if
//	 * the mouse is not over the button and the button is clicked, this should not
//	 * make any additions.
//	 * 
//	 * @return
//	 */
//	
//	public void mouseDown(Furniture[] furniture) {
//
//		
//		for (int i = 0; i < furniture.length; i++) { // iterates through furniture object
//			if (isMouseOver()) { // if isMouseOver method is true
//				if (furniture[i] == null) { // finds the FIRST occurrence of null
//					furniture[i] = new Furniture("bed", processing); // assigns bedButton mouseDown
//																		// method to
//																		// furniture object and ith position
//					break;
//				}
//			}
//
//		}
//
//	}
//
//	/**
//	 * this method should be used whenever the BedButton is created to allow for
//	 * certain actions to be taken only when this method returns true
//	 * 
//	 * @return isMouseOver
//	 */
//	@Override
//	public boolean isMouseOver() {
//		if (processing.mouseX >= this.position[0] - (WIDTH / 2) //checks if the mouse is over the 
//																//bed button
//				&& processing.mouseX <= this.position[0] + (WIDTH / 2)
//				&& processing.mouseY >= this.position[1] - (HEIGHT / 2)
//				&& processing.mouseY <= this.position[1] + (HEIGHT / 2)) {
//			return true;
//		} else {
//			return false;
//		}
//
//	}
//
//
//
//	@Override
//	public void mouseUp() {
//		
//		
//	}
//
//}
