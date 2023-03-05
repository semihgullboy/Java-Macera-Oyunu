import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);
    private int damage , health , money,OrjinalHealth;
    private String name , charName;
    private Inventory inventory;

    public Player (String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
      
       GameChar[] charList ={new Samurai(),new Archer(),new Knight() };
       System.out.println("Karakterler");
       System.out.println("-----------------------------");
       for (GameChar gameChar : charList) {
        System.out.println("İd:"+ gameChar.getid() +
            "   Karakter: "+ gameChar.getname() + 
        "   Hasar: " + gameChar.getdamage()+
        "    Sağlık: "+ gameChar.gethealth() +
        "  Money: "+gameChar.getmoney());
       }
       System.out.println("-----------------------------");
       System.out.println("Lütfen seçmek istediğiniz karakterin idsini giriniz !");
       int selectChar = input.nextInt();
       switch(selectChar){
        case 1:
            initplayer(new Samurai());
            break;
        case 2:
            initplayer(new Archer());
            break;
        case 3:
            initplayer(new Knight());
            break;
        default:
           initplayer(new Samurai());
       }
       System.out.print( "Seçtiğiniz Karakter : "+ this.getcharName());
    }   

    public void printinfo(){
        System.out.println(
            "  ||  Silahınız : " + this.getInventory().getWeapons().getname() +
            " ||  Zırhınız : " + this.getInventory().getArmor().getname() + 
            " ||  Bloklama: " + this.getInventory().getArmor().getarmor() + 
            " ||  Hasarınız : " + this.getTotalDamage() +
            " ||  Sağlık : " + this.gethealth() +
            " || Para : " + this.getmoney());
    }

    public void initplayer(GameChar gameChar){
        this.setcharName(gameChar.getname());
        this.setdamage(gameChar.getdamage());
        this.sethealth(gameChar.gethealth());
        this.setOrjinalHealth(gethealth());
        this.setmoney(gameChar.getmoney());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapons().getdamage();
    }

    public int getdamage(){
        return damage;
    }

    public void setdamage(int damage){
        this.damage = damage;
    }

    public int gethealth(){
        return health ;
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
    public String getcharName(){
        return charName;
    }

    public void setcharName(String charName){
        this.charName = charName;
    }
    public Inventory getInventory(){
        return inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return OrjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        OrjinalHealth = orjinalHealth;
    }

}
