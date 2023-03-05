public class Armors {

    private int id , armor , price ;
    private String name;

    public Armors(int id,String name, int armor, int price) {
        this.id= id;
        this.name =name;
        this.armor = armor;
        this.price= price;
    }

    public static Armors[] armor(){
        Armors[] armorlist = new Armors[3];
        armorlist[0] = new Armors(1, "Hafif", 1, 15 );
        armorlist[1] = new Armors(2, "Orta", 3 , 25 );
        armorlist[2] = new Armors(3, "Ağır", 5 , 35 );
        return armorlist;
    }

    public static Armors getArmorsObjByID(int id){
        for (Armors a : Armors.armor()) {
            if(a.getid() == id){
                return a ;
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
    public int getarmor(){
        return armor;
    }

    public void setarmor(int armor){
        this.armor = armor;
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
