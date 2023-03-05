import java.util.Scanner;

public class ToolStore extends Location {
    Scanner input =new  Scanner(System.in);
    
    ToolStore(Player player){
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation(){
        boolean menu= true;
        System.out.println("Mağazaya Hoşgeldiniz !");
        while(menu){
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış Yap");
        System.out.println("Seçiminiz : ");
        int selectStore = input.nextInt();
        while(selectStore < 1 || selectStore >3){
            System.out.println("Geçersiz bir değer girdiniz !!");
            System.out.println("Tekrardan Giriniz : ");
            selectStore = input.nextInt();
        }
        switch(selectStore){
            case 1 :
                printWeapon();
                buyWeapon();
                break;
            case 2 :
                printArmor();
                buyArmor();
                break;
            case 3 :
            System.out.println("Bir daha bekleriz !!");
                menu = false;
                break;
        }
    }
    return true;
}

    public void printWeapon(){
        System.out.println("---------- Silahlar ----------");
        System.out.println(" ");
        for (Weapons w : Weapons.weapons()) {
            System.out.println(w.getid() +"    "+ w.getname() + "  Hasar : " + w.getdamage()+"   Money : " + w.getprice());
        }
        System.out.println("0 -     Geri dönmek için seçiniz  !");
    }
        
        public void buyWeapon() {
            System.out.println(" ");
        System.out.print("Almak istediğiniz silahı seçiniz : ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID < 0 || selectWeaponID > Weapons.weapons().length){
            System.out.println("Geçersiz bir değer girdiniz !!");
            System.out.println("Tekrardan Giriniz : ");
            selectWeaponID = input.nextInt();
        }
        if(selectWeaponID != 0){
        Weapons selectedWeapon = Weapons.getWeaponObjByID(selectWeaponID);
        if(selectedWeapon != null){
            if(selectedWeapon.getprice() > this.getplayer().getmoney()){
                System.out.println("Yeterli paranız bulunmamaktadır !");
            }else {
                System.out.println(selectedWeapon.getname() + " silahını satın aldınız ! ");
                int balance = this.getplayer().getmoney() - selectedWeapon.getprice();
                this.getplayer().setmoney(balance);
                System.out.println("Kalan paranız : " + this.getplayer().getmoney());
                this.getplayer().getInventory().setWeapons(selectedWeapon);
                System.out.println("Yeni Silahınız : " + this.getplayer().getInventory().getWeapons().getname());
                }
        }
    }
    }

        public void printArmor(){
            System.out.println("---------- Zırhlar ----------");
            System.out.println(" ");
            for ( Armors a : Armors.armor()) {
            System.out.println(a.getid() +"    "+ a.getname() + "  Engelleme : " + a.getarmor()+"   Money : " + a.getprice());
        }
        System.out.println("0 -     Geri dönmek için seçiniz  !");
    }

        public void buyArmor() {
            System.out.println(" ");
            System.out.print("Almak istediğiniz zırhı seçiniz : ");
            int selectArmorID = input.nextInt();
            while(selectArmorID < 0 || selectArmorID > Armors.armor().length){
            System.out.println("Geçersiz bir değer girdiniz !!");
            System.out.println("Tekrardan Giriniz : ");
            selectArmorID = input.nextInt();
        }
        if(selectArmorID != 0){
            Armors selectedArmor = Armors.getArmorsObjByID(selectArmorID);
        if(selectedArmor != null){
            if(selectedArmor.getprice() > this.getplayer().getmoney()){
            System.out.println("Yeterli paranız bulunmamaktadır !");
            }else {
                System.out.println(selectedArmor.getname() + " zırhını satın aldınız ! ");
                int balance = this.getplayer().getmoney() - selectedArmor.getprice();
                this.getplayer().setmoney(balance);
                System.out.println("Kalan paranız : " + this.getplayer().getmoney());
                this.getplayer().getInventory().setArmor(selectedArmor);
                System.out.println("Yeni Zırhınız : " + this.getplayer().getInventory().getArmor().getname());
        }
    }
}
}

}
