public class Math extends Hero {

    private static final int BASE_ATTACK = 7;

    public Math(String name, int level, int mp) {
        super(name, level*2, mp, level);
    }

    public int attack(int choice) {
        if(choice == 1){
            return BASE_ATTACK;
        }
        else{
            return BASE_ATTACK*BASE_ATTACK;
        }
    }

    public int takeDamage(int damage) {
        return super.takeDamage(damage);
    }
}
