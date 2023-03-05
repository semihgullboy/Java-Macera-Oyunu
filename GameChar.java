public abstract class GameChar {
    private int id, damage , health , money;
    private String name;

    public GameChar(int id,String name, int damage, int health, int money) {
        this.id= id;
        this.name =name;
        this.damage = damage;
        this.health = health;
        this.money= money;
    }

    public int getdamage(){
        return damage;
    }

    public void setdamage(int damage){
        this.damage = damage;
    }

    public int gethealth(){
        return health;
    }

    public void sethealth(int health){
        this.health = health;
    }
    public int getmoney(){
        return money;
    }

    public void setmoney(int money){
        this.money = money;
    }

    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name = name;
}
    public int getid(){
    return id;
}

    public void setid(int id){
    this.id = id;
}
}
