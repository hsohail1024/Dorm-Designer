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
public class ClearButton extends Button implements DormGUI{

	float xPosition;
	float yPosition;
	
	public ClearButton(float f, float g, PApplet processing) {
		super(f, g, processing);
		this.processing = processing;
		this.xPosition = f;
		this.yPosition = g;
		this.label = "Clear Room";
	}
	
	@Override
	public void mouseDown(Furniture[] furniture) {
			for(int i = 0; i < furniture.length; i++) {
				furniture[i] = null;
			}
			
		}
		
	
	
	

}
