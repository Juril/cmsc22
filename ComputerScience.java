public class ComputerScience extends Hero {

    BASE_ATTACK = 10;
    private int plusDamage;

    public ComputerScience(String name, int level) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        super(name, level*2, level*2, level);
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
