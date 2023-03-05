public class SafeHouse extends NormalLoc {

    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    
    @Override
    public boolean onLocation(){
        System.out.println("Güvenli evdesiniz !");
        this.getplayer().sethealth(this.getplayer().getOrjinalHealth());
        System.out.println("Canınız yenilendi !");
        return true;
    }
}
