public abstract class Kwiatek {
    private Rabatka rabatka;
    private Wspolrzedne pole;

    public Kwiatek(){
        this.rabatka = null;
        this.pole = null;
    }

    public Kwiatek(Rabatka rabatka, Wspolrzedne pole){
        posadzNaRabatce(rabatka);
        posadzNaPolu(pole);
    }

    public void posadzNaRabatce(Rabatka rabatka){
        this.rabatka = rabatka;
    }

    public void posadzNaPolu(Wspolrzedne pole){
        this.pole = pole;
    }

    abstract void podlej();
}
