public class Biology extends Hero {

    private static final int BASE_ATTACK = 5;
    private static final int ARMOR = 5;

    public Biology(String name, int level, int mp) {
        super(name, level*2 + ARMOR, mp, level);
    }

    public int attack(int choice) {
        if(choice == 1){
            return BASE_ATTACK;
        }
        else{
            System.out.println("HEAL!!!");
            takeDamage(-15);
            return 0;
        }
    }

    public int takeDamage(int damage) {
        damage -= ARMOR;
        return super.takeDamage(damage);
    }
}
