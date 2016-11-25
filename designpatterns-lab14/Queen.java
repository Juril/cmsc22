/**
 * Created by Juril on 11/25/2016.
 */
public class Queen extends Character{
    public Queen(){
        super(new BowAndArrowBehavior(), "Queen");
    }

    public Queen(WeaponBehavior weapon){
        super(weapon, "Queen");
    }

    public void fight(){
        super.fight();
    }

    public String toString(){
        return super.toString();
    }


}
