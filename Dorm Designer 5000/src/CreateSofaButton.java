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
//public class CreateSofaButton extends Button implements DormGUI {
//
//	private static final int WIDTH = 96; //width constant for bed button
//	private static final int HEIGHT = 32; //height constant for bed button
//
//	private PApplet processing;
//	private float[] position;
//	private String label;
//
//	/**
//	 * this is the constructor for CreateSofaButton this initializes the fields of
//	 * the class
//	 * 
//	 * @param x
//	 * @param y
//	 * @param processing
//	 */
//	public CreateSofaButton(float x, float y, PApplet processing) {
//
//		super(x, y, processing);
//		this.position = new float[2]; // creates a float array of length 2
//		this.position[0] = x; //assigns xPosition to first index of position
//		this.position[1] = y; //assigns yPosition to second index of position
//		this.processing = processing; //assigns argument processing to private field processing
//		this.label = "Create sofa";
//
//	}
//
//	/**
//	 * this method creates the button of CreateSofaButton when the mouse is over the
//	 * button, the button should turn a dark grey color and when the mouse is not
//	 * over the button, the button should return to a lighter grey just like the
//	 * other buttons
//	 */
//	public void update() {
//
//		if (isMouseOver()) { // if mouse is over sofa Button
//			this.processing.fill(100); // color bed with a darker grey
//		} else {
//			this.processing.fill(200); // color bed with light grey if mouse is not over the sofa
//									   // button
//		}
//
//		float upX = this.position[0] - (WIDTH / 2); // arguments for drawing rectangle (top left x)
//		float upY = this.position[1] - (HEIGHT / 2);// arguments for drawing rectangle (top left y)
//		float downX = this.position[0] + (WIDTH / 2);// arguments for drawing rectangle (bottom rt x)
//		float downY = this.position[1] + (HEIGHT / 2);// arguments for drawing rectangle (bottom rt y)
//
//		this.processing.rect(upX, upY, downX, downY); // draws rectangle
//
//		this.processing.fill(0); //sets text drawing color to black
//		this.processing.text(this.label, this.position[0], this.position[1]); //displays label at
//																		      //center of sofa button
//
//	}
//
//	/**
//	 * this method allows for the user to create a new SOFA furniture when the
//	 * button is clicked If the mouse is not over the button, nothing should happen
//	 * 
//	 * @return
//	 */
//	@Override
//	public void mouseDown(Furniture[] furniture) {
//		
//		
//		for (int i = 0; i < furniture.length; i++) { // iterates through furniture object
//			if (this.isMouseOver()) {
//				if (furniture[i] == null) { // finds the FIRST occurrence of null
//					furniture[i] = new Furniture("sofa", processing); // assigns sofaButton
//																		// mouseDown method
//																		// to furniture object and ith position
//					break;
//				}
//			}
//
//		}
//
//	}
//
//	/**
//	 * this method should be used whenever the SofaButton is created to allow for
//	 * certain actions to be taken only when this method returns true
//	 * 
//	 * @return isMouseOver
//	 */
//	public boolean isMouseOver() {
//		if (processing.mouseX >= this.position[0] - (WIDTH / 2) //checks if the mouse is over the 
//																//bed button
//				&& processing.mouseX <= this.position[0] + (WIDTH / 2)
//				&& processing.mouseY >= this.position[1] - (HEIGHT / 2)
//				&& processing.mouseY <= this.position[1] + (HEIGHT / 2)) {
//
//			return true;
//		} else {
//			return false;
//		}
//
//	}
//
//
//	@Override
//	public void mouseUp() {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
