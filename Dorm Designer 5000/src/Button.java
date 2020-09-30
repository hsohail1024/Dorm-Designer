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
// Partner Name:    Sasha Arkhagha
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
public class Button implements DormGUI {
	
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	private static final String CREATE = "Create ";
	protected PApplet processing;
	private float[] position;
	protected String label;
	 
	public Button(float x, float y, PApplet processing) {

		this.processing = processing;
		this.position = new float [2];
		this.position[0] = x;
		this.position[1] = y;
		this.label = "Button";

		
	}
	

	@Override
	public void update() {
		
		if (isMouseOver()) { // if mouse is over the bed button use dark grey
			this.processing.fill(100);
		} else {
			this.processing.fill(200); // else use a lighter grey
		}
		float upX = this.position[0] - (WIDTH / 2); // creating a rectangle (topleft x corner)
		float upY = this.position[1] - (HEIGHT / 2); // creating a rectangle (topleft y corner)
		float downX = this.position[0] + (WIDTH / 2); // creating a rectangle (bottomright x corner)
		float downY = this.position[1] + (HEIGHT / 2); // creating a rectangle (bottomright y
		// corner)
		this.processing.rect(upX, upY, downX, downY); // draws rectangle

		this.processing.fill(0); //sets text drawing color to black
		if(this.label != "Clear Room") {
		this.processing.text(CREATE + this.label, this.position[0], this.position[1]); // centers around the
		}															   // position
		else {
		this.processing.text(this.label, this.position[0], this.position[1]);
		
		}
		
	}

	@Override
	public void mouseDown(Furniture[] furniture) {
		//if(this.label != "Clear Room") {
		for (int i = 0; i < furniture.length; i++) { // iterates through furniture object
			if (isMouseOver()) { // if isMouseOver method is true
				if (furniture[i] == null) { // finds the FIRST occurrence of null
					furniture[i] = new Furniture(this.label.toLowerCase(), processing); // assigns bedButton mouseDown
																		// method to
																		// furniture object and ith position
					break;
				}
			}

		}

		
	}

	@Override
	public void mouseUp() {
		
		
	}

	@Override
	public boolean isMouseOver() {
		if (processing.mouseX >= this.position[0] - (WIDTH / 2) // checks if the mouse is over the
																// bed button
				&& processing.mouseX <= this.position[0] + (WIDTH / 2)
				&& processing.mouseY >= this.position[1] - (HEIGHT / 2)
				&& processing.mouseY <= this.position[1] + (HEIGHT / 2)) {
			return true;
		} else {
			return false;
		}
	}

}
