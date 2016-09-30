public class Biology extends Hero {

    BASE_ATTACK = 5;
    private static final int ARMOR = 5;

    public Biology(String name, int level) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        super(name, level*2 + ARMOR, level*2, level);
    }

    public int attack() {
        return BASE_ATTACK;
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}
