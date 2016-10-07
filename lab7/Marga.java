public class Marga extends Villain{

    private final static int BASE_ATTACK = 13;

    public Marga(int hp, int mp) {
        super("Marga", hp, mp);
    }

    public int attack(int choice) {
        if(choice == 1){
            return BASE_ATTACK;
        } else {
            System.out.println("BAYT");
            return BASE_ATTACK + (BASE_ATTACK / 2);
        }
    }
}
