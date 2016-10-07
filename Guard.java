public class Guard extends Villain{

    private final static int BASE_ATTACK = 8;
    private final static int SHIELD = 3;

    public Guard(int hp, int mp) {
        super("Guard", hp, mp);
    }

    public int attack(int choice) {
    	if(choice == 1){
        	return BASE_ATTACK;
        } else {
            System.out.println("LIGHTNING PADDLEEEE!!!!");
            return BASE_ATTACK + (BASE_ATTACK / 3);
        }
    }

    public int takeDamage(int damage) {
    	damage -= SHIELD;
    	return super.takeDamage(damage);
    }

}