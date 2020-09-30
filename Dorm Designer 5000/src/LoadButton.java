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
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadButton extends Button implements DormGUI {

	private static final int WIDTH = 96; //width constant for bed button
	private static final int HEIGHT = 32; //height constant for bed button

	private PApplet processing;
	private float[] position;
	private String label;

	/**
	 * this method is the constructor for LoadButton class. it initializes all the
	 * fields to be used for this class
	 * 
	 * @param x
	 * @param y
	 * @param processing
	 */
	public LoadButton(float x, float y, PApplet processing) {

		super(x, y, processing);
		this.position = new float[2]; //new float array of length 2
		this.position[0] = x; //assigns argument x to first index of position
		this.position[1] = y; //assigns argument y to second index of position
		this.processing = processing;
		this.label = "Load Room";

	}

	/**
	 * this method creates the button for Load option along with showing user
	 * clearly when the mouse is over this button by turning the button a darker
	 * grey if mouse is over it
	 * 
	 */
	public void update() {

		if (isMouseOver()) { // if mouse is over sofa Button
			this.processing.fill(100); // color bed with a darker grey
		} else {
			this.processing.fill(200); // color bed with light grey if mouse is not over the sofa
			// button
		}

		float upX = this.position[0] - (WIDTH / 2); // arguments for drawing rectangle
		float upY = this.position[1] - (HEIGHT / 2);// arguments for drawing rectangle
		float downX = this.position[0] + (WIDTH / 2);// arguments for drawing rectangle
		float downY = this.position[1] + (HEIGHT / 2);// arguments for drawing rectangle

		this.processing.rect(upX, upY, downX, downY); // draws rectangle

		this.processing.fill(0); //sets text drawing color to black
		this.processing.text(this.label, this.position[0], this.position[1]); //displays label

	}

	/**
	 * this method is called when the user clicks on LoadButton and allows for
	 * loading the file (RoomData.ddd) to allow for the contents of that file to be
	 * printed at their specific location
	 * 
	 * @param furniture
	 * @throws FileNotFoundException
	 */
	@Override
	public void mouseDown(Furniture[] furniture)  {
		String line = null; // stores each line of file
		int count = 0; // counts the number of lines in file
		String fileFurniture = ""; //name of furniture
		int rotations = 0;
		float[] xAndY = new float[2]; //used to store position x and y of furniture

		Scanner scnr = null;
		for (int i = 0; i < furniture.length; i++) {
			furniture[i] = null; // sets all current furniture to null
		}
		try {
			File file = new File("RoomData.ddd");

			scnr = new Scanner(file); // allows to read file using Scanner

			for (int i = 0; i < furniture.length; i++) {
				try {
				while (scnr.hasNextLine()) { // while scanner has next line to read
					count++; // increment count to count the number of lines in the file

					if (count > furniture.length) { // if count exceeds furniture length print
													// message
						System.out.println("WARNING: Unable to load more furniture.");
					}
					line = scnr.nextLine(); // stores each line into a String

					String[] splitLines = line.split(":|\\,"); // splits each line wherever there is
																// a : or ,

					fileFurniture = splitLines[0].trim(); // stores the first string array
															// (furniture name) and trims whitespace

					boolean correctFile = inCorrectFormatLine(fileFurniture, line); // calls helper
																					// method to
																					// check if the
																					// line is in
																					// the correct
																					// format

					boolean correctImage = imageFile(fileFurniture); // calls helper method to check
																		// if the image of furniture
																		// exists

					if (correctFile && correctImage) { // if the correct File and correct image are
													   // present prints furniture
						xAndY[0] = Float.parseFloat(splitLines[1].trim());  // change string
																			// representation
																			// of x Position to float
						xAndY[1] = Float.parseFloat(splitLines[2].trim());  // change string
																			// representation
																			// of y Position to float
						rotations = Integer.parseInt(splitLines[3].trim()); // changes string
																			// representation
																			// of rotations to int

						
						/*
						 * creates a new furniture using date from the file
						 */
						furniture[i] = new Furniture(fileFurniture, processing, xAndY, rotations); 
						break;
					}
				}
				}
				catch(NumberFormatException e) {
					inCorrectFormatLine(fileFurniture, line);
				}
			}
		} catch (FileNotFoundException e) { // when loading file, if no file is found prints error
			System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
		} 

	}

	/**
	 * this is a helper method which returns a booelean value if the imageFile does
	 * exist
	 * 
	 * @param furniture
	 * @return
	 */
	private boolean imageFile(String furniture) {
		boolean imageExists = false;
		File f = new File("images/" + furniture + ".png"); // creates a new file with furniture

		if (f.exists()) { // if that imageFile exists assign imageExists to true
			imageExists = true;
		} else { // else print message for warning
			System.out.println("WARNING: Could not find an image for a furniture object of type: <"
					+ furniture + ">");
			imageExists = false;
		}

		return imageExists;

	}

	/**
	 * this helper method checks the furnitureName to see if it is a correctly
	 * formatted line or not
	 * 
	 * @param furnitureName
	 * @param errorLine
	 * @return
	 */
	private boolean inCorrectFormatLine(String furnitureName, String errorLine) {
		boolean flag = true;
		int counterComma = 0;
		char[] commas = errorLine.toCharArray();
		
		for(int i = 0; i < commas.length; i++) {
			if(commas[i] == ',') {
				counterComma++;
			}
		}
		if (furnitureName.isEmpty() || furnitureName == null && counterComma != 2 && 
				!errorLine.contains(":")) { // if a furniture name is not present
			System.out.println(
					"WARNING: Found incorrectly formatted line in file: <" + errorLine + ">");
			flag = false;
		}
		
		return flag;

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
