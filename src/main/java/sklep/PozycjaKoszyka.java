package sklep;

public class PozycjaKoszyka {
    private Produkt produkt;
    private int iloscSztuk;

    public PozycjaKoszyka(Produkt produkt, int iloscSztuk) {
        this.produkt = produkt;
        this.iloscSztuk = iloscSztuk;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public int getIloscSztuk() {
        return iloscSztuk;
    }

    public void dodajSztuke(){
        iloscSztuk = iloscSztuk +1;
    }

    @Override
    public String toString() {
        return "PozycjaKoszyka{" +
                "produkt=" + produkt +
                ", iloscSztuk=" + iloscSztuk +
                '}';
    }
}
