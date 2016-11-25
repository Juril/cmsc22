/**
 * Created by Juril on 11/25/2016.
 */
public class CharacterTest {
    public static void main(String[] args) {
        Character k = new King();
        k.fight();
        Character q = new Queen();
        q.fight();
        Character kn = new Knight();
        kn.fight();
        Character t = new Troll();
        t.fight();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Character kk = new King(new BowAndArrowBehavior());
        kk.fight();
        Character qq = new Queen(new AxeBehavior());
        qq.fight();
        Character knn = new Knight(new KnifeBehavior());
        knn.fight();
        Character tt = new Troll(new SwordBehavior());
        tt.fight();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}

