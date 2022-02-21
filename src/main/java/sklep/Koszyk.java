package sklep;

import java.util.HashMap;
import java.util.Set;

public class Koszyk {
    private HashMap<Integer, PozycjaKoszyka> koszyk;

    public Koszyk() {
        this.koszyk = new HashMap<>();
    }

    public void dodajDoKoszyka(Produkt p) {
        PozycjaKoszyka znaleziony = koszyk.get(p.getId());
        if (znaleziony == null) {
            koszyk.put(p.getId(), new PozycjaKoszyka(p, 1));
        } else {
            znaleziony.dodajSztuke();
        }
    }


    @Override
    public String toString() {
        return "Koszyk{" +
                "koszyk=" + koszyk + " do zapłaty: " + obliczDoZapłaty() +
                '}';
    }


    int obliczDoZapłaty() {
        int sum = 0;
        Set<Integer> zbiorKluczy = koszyk.keySet();
        for (int key : zbiorKluczy) {
            PozycjaKoszyka p = koszyk.get(key);
            sum += p.getProdukt().getCena() * p.getIloscSztuk();
        }
        return sum;
    }
//Przykładowy komentarz