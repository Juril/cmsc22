/**
 * Created by Juril on 11/25/2016.
 */
public class Troll extends Character{
    public Troll(){
        super(new AxeBehavior(), "Troll");
    }

    public Troll(WeaponBehavior weapon){
        super(weapon, "Troll");
    }

    public void fight(){
        super.fight();
    }

    public String toString(){
        return super.toString();
    }
}
