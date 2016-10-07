import java.util.*;
import java.io.*;

public class RPG {

    private static Random rand = new Random();

    public RPG() {
        this.rand = new Random();
    }

    public static int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

public boolean duel(RPGCharacter attacker, RPGCharacter defender, int choice) {
        int damage = attacker.attack(choice);
        if(choice == 1){
            System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        }
        if(choice == 2){
            if(attacker.getMp() >= 20){
                System.out.println("--> " + attacker.getName() + " uses skill against " + defender.getName());
                attacker.useSkill();
            }
            else{
                System.out.println("Not enough mana oy!!");
                return false;
            }
        }
        sleep(2000);
        defender.takeDamage(damage);
        System.out.printf("-->Damage dealt: %s\n", damage);

        if (!(defender.isAlive())) {
            System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
            return true;
        }
        return false;
    }

    public static void clearScreen()throws IOException, InterruptedException {  
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
    }

    public static void main(String[] args) throws IOException, InterruptedException  {
        clearScreen();
        Scanner in = new Scanner(System.in);
        RPG rpg = new RPG();
        RPGCharacter hero, monster;
        int level = randInt(30, 100);
        System.out.println("Choose your program!\n");
        System.out.println("1. Computer Science\n2.Math\n3.Biology");
        int choice = in.nextInt();
        clearScreen();
        System.out.println("READY");
        sleep(1000);
        System.out.println("SET");
        sleep(1000);
        System.out.println("GO!");
        sleep(1000);
        clearScreen();
        System.out.println("====== GAME START =====");
        System.out.println("Who will attack first? Player, type 1 for heads and 2 tails!");
        int input = in.nextInt();
        int firstAttack = randInt(1, 2);
        boolean first;
        int monsterChoice = randInt(1, 3);
        if(monsterChoice == 1){
            monster = new Marga((rpg.randInt(level-3, level+3))*2, (rpg.randInt(level-3, level+3))*2);
        }else if(monsterChoice == 2){
            monster = new Professor((rpg.randInt(level-3, level+3))*2, (rpg.randInt(level-3, level+3))*2);
        }else{
            monster = new Guard((rpg.randInt(level-3, level+3))*2, (rpg.randInt(level-3, level+3))*2);
        }

        if(input == firstAttack){
            System.out.println("You will attack first!");
            first = true;
        }
        else{
            System.out.println("Your enemy will attack first!");
            first = false;
        }      
        if(choice == 1){            
            hero = new ComputerScience("Mr. Hacker", level, level*2);
            System.out.printf("%s\n%s\n", hero, monster);
            int count = 0;
            int turn = 0;
            while (turn < 2) {
                System.out.println("== round " + ++count);
                if(first){                    
                    System.out.println("1. Attack \t2. Use Spell");
                    choice = in.nextInt();
                
                    boolean heroVsMonster = rpg.duel(hero, monster, choice);
                    if (heroVsMonster) break;               
                    first = false;
                    turn++;
                }
                if(!(first)){
                    choice = randInt(1, 2);
                    boolean monsterVsHero = rpg.duel(monster, hero, choice);
                    if (monsterVsHero) break;
                    first = true;
                    turn++;
                }
                System.out.printf("%s\n%s\n", hero, monster);
                sleep(3000);
                clearScreen();
                turn = 0;
            }
            System.out.printf("%s\n%s\n", hero, monster);
        }
        else if(choice == 2){            
            hero = new Math("Math Wiz", level, level*2);
            System.out.printf("%s\n%s\n", hero, monster);
            int count = 0;
            while (true) {
                System.out.println("== round " + ++count);
                if(first){                    
                    System.out.println("1. Attack \t2. Use Spell");
                    choice = in.nextInt();
                
                    boolean heroVsMonster = rpg.duel(hero, monster, choice);
                    if (heroVsMonster) break;               
                    first = false;
                }
                if(!(first)){
                    choice = randInt(1, 2);
                    boolean monsterVsHero = rpg.duel(monster, hero, choice);
                    if (monsterVsHero) break;
                    first = true;
                }
                System.out.printf("%s\n%s\n", hero, monster);
                sleep(3000);
                clearScreen();
            }
            System.out.printf("%s\n%s\n", hero, monster);
        }
        else if(choice == 3){            
            hero = new Biology("Kitten_Killah143", level, level*2);
            System.out.printf("%s\n%s\n", hero, monster);
            int count = 0;
            while (true) {
                System.out.println("== round " + ++count);
                if(first){                    
                    System.out.println("1. Attack \t2. Use Spell");
                    choice = in.nextInt();
                
                    boolean heroVsMonster = rpg.duel(hero, monster, choice);
                    if (heroVsMonster) break;               
                    first = false;
                }
                if(!(first)){
                    choice = randInt(1, 2);
                    boolean monsterVsHero = rpg.duel(monster, hero, choice);
                    if (monsterVsHero) break;
                    first = true;
                }
                System.out.printf("%s\n%s\n", hero, monster);
                sleep(3000);
                clearScreen();
            }
            System.out.printf("%s\n%s\n", hero, monster);
        }                
    }
}
