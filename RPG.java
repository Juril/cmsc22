import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by nmenego on 9/29/16.
 */
public class RPG {

    private Random rand = new Random();

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Green", "Slimy", "Bloody", "Smelly"};
        String[] monsters = {"Ogre", "Elf", "Giant", "Teacher"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss
    public boolean coinToss() {
        return randInt(0, 1) == 1 ? true : false;
    }

    // pause the game for awhile for dramatic effect!
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // duel two characters, one as attacker, one as defender
    // returns true if someone is killed
    public boolean duel(RPGCharacter attacker, RPGCharacter defender) {
        int damage = attacker.attack();
        System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        sleep(2000);

        if (coinToss()) {
            int remHp = defender.takeDamage(damage);
            if (remHp <= 0) {
                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
                return true;
            }
        } else {
            System.out.println("--> MISSED!");
        }
        return false;
    }

    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }

    public enum monsterNames{
        GUARD,
        PROFESSOR,
        MARGA
   }


    // game...
    public static void main(String[] args) {
        clearScreen();
        Scanner in = new Scanner(System.in);
        RPG rpg = new RPG();
        int level = randInt(30, 100);
        monsterNames monster = randInt(1, 3);
        System.out.println("Choose your program!\n");
        System.out.println("1. Computer Science\n2.Math\n3.Biology");
        int choice = in.nextInt;
        clearScreen();
        RPGCharacter hero, monster;
        System.out.println("====== GAME START =====");
        if(choice == 1)

        hero = new ComputerScience("Computer Science Student", level, );
        monster = new Villain(monster, (rpg.randInt(level-3, level+3))*2, rpg.randInt(1, 100));
        System.out.printf("%s\n%s\n", hero, monster);

        // fight! for version 1, hero will always attack first.
        int count = 0;
        while (true) {
            System.out.println("== round " + ++count);
            // hero's turn
            
            System.out.println("1. Attack \t2. Spell");
            choice = in.nextInt();
            if(choice == 1){
                boolean heroVsMonster = rpg.duel(hero, monster);
                    if (heroVsMonster) break;               
                }
            else
            if(choice == 2){

            }


            // monster's turn
            boolean monsterVsHero = rpg.duel(monster, hero);
            if (monsterVsHero) break;

            System.out.printf("%s\n%s\n", hero, monster);
        }

        System.out.printf("%s\n%s\n", hero, monster);
    }
}
