//Created by Michael Beall

import java.util.*;
import java.io.*;

public class Simulation implements RCS_I<Object> {
	private char simboard[][];
	private RCS_Q<String> movequeue;
	public boolean valid;
	// tracks if the board file entered is valid
	
	public Simulation() {
		simboard = new char[10][10];
		// each board must be 10 by 10 spaces
		movequeue = new RCS_Q<String>();
	}
	
	public void startPrint(String filename) {
		try {
			Scanner boardReader = new Scanner(new File(filename));
			for (int i=0; i<10; i++) {
				simboard[i] = boardReader.nextLine().toCharArray();
				simboard[0][0] = 'R';
				System.out.println(simboard[i]);
			}
		}
		catch (Exception e) {
			System.out.println("The simboard that you entered is not valid.");
			valid = false;
		}
	}
	
	public void print() {
		for (int i=0; i<10; i++) {
			System.out.println(simboard[i]);
			//prints one line of the board, loops through 10 times
		}
	}
	
	public boolean isOnBoard(int row, int column, char simboard[][]) {
		if (row>=0 && row<10 && column>=0 && column<10 && (simboard[row][column] == '_' || simboard[row][column] == 'R'))
			return true;
		else
			return false;
		// checks that the chosen space is both in bounds and an underscore or a robot space
	}
	
	public void move(String command) {
		int row = 0;
		int column = 0;
		int amt = 1;
		// row, column track position; amt tracks command number
		
		try {
			Scanner comminfo = new Scanner(new File(command));
			boolean keepmoving = true;
			do {
				String moves = comminfo.nextLine();
				movequeue.enQueue(moves);
				
				if (movequeue.peek().equals("Move Up")) {
					System.out.println("\nCommand " + amt);
					
					if (isOnBoard(column - 1, row, simboard)) {
						simboard[column][row] = '_';
						simboard[column - 1][row] = 'R';
						column--;
						print();
						movequeue.deQueue();
						amt++;
					} else 
						break;
				} else if (movequeue.peek().equals("Move Down")) {
					System.out.println("\nCommand " + amt);
					
					if (isOnBoard(column + 1, row, simboard)) {
						simboard[column][row] = '_';
						simboard[column + 1][row] = 'R';
						column++;
						print();
						movequeue.deQueue();
						amt++;
					} else 
						break;
				} else if (movequeue.peek().equals("Move Right")) {
					System.out.println("\nCommand " + amt);
					
					if (isOnBoard(column, row + 1, simboard)) {
						simboard[column][row] = '_';
						simboard[column][row + 1] = 'R';
						row++;
						print();
						movequeue.deQueue();
						amt++;
					} else 
						break;
				} else if (movequeue.peek().equals("Move Left")) {
					System.out.println("\nCommand " + amt);
					
					if (isOnBoard(column, row - 1, simboard)) {
						simboard[column][row] = '_';
						simboard[column][row - 1] = 'R';
						row--;
						print();
						movequeue.deQueue();
						amt++;
					} else 
						break;
				}
			} while (comminfo.hasNext() && keepmoving);
			
			if (simboard[9][9] == 'R')
				System.out.println("You've reached the goal!");
			else
				System.out.println("Uh oh, looks like you crashed...");
			
			comminfo.close();
		} catch (Exception e) {
			if (valid)
				System.out.println("The simboard or controls that you entered are not valid.");
		}
	}

	public void enQueue(Object addToQueue) { }
	public Object deQueue() {
		return null;
	}
	public Object peek() {
		return null;
	}
}
