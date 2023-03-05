import java.util.Random;
import java.util.Scanner;

public class BattleLoc extends Location{
    Scanner input =new Scanner(System.in);

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation(){
        System.out.println(" ");
        int randomObstacleNumber = randomObstacleNumber();
        System.out.println("Şuan buradasınız : "+ this.getname());
        System.out.println("Dikkatli ol ! Burada " + randomObstacleNumber + " adet " +  this.getObstacle().getname() +" yaşıyor ! ");
        System.out.println(this.getObstacle().getname() +" Hasarı : " + this.getObstacle().getdamage());
        System.out.println( this.getObstacle().getname() +" Sağlığı : " + this.getObstacle().gethealth());
        System.out.println("<S>avaş veya <K>aç");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S")){
            if(combat(randomObstacleNumber)){
                System.out.println(this.getObstacle().getname() + " tüm düşmanları öldürdünüz !");
                return true;
            }
            if(this.getplayer().gethealth() <= 0){
                System.out.println("Öldünüz");
                return false;
            }
        }
        return true;
    }
    
    public boolean combat(int obsNumber){
        for(int i=1; i <= obsNumber ; i++){
            this.getObstacle().sethealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            System.out.println("----------------------");
            obstacleStats();
            while(this.getplayer().gethealth() > 0 && this.getObstacle().gethealth() >0){
                System.out.println("<V>ur veya <K>");
                String select = input.nextLine().toUpperCase();
                if(select.equals("V")){
                    int firstHint = firstHint();
                    if(firstHint == 1){
                        System.out.println("İlk siz vuruyorsunuz !!");
                    System.out.println("Siz vurdunuz !");
                    this.obstacle.sethealth(this.obstacle.gethealth() - this.getplayer().getTotalDamage());
                    afterHit();
                    if(this.obstacle.gethealth() > 0){
                        System.out.println(this.getObstacle().getname() +" size vurdu !!");
                        int obstacleDamage =  this.getObstacle().getdamage() - this.getplayer().getInventory().getArmor().getarmor();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getplayer().sethealth(this.getplayer().gethealth() - obstacleDamage);
                        afterHit();
                    }
                }else{
                    System.out.println("İlk "+ this.getObstacle().getname()+ " vuruyor !!");
                    System.out.println();
                    System.out.println(this.getObstacle().getname() +" size vurdu !!");
                    int obstacleDamage =  this.getObstacle().getdamage() - this.getplayer().getInventory().getArmor().getarmor();
                    if(obstacleDamage < 0){
                        obstacleDamage = 0;
                    }
                    this.getplayer().sethealth(this.getplayer().gethealth() - obstacleDamage);
                    afterHit();
                    if(this.getplayer().gethealth() > 0){
                        System.out.println("Siz vurdunuz !");
                        this.obstacle.sethealth(this.obstacle.gethealth() - this.getplayer().getTotalDamage());
                        afterHit();
                    }
                }
                }else{
                    return false;
                }
            }
            System.out.println(this.getObstacle().getname() + " öldü ");
            System.out.println("Kalan " + this.getObstacle().getname() + " sayısı : " + (obsNumber - i));
        }
        System.out.println();
        System.out.println("Tebrikler !! Bütün " + this.getObstacle().getname() + " öldürdünüz !!");
        System.out.println("Kazanılan para : " + this.getObstacle().getaward());
        this.getplayer().setmoney(this.getplayer().getmoney() + this.getObstacle().getaward());
        System.out.println("Kazanılan ödül " + this.getAward());
        this.getplayer().getInventory().winAward(this.getAward());
        System.out.println();
        return false;
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getplayer().gethealth());
        System.out.println(this.obstacle.getname() + " Canı : " + this.getObstacle().gethealth());
        System.out.println();
    }

    public void playerStats(){
        System.out.println();
        System.out.println("Oyuncu Değerleri");
        System.out.println("----------------------");
        System.out.println("Sağlık : " + this.getplayer().gethealth() +
        "   Hasar : " + this.getplayer().getTotalDamage() +
        "   Silah : " + this.getplayer().getInventory().getWeapons().getname() +
        "   Zırh : " + this.getplayer().getInventory().getArmor().getname() + 
        " Bloklama : " + this.getplayer().getInventory().getArmor().getarmor());
    }

    public void obstacleStats(){
        System.out.println(this.getObstacle().getname()+" Değerleri");
        System.out.println("----------------------");
        System.out.println("Sağlık : " + this.getObstacle().gethealth() +
        "   Hasar : " + this.getObstacle().getdamage()+
        "   Ödülü : " + this.getObstacle().getaward());
        System.out.println();
    }

    public int randomObstacleNumber(){
        Random r =new Random();
        return r.nextInt(this.getmaxObstacle()) + 1;
    }

    public int firstHint(){
        Random r =new Random();
        return r.nextInt(2);
    }


    public Obstacle getObstacle(){
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle){
        this.obstacle = obstacle;
    }

    public String getAward(){
        return award;
    }

    public void setAward(String award){
        this.award = award;
    }

    public int getmaxObstacle(){
        return maxObstacle ;
    }

    public void setmaxObstacle(int maxObstacle){
        this.maxObstacle = maxObstacle;
    }
    
}
