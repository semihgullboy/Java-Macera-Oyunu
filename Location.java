public abstract class Location {
    private Player player;
    private String name;

    Location(Player player, String name){
        this.player=player;
        this.name =name;
    }
    
    public abstract boolean onLocation();

    public Player getplayer(){
        return player;
    }

    public void setplayer(Player player){
        this.player = player;
    }

    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name = name;
    }
    
}
