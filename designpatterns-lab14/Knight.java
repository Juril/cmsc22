/**
 * Created by Juril on 11/25/2016.
 */
public class Knight extends Character{
    public Knight(){
        super(new SwordBehavior(), "Knight");
    }

    public Knight(WeaponBehavior weapon){
        super(weapon, "Knight");
    }

    public void fight(){
        super.fight();
    }

    public String toString(){
        return super.toString();
    }
}
