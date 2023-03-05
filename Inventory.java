

public class Inventory {
    private Weapons weapons;
    private Armors armor;
    private boolean water;
    private boolean food;
    private boolean firewood;

    public Inventory(){
       this.weapons = new Weapons(0,"Yumruk", 0, 0);
       this.armor = new Armors(0,"Basit Zırh", 0, 0);
    }

    public void winAward(String award) {
        switch(award){
            case "food":
                this.setFood(true);
                break;
            case "water":
                this.setWater(true);
                break;
            case "firewood":
                this.setFirewood(true);
                break;
        }
    }

    public Weapons getWeapons(){
        return weapons;
    }
    public void setWeapons(Weapons weapons){
        this.weapons=weapons;
    }
    public Armors getArmor(){
        return armor;
    }

    public void setArmor(Armors armor){
        this.armor = armor;
    }

    public boolean getWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean getFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean getFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
}
