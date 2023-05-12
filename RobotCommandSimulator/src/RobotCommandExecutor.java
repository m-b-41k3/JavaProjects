//Created by Michael Beall

import java.util.*;

public class RobotCommandExecutor {
	public static void main(String[] args) {
		Scanner robotinfo = new Scanner(System.in);
		Simulation robotSim = new Simulation();
		System.out.println("Hello, welcome to the Robot Command Simulator");
		boolean cont = false;
		
		while (!cont) {
			System.out.println("Enter the board file name here.");
			String filename = robotinfo.nextLine();
			System.out.println("Enter the command(s) file name here.");
			String commsname = robotinfo.nextLine();
			
			System.out.println("Starting the simulation...");
			// prints the initial layout of the board
			robotSim.startPrint(filename);
			// "move" will move the robot all the way to the goal, if possible
			robotSim.move(commsname);
			
			System.out.println("Do you want to go again? Enter 'yes' to restart.");
			if(!robotinfo.nextLine().contains("yes")) {
				System.out.println("Have a nice day!");
				cont = true;
				// will close program
			}
		}
		robotinfo.close();
	}
}
