package lviv.lgs.ua;

import java.util.Scanner;

public class Main {
	
	static void menu() {
		System.out.println();
		System.out.println("Enter 1 to add a new member of the ZooClub");
		System.out.println("Enter 2 to add a new animal for the member of the ZooClub");
		System.out.println("Enter 3 to remove animal fron the member of the ZooClub");
		System.out.println("Enter 4 to remove the member of the ZooClub");
		System.out.println("Enter 5 to remove the the animal from all members of the ZooClub");
		System.out.println("Enter 6 to display the ZooClub on the screen"); 
		System.out.println("Enter 7 to exit from the program"); 
	}

	public static void main(String[] args) {
		ZooClub zooClub = new ZooClub();
		Scanner scanner = new Scanner (System.in); 
		
		
		while (true) {
			menu(); 
			
			switch (scanner.nextInt()) {
			case 1: {
				zooClub.addZooClubMember();
				break;
			}
			
			case 2: {
				zooClub.addAnimal();
				break;
			}
			
			case 3: {
				zooClub.removeAnimal();
				break;
			}
			
			case 4: {
				zooClub.removeZooClubMember();
				break;
			}
			case 5: {
				zooClub.removeAnimalFromAllMembers();
				break;
			}
			
			case 6: {
				zooClub.viewZooClub();
				break;
			}
			case 7: {
				System.exit(0);
				break;
			}
			
			default: {
				System.out.println("Please, enter the number from 1 to 7");
				break;
			}
			}
		}
	}
}
