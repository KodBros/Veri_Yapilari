package bagli_liste;

public class ListeIslemleri {

    Dugum bas, son;

    public ListeIslemleri() {
        bas = null;
        son = null;
    }

    public boolean bosMu() {
        if (bas == null) {
            return true;
        } else {
            return false;
        }
    }

    public void basaEkle(int sayi) {
        Dugum dugum = new Dugum(sayi);
        if (bosMu()) {
            bas = dugum;
            son = dugum;
        } else {
            dugum.ileri = bas;
            bas = dugum;
        }
    }

    public int elemanSayisi() {
        Dugum x = bas;
        int sayac = 0;
        while (x != null) {
            sayac++;
            x = x.ileri;
        }
        return sayac;
    }

    public void arayaEkle(int indis, int sayi) {
        //gelen indis değerinin ilerisine ekleme yapar.
        Dugum dugum = new Dugum(sayi);
        int sayac = 1;
        Dugum x = bas;
        if (indis > elemanSayisi()) {
            sonaEkle(sayi);
        }
        while (x != null) {
            if (sayac == indis && indis < elemanSayisi()) {
                dugum.ileri = x.ileri;
                x.ileri = dugum;
            }
            x = x.ileri;
            sayac++;
        }

    }

    public void sonaEkle(int sayi) {
        Dugum dugum = new Dugum(sayi);
        if (bosMu()) {
            bas = dugum;
            son = dugum;
        } else {
            son.ileri = dugum;
            son = dugum;
        }
    }

    public void bastanSil() {
        if (bosMu()) {
            System.out.println("Liste Zaten Boş");
        } else {
            if (bas == son) {
                bas = null;
                son = null;
            } else {
                Dugum tmp = bas.ileri;
                bas.ileri = null;
                bas = tmp;
            }
        }
    }

    public void aradanSil(int indis) {
        //gelen indis değerini siler.
        if (bosMu()) {
            System.out.println("Liste Boş");
        } else {
            if (indis < elemanSayisi() && indis > 1) {
                int sayac = 1;
                Dugum soldakiDugum = bas;
                while (sayac < indis - 1) {
                    soldakiDugum = soldakiDugum.ileri;
                    sayac++;
                }
                Dugum tmp = soldakiDugum.ileri;
                Dugum sagdakiDugum = tmp.ileri;
                tmp.ileri = null;
                soldakiDugum.ileri = null;
                soldakiDugum.ileri = sagdakiDugum;
            } else if (indis == 1) {
                bastanSil();
            } else {
                sondanSil();
            }
        }
    }

    public void sondanSil() {
        if (bosMu()) {
            System.out.println("Zaten Boş");
        } else {
            if (bas == son) {
                bas = null;
                son = null;
            } else {
                Dugum tmp = bas;
                while (tmp.ileri != son) {
                    tmp = tmp.ileri;
                }
                tmp.ileri = null;
                son = tmp;
            }
        }
    }

    public void toBinary(int sayi) {
        while (sayi > 0) {
            int kalan = sayi % 2;
            sonaEkle(kalan);
            sayi = sayi / 2;
        } 
        
    }

    public ListeIslemleri topla(ListeIslemleri x, ListeIslemleri y) {
        ListeIslemleri dondurulecekListe = new ListeIslemleri();
        Dugum d5 = new Dugum(0);
        int elde = 0;
        while (x.elemanSayisi() < y.elemanSayisi()) {
            x.sonaEkle(0);
        }
        while (x.elemanSayisi() > y.elemanSayisi()) {
            y.sonaEkle(0);
        }
        Dugum d1 = x.bas;
        Dugum d2 = y.bas;
        for (int i = 0; i < x.elemanSayisi(); i++) {
            int toplam = d1.veri + d2.veri + elde;
            switch (toplam) {
                case 1:
                    elde = 0;
                    toplam = 1;
                    break;
                case 2:
                    elde = 1;
                    toplam = 0;
                    break;
                case 3:
                    elde = 1;
                    toplam = 1;
                    break;
                default:
                    elde = 0;
                    toplam = 0;
                    break;
            }
            d5.veri = toplam;
            dondurulecekListe.sonaEkle(d5.veri);
            d1 = d1.ileri;
            d2 = d2.ileri;
        }
        if (elde == 1) {
            dondurulecekListe.sonaEkle(1);
        }
        return dondurulecekListe;
    } 
    public void goster() {
        if (bosMu()) {
            System.out.println("Liste Boş");
        } else {
            Dugum a = bas;
            while (a != null) {
                System.out.print(a.veri + "->");
                a = a.ileri;
            }
            System.out.println("");
        }
    }
}
