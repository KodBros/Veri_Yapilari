package bagli_liste;
import java.util.Scanner;
public class Bagli_liste {   
    public static void main(String[] args) {
        ListeIslemleri islem = new ListeIslemleri();  
        Scanner k = new Scanner(System.in);
         System.out.print("Sayı girin : ");
        int sayi = k.nextInt();   
        islem.toBinary(sayi);
        islem.goster();
        
        ListeIslemleri liste1 = new ListeIslemleri();
        System.out.print("Sayı girin : ");
        int sayi1 = k.nextInt();
        liste1.toBinary(sayi1);
        
        ListeIslemleri liste2 = new ListeIslemleri();
        System.out.print("Sayı girin : ");
        int sayi2 = k.nextInt();   
        liste2.toBinary(sayi2); 
        
        islem.topla(liste1,liste2).goster();
        
    }   
} 
