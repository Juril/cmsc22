public abstract class RPGCharacter {

    private String name;
    private int hp;
    private int mp;

    public RPGCharacter(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    public abstract int attack(int choice);

    public boolean isAlive() {
        return hp > 0 ? true : false;
    }

    public int takeDamage(int damage) {
        hp -= damage;
        return hp;
    }

    public void useSkill(){
        mp -= 20;
    }

    // getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp){
        this.mp = mp;
    }

    public int getMp(){
        return mp;
    }

    @Override
    public String toString() {
        return "RPGCharacter{" +
                "name='" + name + '\'' +
                ", hp=" + hp + ", mp=" +
                mp + '}';
    }
}
