public class Professor extends Villain{

    private final static int BASE_ATTACK = 5;

    public Professor(int hp, int mp) {
        super("Professor", hp, mp);
    }

    public int attack(int choice) {
        if(choice == 1) {
            return BASE_ATTACK;
        } else {
                return BASE_ATTACK*3;
        }
    }

}