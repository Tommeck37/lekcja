package sklep;

public class Produkt {
    private String nazwa;
    private int cena;
    private int id;

    public String getNazwa() {
        return nazwa;
    }

    public int getCena() {
        return cena;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", id=" + id +
                '}';
    }

    public Produkt(String nazwa, int cena, int id) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.id = id;
    }
}
