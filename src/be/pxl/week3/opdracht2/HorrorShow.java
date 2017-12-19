package be.pxl.week3.opdracht2;

public class HorrorShow {

	public static void main(String[] args) {
		class Vampire implements Monster {

			@Override
			public void menace() {
				System.out.println("I'll drink your blood!!");
				
			}
			
		}
		
		class Werewolf implements DangerousMonster {

			@Override
			public void menace() {
				System.out.println("I'll destroy you.");
				
			}

			@Override
			public void destroy(Monster monster) {
				monster.menace();
				System.out.println("Big fight...");
				System.out.println(Werewolf.class.getSimpleName() + " killed one " + monster.getClass().getSimpleName());
				
			}
			
		}
		
		Monster monster = new Monster() {

			@Override
			public void menace() {
				System.out.println("You smell like wet dog.");
				
			}
			
			
		};
		
		Monster vampire = new Vampire();
		DangerousMonster werewolf = new Werewolf();
		
		werewolf.menace();
		werewolf.destroy(vampire);
		System.out.println();
		monster.menace();
	}

}
