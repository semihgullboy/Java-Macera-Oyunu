public class Obstacle {
    private int id , damage , health, award ,orjinalHealth;

    private String name;
    
    public Obstacle(int id ,String name,  int damage , int health,int award){
        this.id=id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.orjinalHealth = health;
        this.award = award;
    }    
    
    public int getid(){
        return id;
    }
    
    public void setid(int id){
        this.id = id;
    }
    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name = name;
    }

    public int getdamage(){
        return damage ;
    }

    public void setdamage(int damage){
        this.damage = damage;
    }

    public int gethealth(){
        return health ;
    }

    public void sethealth(int health){
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getaward(){
        return award ;
    }

    public void setaward(int award){
        this.award = award;
    }
    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
