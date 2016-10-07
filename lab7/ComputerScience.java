public class ComputerScience extends Hero {

    private static final int BASE_ATTACK = 10;
    private int plusDamage = BASE_ATTACK/3;

    public ComputerScience(String name, int level, int mp) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        super(name, level*2, mp, level);
    }

    public int attack(int choice) {
        if(choice == 1){   
            return BASE_ATTACK;
        }
        else{
            return BASE_ATTACK + plusDamage;
        }
    }

    public int takeDamage(int damage) {
        return super.takeDamage(damage);
    }
}
