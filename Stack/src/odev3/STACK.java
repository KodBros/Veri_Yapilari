package odev3;

class Dugum {

    int ifade;
    Dugum asagi;

    public Dugum(int ifade) {
        this.ifade = ifade;
        this.asagi = null;
    }

}

public class STACK {

    int elemansayisi = 0;
    Dugum ust; // bas 

    public STACK() {
        this.ust = null;
    }

    void ekleme(Dugum d) {
        if (bosmu()) {
            ust = d;
        } else {
            d.asagi = ust;
            ust = d;
        }
        elemansayisi++;
    }

    int silme() {
        if (bosmu()) {
            System.out.println("Stack Boş");
            return 0;
        } else {
            Dugum tmp = ust;
            ust = ust.asagi;
            elemansayisi--;
            return tmp.ifade;
        }

    }

    boolean bosmu() {
        return elemansayisi == 0;
    }

    Dugum tepe() {
        return ust;
    }

    void goster() {
        if (bosmu()) {
            System.out.println("Stack boş");
        } else {
            Dugum d = ust;
            for (int i = 0; i < elemansayisi; i++) {
                System.out.println(d.ifade);
                d = d.asagi;
            }
        }
    }

    void quiz(String ifade) {
        char a[] = new char[ifade.length()];
        for (int i = a.length-1; i >= 0; i--) {
            a[i] = ifade.charAt(i);
            if (a[i] == '0' || a[i] == '1' || a[i] == '2' || a[i] == '3' || a[i] == '4' || a[i] == '5' || a[i] == '6' || a[i] == '7' || a[i] == '8' || a[i] == '9') {
                String tmp = String.valueOf(a[i]);
                int sayi = Integer.parseInt(tmp);
                Dugum d = new Dugum(sayi);
                ekleme(d);
            } 
            else if (a[i] == '+') {
                if (elemansayisi >= 2) {
                    int sayi1 = silme();
                    int sayi2 = silme();
                    int toplam = sayi1 + sayi2;
                    Dugum d = new Dugum(toplam);
                    ekleme(d);
                } 
            }
            else if (a[i] == '-') {
                if (elemansayisi >= 2) {
                    int sayi1 = silme();
                    int sayi2 = silme();
                    int toplam = sayi1 - sayi2;
                    Dugum d = new Dugum(toplam);
                    ekleme(d);
                } 
            }
            else if (a[i] == '*') {
                if (elemansayisi >= 2) {
                    int sayi1 = silme();
                    int sayi2 = silme();
                    int toplam = sayi1 * sayi2;
                    Dugum d = new Dugum(toplam);
                    ekleme(d);
                } 
            }
            else if (a[i] == '/') {
                if (elemansayisi >= 2) {
                    int sayi1 = silme();
                    int sayi2 = silme();
                    int toplam = sayi1 / sayi2;
                    Dugum d = new Dugum(toplam);
                    ekleme(d);
                } 
            }
        }
        goster();
    }

    void kontrol(String ifade) {
        switch (ifade) {
            case "!":
                System.exit(0);
            case "^":
                silme();
                break;
            case "?":
                goster();
                break;
            case "+":
                if (elemansayisi >= 2) {
                    int sayi1 = silme();
                    int sayi2 = silme();
                    int toplam = sayi1 + sayi2;
                    Dugum d = new Dugum(toplam);
                    ekleme(d);
                } else {
                    System.out.println("Yeterli eleman yok.");
                }

                break;
            case "-":
                if (elemansayisi >= 2) {
                    int sayi1 = silme();
                    int sayi2 = silme();
                    int sonuc = sayi1 - sayi2;
                    Dugum d = new Dugum(sonuc);
                    ekleme(d);
                } else {
                    System.out.println("Yeterli eleman yok.");
                }
                break;
            case "/":
                if (elemansayisi >= 2) {
                    int sayi1 = silme();
                    int sayi2 = silme();
                    int sonuc = sayi1 / sayi2;
                    Dugum d = new Dugum(sonuc);
                    ekleme(d);
                } else {
                    System.out.println("Yeterli eleman yok.");
                }
                break;
            case "*":
                if (elemansayisi >= 2) {
                    int sayi1 = silme();
                    int sayi2 = silme();
                    int sonuc = sayi1 * sayi2;
                    Dugum d = new Dugum(sonuc);
                    ekleme(d);
                } else {
                    System.out.println("Yeterli eleman yok.");
                }
                break;
            default:
                try {
                    int gelenSayi = Integer.parseInt(ifade);
                    Dugum d = new Dugum(gelenSayi);
                    ekleme(d);
                } catch (Exception e) {
                    System.out.println("Geçerli ifade girin");
                }
                break;
        }
    }
}
