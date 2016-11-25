/**
 * Created by Juril on 11/25/2016.
 */
public abstract class Character{
    private WeaponBehavior weapon;
    private String name;

    public Character(){
        this.name = "";
    }

    public Character(WeaponBehavior weapon, String name){
        setWeapon(weapon);
        this.name = name;
    }

    public void setWeapon(WeaponBehavior weapon){
        this.weapon = weapon;
    }

    public void fight(){
        weapon.useWeapon();
    }
}