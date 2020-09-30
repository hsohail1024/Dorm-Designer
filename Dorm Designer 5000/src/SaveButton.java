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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveButton extends Button implements DormGUI {
	
	private static final int WIDTH = 96; //width constant for bed button
	private static final int HEIGHT = 32; //height constant for bed button

	private PApplet processing;
	private float[] position;
	private String label;

	/**
	 * this method is the constructor for this class
	 * and it initializes the fields to be used
	 * 
	 * @param x
	 * @param y
	 * @param processing
	 */
	public SaveButton(float x, float y, PApplet processing) {
		super(x, y, processing);
		this.position = new float[2]; //new float array of length 2
		this.position[0] = x; //assigns argument x to first index of position
		this.position[1] = y; //assigns argument y to second index of position
		this.processing = processing; //assigns argument processing to field processing
		this.label = "Save Room";

	}
	/**
	 * this method creates the button of saveButton
	 * when the mouse is over the button, the button should turn a dark grey color and when
	 * the mouse is not over the button, the button should return to a lighter grey just like the 
	 * other buttons
	 */
	public void update() {

		if (isMouseOver()) { // if mouse is over sofa Button
			this.processing.fill(100); // color bed with a darker grey
		} else {
			this.processing.fill(200); // color bed with light grey if mouse is not over the sofa
										// button
		}
		
		float upX = this.position[0] - (WIDTH / 2); //arguments for drawing rectangle
		float upY = this.position[1] - (HEIGHT / 2);//arguments for drawing rectangle
		float downX = this.position[0] + (WIDTH / 2);//arguments for drawing rectangle
		float downY = this.position[1] + (HEIGHT / 2);//arguments for drawing rectangle
		
		this.processing.rect(upX, upY, downX, downY); // draws rectangle

		this.processing.fill(0); //sets text drawing color to black
		this.processing.text(this.label, this.position[0], this.position[1]); //displays label

	}
	/**
	 * this method is called when the user clicks on saveButton to 
	 * allow the fuurniture that was set in the room by the user to be saved into the file 
	 * in the format of:
	 * "FURNITURE: xPosition, yPosition, rotations
	 * 
	 * if file cannot be created or overwritten, print message 
	 * "WARNING: Could not save room contents to file RoomData.ddd"
	 * 
	 * @param furniture
	 */
	@Override
	public void mouseDown(Furniture [] furniture) { //writing to a file
		
		try {
		File fileOut = new File("RoomData.ddd"); // creates or overwrites to file
		
		PrintWriter writer = new PrintWriter(fileOut);
		
		for (int i = 0; i < furniture.length; i++) {
			if(furniture[i] != null) { 
			writer.println(furniture[i]); //prints out the furniture name: xPosition, yPosition, 
										  //rotation of furniture
			}
		}
		writer.close(); //closes printWriter
		}catch(IOException e) { //if file can not be opened or overwritten, catches exception
			System.out.println("WARNING: Could not save room contents to file RoomData.ddd");
		}
	}

	/**
	 * if mouse is over the sofa button return isMouseOver as true
	 * 
	 * @return isMouseOver
	 */
	public boolean isMouseOver() {
		if (processing.mouseX >= this.position[0] - (WIDTH / 2) //makes sure that the mouse is over
																//load button when wanting to load 
				&& processing.mouseX <= this.position[0] + (WIDTH / 2)
				&& processing.mouseY >= this.position[1] - (HEIGHT / 2)
				&& processing.mouseY <= this.position[1] + (HEIGHT / 2)) {

			return true;
		} else {
			return false;
		}

	}
	@Override
	public void mouseUp() {
		// TODO Auto-generated method stub
		
	}


}
