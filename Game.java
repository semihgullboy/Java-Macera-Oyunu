import java.util.Scanner;

public  class Game{
    Scanner input =new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz.");
        System.out.println("Lütfen bir isim giriniz:");
        String playerName = input.next();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getname()+ " oyunumuza hoşgeldiniz.");
        System.out.println("Lütfen bir karakter seçiniz.");
        System.out.println(" ");
        player.selectChar();
        Location location = null;
        while(true){
            player.printinfo();
            System.out.println(" ");
            System.out.println("------------------ Bölgeler -------------------");
            System.out.println("1 - Güvenli Ev --> Bu bölge canınızın yenilemesini sağlar !");
            System.out.println("2 - Dükkan --> Bu bölgeden alışveriş yapabilirsiniz !");
            System.out.println("3 - Mağara --> Bu bölgede canavarlar çıkabilir !! Kazanırsanız ödülünüz : Food  + 4 Para");
            System.out.println("4 - Orman --> Bu bölgede canavarlar çıkabilir !! Kazanırsanız ödülünüz : Firewood + 7 Para");
            System.out.println("5 - Nehir --> Bu bölgede canavarlar çıkabilir !! Kazanırsanız ödülünüz : Water + 12 Para");
            System.out.println("0 - Çıkış Yap--> Bu işlemi seçerseniz oyun sonlanır  !");
            System.out.println(" ");
            System.out.println("Lütfen gitmek istediğiniz bölgenin numarasını seçiniz:");
            int selectLocation =input.nextInt();
            switch(selectLocation){
                case 0 :
                 location = null ;
                 break;
                case 1 : 
                    location = new SafeHouse(player);
                    break;
                case 2 :   
                    location= new ToolStore(player);
                    break;
                case 3 : 
                    if(player.getInventory().getFood()) {
                        System.out.println("Sen zaten mağaradaki ödülü kazandın !!");
                        location = new SafeHouse(player);
                    }else {
                        location = new Cave(player);
                    }
                    break;
                case 4 : 
                   if(player.getInventory().getFirewood()) {
                        System.out.println("Sen zaten ormandaki ödülü kazandın !!");
                        location = new SafeHouse(player);
                    }else {
                        location = new Forest(player);
                    }
                    break;
                case 5 : 
                    if(player.getInventory().getWater()) {
                        System.out.println("Sen zaten nehirdeki ödülü kazandın !!");
                        location = new SafeHouse(player);
                    }else {
                        location = new River(player);
                    }
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if ( location == null){
                System.out.println(" Tekrar oynamanız dileğiyle ... ");
                break;
            }

            if(location.getname() == "Safe House") {
                if(player.getInventory().getWater() && player.getInventory().getFood() && player.getInventory().getFirewood()) {
                    System.out.println("YOU WON THE GAME!");
                    break;
                }
            }

           if(!location.onLocation())
           {
            System.out.println("GAME OVER !");
            break;
           }
        }
    }
}