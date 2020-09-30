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

import java.util.ArrayList;

public class Main {

	private PApplet processing;
	private PImage backgroundImage;
	
	private ArrayList<DormGUI> guiObjects; //stores all of the furniture and button references
	

	public static void main(String[] args) {
		Utility.startApplication(); //allows for the entire program to run and calls Main constructor

	}

	/**
	 * this constructor initializes all of the fields from Main class which will
	 * help run the entire program
	 * 
	 * @param processing
	 */
	public Main(PApplet processing) { // constructor for Main class

		backgroundImage = processing.loadImage("images/background.png"); // loads image of
		// background

		this.processing = processing;

		this.guiObjects = new ArrayList<DormGUI>();

		this.guiObjects.add(new CreateFurnitureButton("Bed", 50.0f, 24.0f, processing));
		this.guiObjects.add(new CreateFurnitureButton("Sofa", 150.0f, 24.0f, processing));
		this.guiObjects.add(new CreateFurnitureButton("Dresser", 250.0f, 24.0f, processing));
		this.guiObjects.add(new CreateFurnitureButton("Desk", 350.0f, 24.0f, processing));
		this.guiObjects.add(new CreateFurnitureButton("Sink", 450.0f, 24.0f, processing));

		this.guiObjects.add(new ClearButton(550.0f, 24.0f, processing));

		this.guiObjects.add(new SaveButton(650.0f, 24.0f, processing));
		this.guiObjects.add(new LoadButton(750.0f, 24.0f, processing));

	}

	/**
	 * this method is responsible for creating the background color along with the
	 * background image and to call the update methods for all the other classes
	 * furniture update should only be called if the furniture at that index is not
	 * null
	 */
	public void update() { // runs over and over again

		processing.background(100, 150, 250); // background color
		processing.image(backgroundImage, processing.width / 2, processing.height / 2); // draws the
		// image of background

		for (int i = 0; i < this.guiObjects.size(); i++) {
			// if (furniture[i] != null) { // checks if the i'th bed position is not null
			this.guiObjects.get(i).update(); // runs update if furniture array is not null
			// }
		}
	}

	/**
	 * this method will handle all of the other mouseDown methods of the other
	 * classes with the following criteria; 
	 * 
	 * BedButton and SofaButton should only be called at the first occurance of a null in furnture 
	 * arrray and should not create more furniture than the length of the furnture array 
	 * 
	 * This method should also be called for SaveButton and LoadButton when the mouse is over
	 * these buttons respectively
	 * 
	 */
	public void mouseDown() {

		Furniture[] furnitureArray = extractFurnitureFromGUIObjects();
		for (int i = 0; i < this.guiObjects.size(); i++) {
			if (this.guiObjects.get(i).isMouseOver() == true) {
				this.guiObjects.get(i).mouseDown(furnitureArray);
				break;
			}
		}
		replaceFurnitureInGUIObjects(furnitureArray);
	}

	public void mouseUp() {
		for (int i = 0; i < this.guiObjects.size(); i++) {
			if (this.guiObjects.get(i) != null) {
				this.guiObjects.get(i).mouseUp();
			}
		}
	}

	/**
	 * this method takes care of when the user enters in a key to determine what
	 * will happen to the code according to the key pressed.
	 * 
	 *  When the user presses D or d, the furniture that the mouse is currently 
	 *  over should be deleted from the furniture array 
	 *  
	 *  When the user presses R or r, the furniture that the mouse is currently over should rotate 
	 *  90 degrees clockwise and should continue to do so as long as the user 
	 *  continues to press the specified key
	 */
	public void keyPressed() {

		for (int i = 0; i < this.guiObjects.size(); i++) {

			if (this.processing.key == 'D' || this.processing.key == 'd') { // deletes the furniture
																			// when mouse is over it
				//for (int i = 0; i < this.furniture.length; i++) {
					if (this.guiObjects.get(i) != null) {
						if (this.guiObjects.get(i).isMouseOver()) { // if mouse is over that ith
																	// furniture
							if (this.guiObjects.get(i) instanceof Furniture) {
								//this.guiObjects.set(i, null); // set that i'th furniture to null
																// (deletes
								this.guiObjects.remove(i);
								// furniture)
								break;
							}
						}
					//}
				}
			}

			if (this.processing.key == 'R' || this.processing.key == 'r') { // rotates the furniture
				// when mouse is over it
				//for (int i = 0; i < this.furniture.length; i++) {
					if (this.guiObjects.get(i) != null) {
						if (this.guiObjects.get(i).isMouseOver()) { // if mouse is over that ith
																	// furniture
							if(this.guiObjects.get(i) instanceof Furniture) {
							((Furniture) this.guiObjects.get(i)).rotate(); // calls rotate method for that ith
																// furniture
						}
					}
				}
			}
		}
	}
	
	// Max number of furniture that LoadButton will be allowed to load at once.    
	private final static int MAX_LOAD_FURNITURE = 100;        
	/**
	 * This method creates a new Furniture[] for the old mouseDown() methods
	 * to make use of.  It does so by copying all Furniture references from
	 * this.guiObjects into a temporary array of size MAX_LOAD_FURNITURE.
	 * @return that array of Furniture references.
	 */
	private Furniture[] extractFurnitureFromGUIObjects() {
	    Furniture[] furniture = new Furniture[MAX_LOAD_FURNITURE];
	    int nextFreeIndex = 0;
	    for(int i=0;i<guiObjects.size() && nextFreeIndex < furniture.length;i++)
	        if(guiObjects.get(i) instanceof Furniture)
	            furniture[nextFreeIndex++] = (Furniture)guiObjects.get(i);        
	    return furniture;    
	}    
	/**
	 * This method first removes all Furniture references from this.guiObjects,
	 * and then adds back in all of the non-null references from it's parameter.
	 * @param furniture contains the only furniture that will be left in 
	 *   this.guiObjects after this method is invoked (null references ignored).
	 */
	private void replaceFurnitureInGUIObjects(Furniture[] furniture) {
	    for(int i=0;i<guiObjects.size();i++)
	        if(guiObjects.get(i) instanceof Furniture)
	            guiObjects.remove(i--);
	    for(int i=0;i<furniture.length;i++)
	        if(furniture[i] != null)
	            guiObjects.add(furniture[i]);
	}

}
