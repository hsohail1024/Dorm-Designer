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
public class CreateFurnitureButton extends Button {

	public CreateFurnitureButton(String type, float x, float y, PApplet processing) {
		super(x, y, processing);
		this.label = type;
		
	}
	
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
//		} else {
//			for(int i = 0; i < furniture.length; i++) {
//				furniture[i] = null;
//			}
//		}
		
	}
}
