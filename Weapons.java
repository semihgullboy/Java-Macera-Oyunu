

public class Weapons {
    private int id , damage , price ;
    private String name;

    public Weapons(int id,String name, int damage, int price) {
        this.id= id;
        this.name =name;
        this.damage = damage;
        this.price= price;
    }

    public static Weapons[] weapons(){
        Weapons[] weaponslist = new Weapons[3];
        weaponslist[0] = new Weapons(1, "Tabanca", 2, 15 );
        weaponslist[1] = new Weapons(2, "Kılıç", 3, 25 );
        weaponslist[2] = new Weapons(3, "Tüfek", 7, 35 );
        return weaponslist;
    }

    public static Weapons getWeaponObjByID(int id){
        for (Weapons w : Weapons.weapons()) {
            if(w.getid() == id){
                return w ;
            }
        }
        return null ;
    }

    public int getid(){
        return id;
    }
    
    public void setid(int id){
        this.id = id;
    }
    public int getdamage(){
        return damage;
    }

    public void setdamage(int damage){
        this.damage = damage;
    }
    public int getprice(){
        return price;
    }

    public void setprice(int price){
        this.price = price;
    }
    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name = name;
}
}
