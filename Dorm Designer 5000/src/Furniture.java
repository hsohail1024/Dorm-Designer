//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dorm Designer 5000
// Files:           Main.java, Furniture.java, SaveButton.java, LoadButton.java,Button.java
//                  CreateFurnitureButton.java, ClearButton.java, DormGUI.java, and RoomData.ddd
// Course:          CS 300, Spring, 2018
//
// Author:          Huzaifa Sohail
// Email:           hsohail@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    
// Partner Email:   
// Lecturer's Name: 
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class Furniture implements DormGUI {

	private PApplet processing;
	private PImage image;
	private float[] position;
	private boolean isDragging;
	private int rotations; //keeps track of the number of rotations done
	private String furn; // string for furniture

	/**
	 * initializes the fields of a new bed object positioned in the center of the
	 * display
	 * 
	 * 
	 * @param String furniture
	 * @param PApplet processing
	 */
	public Furniture(String furniture, PApplet processing) {

		this.furn = furniture; //assigns argument furniture to private field furn
		this.processing = processing; //assigns argument processing to processing field
		this.position = new float[2]; //creates a new float array of length 2

		this.image = processing.loadImage("images/" + furniture + ".png"); // loads image of bed

		this.isDragging = false;

		position[0] = processing.width / 2; // sets furniture Object position field in the center of
											// display (width)
		position[1] = processing.height / 2; // sets furniture Object position field in the center
											 // of display (height)

	}

	/**
	 * this overloaded constructor is used to create the furniture from a file when
	 * the LoadButton is pressed. This method will read the in the different
	 * parameters and assign the furniture to the specific position that that file
	 * has designated for that Furniture object
	 * 
	 * @param fileFurniture
	 * @param processing
	 * @param positions
	 * @param rotations
	 */
	public Furniture(String fileFurniture, PApplet processing, float[] positions, int rotations) { 

		this.furn = fileFurniture; //assigns argument fileFurniture to field furn

		this.processing = processing; //assigns argument processing to field PApplet processing

		this.image = processing.loadImage("images/" + fileFurniture + ".png"); //leads image of 
																			   //furniture

		position = new float[2]; //creates a new float of length 2

		position[0] = positions[0]; //assigns argument positions first index to private field
									//position first index
		position[1] = positions[1]; //assigns argument positions first index to private field
									//position first index
		this.rotations = rotations; //assigns the number of rotations from file to field rotations

	}

	/**
	 * this toString method takes the object representation of the furniture array
	 * and returns a string representation of the array in the format of how the
	 * file should be when the contents of our self built dorm are saved to a file
	 */
	@Override
	public String toString() {
		return String
				.valueOf(this.furn + ": " + position[0] + ", " + position[1] + ", " + rotations);
	}

	/**
	 * this method should allow for the Furniture object to be printed onto the
	 * screen regardless of if the user had pressed R or not. Also in this method,
	 * the Furniture object should be allowed to be clicked down on and moved around
	 * to whereever the user would like
	 */
	public void update() {

		if (this.rotations >= 1) { // if user presses r, rotates clockwise 90 degrees
			processing.image(image, position[0], position[1], rotations * PApplet.PI / 2); 

		} else {
			this.processing.image(image, this.position[0], this.position[1]); // else prints
																			  // original image
		}	

		if (isDragging) { // if isDragging is true
			this.position[0] = this.processing.mouseX; // set mouseX to positionX
			this.position[1] = this.processing.mouseY; // set mouseY to positionY

		}

	}

	/**
	 * this method sets isDragging to true if thhe mouse is clicked down only when
	 * the mouse is is over a Furniture object
	 */
	public void mouseDown(Furniture[] furniture) {
		//for (int i = 0; i < furniture.length; i++) {
			//if (furniture[i] != null) {
				if (isMouseOver()) {

					this.isDragging = true;
				}
			//}
		//}
	}

	/**
	 * this method should not allow for dragging any furniture to take place if the
	 * mouse has not been clicked it is simply used to indicate that the no
	 * furniture is moved when the mouse is up
	 */
	public void mouseUp() {
		this.isDragging = false;

	}

	/**
	 * this method allows for the furniture to be moved within the window to
	 * wherever the user would like and should be flexible enough that when the user
	 * has rotated the furniture, the furniture should still be able to be clicked
	 * down and move the furniture again
	 * 
	 * @return
	 */
	public boolean isMouseOver() {

		if (this.rotations % 2 == 1 && this.furn != null) { // if rotation is an odd number

			if (this.processing.mouseX > this.position[0] - (0.5 * this.image.height) // if image is
																					  // rotated
																					  // an odd
																					  // number of
																					  // times
					&& this.processing.mouseX < this.position[0] // changed the height and width to
																 // work for vertical rotated
																 // image
							+ (0.5 * this.image.height)
					&& this.processing.mouseY > this.position[1] - (0.5 * this.image.width)
					&& this.processing.mouseY < this.position[1] + (0.5 * this.image.width)) {
				this.isDragging = true; // sets isDragging to true
			} else {

				this.isDragging = false;
			}

		} else { // if rotation is an even number

			if (this.processing.mouseX > this.position[0] - (0.5 * this.image.width) // leaves
																					 // original
																					 // width and
																					 // height
					&& this.processing.mouseX < this.position[0] + (0.5 * this.image.width)
					&& this.processing.mouseY > this.position[1] - (0.5 * this.image.height)
					&& this.processing.mouseY < this.position[1] + (0.5 * this.image.height)) {
				this.isDragging = true;
			} else {

				this.isDragging = false;
			}

		}

		return this.isDragging;

	}

	/**
	 * this method simply checks to see how many times R or r was pressed
	 */
	public void rotate() {
		this.rotations++; // increments rotation every time R or r is called

	}


}
