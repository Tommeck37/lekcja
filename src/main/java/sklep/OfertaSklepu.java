package sklep;

import java.util.ArrayList;

public class OfertaSklepu {
    private ArrayList<Produkt> oferta;

    public OfertaSklepu() {
        oferta = new ArrayList<Produkt>();
        oferta.add(new Produkt("Marchewka", 2, 1));
        oferta.add(new Produkt("Banan", 5,2));
        oferta.add(new Produkt("Coca-Cola", 8,3));
        oferta.add(new Produkt("Chleb", 4,4));


    }
    ArrayList<Produkt> pobierzOferte(){
        return oferta;
    }

    Produkt znajdzProdukt(int szukaneId){
        for (int i = 0; i < oferta.size(); i++) {
            Produkt p = oferta.get(i);
            if(p.getId()==szukaneId){
                return p;
            }

        }
        return null;
    }
}
//test gita