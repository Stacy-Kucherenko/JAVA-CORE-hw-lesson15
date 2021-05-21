package lviv.lgs.ua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;







public class ZooClub {

	
	Map <Person, ArrayList<Animal>> zooClub = new HashMap<Person, ArrayList<Animal>>();
			
	public void addZooClubMember() {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Please, enter the name of the member of the ZooClub: ");
		String name = scanner.next(); 
		System.out.println("Please, enter the age of the ZooClub member:");
		int age = scanner.nextInt();
		
		
		Person zooClubMember = new Person (name, age);
		zooClub.put(zooClubMember, new ArrayList<Animal>());
		System.out.println(zooClubMember.toString() + " successfully added to the ZooClub: ");
	}
	
	public void addAnimal () {
		Scanner scanner = new Scanner (System.in); 
		System.out.println("Please, enter the name of the member of the ZooClub: ");
		String name = scanner.next(); 
		System.out.println("Please, enter the age of the ZooClub member:");
		int age = scanner.nextInt();
		
		boolean dataIsCorrect = isZooClubMemberExist(zooClub, name, age);
		
		if (dataIsCorrect) {
			System.out.println("Enter the animal species:  ");
			String species = scanner.next();
			System.out.println("Enter the name of the animal: ");
			String animalName = scanner.next(); 
			
			Animal newAnimal = new Animal (species, animalName);
			Iterator <Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();
			
			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> nextMember = iterator.next(); 
				
				if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
					ArrayList<Animal> animalList = nextMember.getValue();
					animalList.add(newAnimal); 
					System.out.println("Animal " + newAnimal.toString() + " successfully added to member " + nextMember.getKey() );
				}
			}
		} else {
			System.out.println("The entered member is not a member of the ZooClub");
		}
	}
	
	public void removeAnimal () {
		
		Scanner scanner = new Scanner (System.in); 
		System.out.println("Please, enter the name of the member of the ZooClub: ");
		String name = scanner.next(); 
		System.out.println("Please, enter the age of the ZooClub member:");
		int age = scanner.nextInt();
		
		
		boolean dataIsCorrect = isZooClubMemberExist(zooClub, name, age);
		
		if (dataIsCorrect) {
			
			System.out.println("Enter the animal species:  ");
			String species = scanner.next();
			System.out.println("Enter the name of the animal: ");
			String animalName = scanner.next(); 
			
			boolean speciesAnimalIsCorrect = isZooClubMemberAnimalExist(zooClub, name, age, species, animalName);
			
			if (speciesAnimalIsCorrect) {
				Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();
				while(iterator.hasNext()) {
					Entry<Person, ArrayList<Animal>> nextMember = iterator.next(); 
					if(nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
						ArrayList<Animal> animalList = nextMember.getValue();
						Iterator<Animal> iterator2 = animalList.iterator();
						while (iterator2.hasNext()) {
							Animal next2 = iterator2.next(); 
							if (next2.getSpecies().equalsIgnoreCase(species) && next2.getName().equalsIgnoreCase(animalName)) {
								iterator2.remove();
								System.out.println("Animal " + next2.toString() + " successfully deleted from the member " + nextMember.getKey());
							}
						}
					}
				}
			} else {
				System.out.println("This member of the ZooClub does not have an entered animal");
			}
		} else {
			System.out.println("The entered member is not a member of the ZooClub");
		}
		
		
	}
	
	public void removeZooClubMember() {
		Scanner scanner = new Scanner (System.in); 
		System.out.println("Please, enter the name of the member of the ZooClub: ");
		String name = scanner.next(); 
		System.out.println("Please, enter the age of the ZooClub member:");
		int age = scanner.nextInt();
		
		
		boolean dataIsCorrect = isZooClubMemberExist(zooClub, name, age);
		
		if (dataIsCorrect) {
			Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> nextMember = iterator.next(); 
				if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
					iterator.remove();
					System.out.println(nextMember.getKey().toString() + "successfully deleted from the ZooClub members");
				}
			}
		} else {
			System.out.println("The entered member is not a member of the ZooClub");
		}
	}
	
	public void removeAnimalFromAllMembers() {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter the animal species:  ");
		String species = scanner.next();
		
		Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

			ArrayList<Animal> animalList = nextMember.getValue();

			Iterator<Animal> iterator2 = animalList.iterator();
			
			while (iterator2.hasNext()) {
				Animal next2 = iterator2.next();
				if (next2.getSpecies().equalsIgnoreCase(species)) {
					iterator2.remove();
					System.out.println("Animal "  + next2.toString() + " successfully deleted from the all members" + nextMember.getKey());
				}
			}

		}
	}
	
	public void viewZooClub() {
		Set<Entry<Person, ArrayList<Animal>>> zooClubMembers = zooClub.entrySet();
		System.out.println("The ZooClub consists of: ");
		for (Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
			System.out.println(" The member  " + entry.getKey() + "  has " + entry.getValue());
		}
	}

	private boolean isZooClubMemberAnimalExist(Map<Person, ArrayList<Animal>> zooClub, String name, int age,
			String species, String animalName) {
	boolean flag = false; 
	
	Iterator <Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();
	
	while (iterator.hasNext()) {
		Entry<Person, ArrayList<Animal>> nextMember = iterator.next(); 
		
		if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
			ArrayList<Animal> animalList = nextMember.getValue(); 
			
			Iterator<Animal> iterator2 = animalList.iterator(); 
			while (iterator2.hasNext()) {
				Animal next2 = iterator2.next();
				if (next2.getSpecies().equalsIgnoreCase(species) && next2.getName().equalsIgnoreCase(animalName)) {
					flag = true;
				}
			}
		}
	}
		return flag;
	}

	static boolean isZooClubMemberExist(Map<Person, ArrayList<Animal>> zooClub, String name, int age) {
		boolean flag = false; 
		
		Set<Entry <Person, ArrayList<Animal>>> zooClubMembers = zooClub.entrySet();
		for (Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
			if (entry.getKey().getName().equalsIgnoreCase(name) && entry.getKey().getAge() == age) {
				flag = true;
			}
		}
		return flag;
	}
}
